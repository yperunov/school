package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.*;

@Service
public class FacultyServiceImpl implements FacultyService {

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
        return null;
    }

//    @Override
//    public Collection<Faculty> getFacultyByColor(String colorFilter) {
//        final Map<Long, Faculty> facultyMapFilteredByColor = new HashMap<>();
//        Long facultyId = 0L;
//        for (Long i = 1L; i < 1L*(facultyMap.size())+1L; i++) {
//            if (facultyMap.get(i).getColor().equals(colorFilter)) {
//                facultyMapFilteredByColor.put(facultyId, facultyMap.get(i));
//                facultyId++;
//            }
//        }
//        return Collections.unmodifiableCollection(facultyMapFilteredByColor.values());
//    }

    @Override
    public Collection<Faculty> allFaculty() {
        return facultyRepository.findAll();
    }
}
