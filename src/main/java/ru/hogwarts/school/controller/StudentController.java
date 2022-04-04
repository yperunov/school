package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{idRead}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long idRead) {
        Student studentGet = studentService.readStudent(idRead);
        if (studentGet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentGet);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student studentCreate = studentService.createStudent(student);
        if (studentCreate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentCreate);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent (@RequestBody Student student) {
        Student studentEdit = studentService.updateStudent(student);
        if (studentEdit == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(studentEdit);
    }


    @DeleteMapping("{idDelete}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long idDelete) {
        Student studentDelete = studentService.deleteStudent(idDelete);
        if (studentDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentDelete);
    }

    @GetMapping("age/{age}")
    public Collection<Student> getStudentByAge(@PathVariable int age) {
        return studentService.getStudentByAge(age);
    }

//    Вопрос ментору на разбор. почему обертка класса ResponseEntity на классе Collection<Student> выдает NullPointerException и как эту ошибку обойти?
//    @GetMapping("age/{age}")
//    public ResponseEntity<Collection<Student>> getStudentByAge(@PathVariable int age) {
//        Collection<Student> studentCollection = studentService.getStudentByAge(age);
//        if (studentCollection == null) {
//            return ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok(studentCollection);
//    }

    @GetMapping("all")
    public Collection<Student> allStudent() {
        return studentService.allStudent();
    }
}
