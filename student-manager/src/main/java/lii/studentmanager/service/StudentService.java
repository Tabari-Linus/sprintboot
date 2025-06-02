package lii.studentmanager.service;

import lii.studentmanager.dto.StudentDto;
import lii.studentmanager.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student createStudent(StudentDto studentDto);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id, StudentDto studentDto);
    void deleteStudent(Long id);
    Page<Student> findAllStudentsPage(Pageable pageable);
    Page<Student> findByNameContaining(String name, Pageable pageable);
}
