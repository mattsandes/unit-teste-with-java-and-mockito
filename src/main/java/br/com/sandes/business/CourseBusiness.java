package br.com.sandes.business;

import br.com.sandes.service.CourseService;

import java.util.ArrayList;
import java.util.List;

//Essa classe sera o system under teste ou SUT;
public class CourseBusiness {

    //Essa parte funciona como se fosse o @autowired
    //essa classe tera uma dependencia de course serivce
    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student){

        var filteredCourses = new ArrayList<String>();

        if("Foo Bar".equals(student)){
            return filteredCourses;
        }

        var allCourses = service.retrieveCourses(student);

        for(String courses: allCourses){
            if(courses.contains("Spring")){
                filteredCourses.add(courses);
            }
        }

        return filteredCourses;
    }
}
