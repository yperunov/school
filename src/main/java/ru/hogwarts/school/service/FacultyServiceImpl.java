package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService{

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty readFaculty(long idRead) {
        return facultyRepository.findById(idRead).get();
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(long idDelete) {
        facultyRepository.deleteById(idDelete);
    }

    @Override
    public Collection<Faculty> getFacultyByColor(String colorFilter) {
        return facultyRepository.findAllByColor(colorFilter);
    }

    @Override
    public Collection<Faculty> allFaculty() {
        return facultyRepository.findAll();
    }

}
