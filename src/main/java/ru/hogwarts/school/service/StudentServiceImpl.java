package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student studentCreate) {
        return studentRepository.save(studentCreate);
    }

    @Override
    public Student readStudent(long idRead) {
        return studentRepository.findById(idRead).get();
    }

    @Override
    public Student updateStudent(Student studentUpdate) {
        return studentRepository.save(studentUpdate);
    }


    @Override
    public void deleteStudent(long idDelete) {
        studentRepository.deleteById(idDelete);
    }

    @Override
    public Collection<Student> getStudentByAge(int ageFilter) {
        return null;
    }

//    @Override
//    public Collection<Student> getStudentByAge(int ageFilter) {
//        final Map<Long, Student> studentMapFilteredByAge = new HashMap<>();
//        Long studentId = 0L;
//        for (Long i = 1L; i < 1L*(studentMap.size())+1L; i++) {
//            if (studentMap.get(i).getAge() == ageFilter) {
//                studentMapFilteredByAge.put(studentId, studentMap.get(i));
//                studentId++;
//            }
//        }
//        return Collections.unmodifiableCollection(studentMapFilteredByAge.values());
//    }


    @Override
    public Collection<Student> allStudent() {
        return studentRepository.findAll();
    }
}
