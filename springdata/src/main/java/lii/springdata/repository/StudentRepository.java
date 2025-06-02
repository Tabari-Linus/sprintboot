package lii.springdata.repository;

import lii.springdata.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);

    List<Student> findByAgeBetween(int min, int max);

    @Query("SELECT s FROM Student s WHERE s.email LIKE %:keyword%")
    List<Student> searchByEmail(@Param("keyword") String keyword);


    List<Student> findByRegistrationDateAfter(LocalDate date);

    @Query(value = "SELECT * FROM student WHERE name LIKE ?1%", nativeQuery = true)
    List<Student> searchByNamePrefix(String prefix);

}
