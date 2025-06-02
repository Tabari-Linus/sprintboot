package lii.springdata.controller;

import lii.springdata.entity.Student;
import lii.springdata.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    public final StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setRegistrationDate(LocalDate.now());
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @GetMapping("/search/byName")
    public List<Student> findByName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    @GetMapping("/search/byAgeRange")
    public List<Student> findByAgeRange(@RequestParam int min, @RequestParam int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    @GetMapping("/paged")
    public Page<Student> getPagedStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return studentRepository.findAll(pageable);
    }

    @GetMapping("/search/byNamePaged")
    public Page<Student> searchByNamePaged(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findByNameContaining(name, pageable);
    }



}
