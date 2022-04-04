package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{idRead}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable Long idRead) {
        Faculty facultyGet = facultyService.readFaculty(idRead);
        if (facultyGet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyGet);
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty facultyCreate = facultyService.createFaculty(faculty);
        if (facultyCreate == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(facultyCreate);
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty facultyEdit = facultyService.updateFaculty(faculty);
        if (facultyEdit == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(facultyEdit);
    }

    @DeleteMapping("{idDelete}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long idDelete) {
        Faculty facultyDelete = facultyService.deleteFaculty(idDelete);
        if (facultyDelete == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(facultyDelete);
    }

//    @GetMapping("color/{color}")
//    public Collection<Faculty> getFacultyByColor(@PathVariable String color) {
//        return facultyService.getFacultyByColor(color);
//    }

//     Вопрос ментору на разбор. почему обертка класса ResponseEntity на классе Collection<Faculty> не выдает NullPointerException?
    @GetMapping("color/{color}")
    public ResponseEntity<Collection<Faculty>> getFacultyByColor(@PathVariable String color) {
        Collection<Faculty> facultyCollection = facultyService.getFacultyByColor(color);
        if (facultyCollection == null) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(facultyCollection);
    }

    @GetMapping("all")
    public Collection<Faculty> allFaculty() {
        return facultyService.allFaculty();
    }

}
