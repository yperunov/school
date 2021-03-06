package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student createStudent(Student student);

    Student readStudent(long idRead);

    Student updateStudent(Student student);

    void deleteStudent(long idDelete);

    Collection<Student> getStudentByAge(int ageFilter);

    Collection<Student> findByAgeBetween(int ageMin, int ageMax);

    Collection<Student> allStudent();

    Collection<Student> findByFacultyId(Long facultyID);

    Faculty findFacultyOfStudent(Long studentId);
}
