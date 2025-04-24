package za.co.ufs.qwaqwa.cloud_demo.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import za.co.ufs.qwaqwa.cloud_demo.api.controller.StudentApiDelegate;
import za.co.ufs.qwaqwa.cloud_demo.api.model.Student;
import za.co.ufs.qwaqwa.cloud_demo.api.model.StudentInput;
import za.co.ufs.qwaqwa.cloud_demo.service.StudentService;

import java.util.List;

@ApiDelegate
@AllArgsConstructor
public class StudentApi implements StudentApiDelegate {

    private final StudentService studentService;

    @Override
    public ResponseEntity<Student> createStudent(StudentInput studentInput) {
        return ResponseEntity.ok(
                studentService.save(studentInput)
        );
    }

    @Override
    public ResponseEntity<Void> deleteStudent(Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(
                studentService.findAll()
        );
    }

    @Override
    public ResponseEntity<Student> getStudentById(Integer id) {
        return ResponseEntity.ok(
                studentService.findById(id)
        );
    }

    @Override
    public ResponseEntity<Void> updateStudent(Integer id, StudentInput studentInput) {
        studentService.update(id, studentInput);
        return ResponseEntity.noContent().build();
    }
}
