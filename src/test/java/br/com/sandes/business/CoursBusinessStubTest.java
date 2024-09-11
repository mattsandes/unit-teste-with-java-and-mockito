package br.com.sandes.business;

import br.com.sandes.service.CourseService;
import br.com.sandes.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CourseBusinessTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub(){
        //Given (Arrange)
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When (Act)
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        //Then (Assert)
        assertEquals(filteredCourses.size(), 4);
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent(){
        //Given (Arrange)
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When (Act)
        var filteredCourses = business
                .retrieveCoursesRelatedToSpring("Foo Bar");

        //Then (Assert)
        assertEquals(0, filteredCourses.size());
    }

}