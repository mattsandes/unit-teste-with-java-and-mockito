package br.com.sandes.service;

import java.util.List;

public interface CourseService {

    public List<String> retrieveCourses(String student);
    public void deleteCourse(String course);
}
