package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty readFaculty(long idRead);

    Faculty updateFaculty(Faculty faculty);

    Faculty deleteFaculty(long idDelete);

    Collection<Faculty> getFacultyByColor(String colorFilter);

    Collection<Faculty> allFaculty();

}
