package za.co.ufs.qwaqwa.cloud_demo.service;

import za.co.ufs.qwaqwa.cloud_demo.api.model.Student;
import za.co.ufs.qwaqwa.cloud_demo.api.model.StudentInput;

import java.util.List;


public interface StudentService {

    Student save(StudentInput request);

    Student findById(Integer id);

    void update(Integer id, StudentInput request);

    List<Student> findAll();

    void deleteStudent(Integer id);
}
