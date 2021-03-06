package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student,Long> {

    Collection<Student> findAllByAge(Integer ageFilter);

    Collection<Student> findAllByAgeBetween(Integer ageMin, Integer ageMax);

    Collection<Student> findStudentByFacultyId(Long facultyId);

}
