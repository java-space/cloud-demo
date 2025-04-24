package za.co.ufs.qwaqwa.cloud_demo.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.ufs.qwaqwa.cloud_demo.api.model.Student;
import za.co.ufs.qwaqwa.cloud_demo.api.model.StudentInput;
import za.co.ufs.qwaqwa.cloud_demo.entity.StudentEntity;
import za.co.ufs.qwaqwa.cloud_demo.exception.ResourceNotFoundException;
import za.co.ufs.qwaqwa.cloud_demo.mapper.StudentMapper;
import za.co.ufs.qwaqwa.cloud_demo.repository.StudentRepository;
import za.co.ufs.qwaqwa.cloud_demo.service.StudentService;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper = StudentMapper.INSTANCE;
    private final StudentRepository studentRepository;

    @Override
    public Student save(StudentInput request) {
        return mapper.internalToDto(
                studentRepository.save(
                        mapper.dtoToInternal(request)
                )
        );
    }

    @Override
    public Student findById(Integer id) {
        return mapper.internalToDto(
                studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"))
        );
    }

    @Transactional
    @Override
    public void update(Integer id, StudentInput request) {
        final StudentEntity existingEntity = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));

        existingEntity.setName(request.getName());
        existingEntity.setEmail(request.getEmail());
        existingEntity.setAge(request.getAge());
    }

    @Override
    public List<Student> findAll() {
        return mapper.internalsToDtos(studentRepository.findAll());
    }

    @Transactional
    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
