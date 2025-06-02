package lii.studentmanager.service;

import lii.studentmanager.dto.StudentDto;
import lii.studentmanager.entity.Student;
import lii.studentmanager.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(StudentDto studentDto){
        Student student = new Student(studentDto.getName(), studentDto.getAge(), studentDto.getEmail(), LocalDate.now());
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student updateStudent(Long id, StudentDto dto) {
        Student student = getStudentById(id);
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Page<Student> findAllStudentsPage(Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    @Override
    public Page<Student> findByNameContaining(String name, Pageable pageable) {
        studentRepository.findByNameContaining(name, pageable);
        return null;
    }

}
