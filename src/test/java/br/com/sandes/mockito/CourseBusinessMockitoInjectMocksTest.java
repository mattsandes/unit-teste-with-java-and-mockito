package br.com.sandes.mockito;

import br.com.sandes.business.CourseBusiness;
import br.com.sandes.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {

    //inicializando o mock sem instanciar a classe;
    @Mock
    CourseService mockService;

    //A classe mockService vai ser instanciado dentro dessa classe;
    @InjectMocks
    CourseBusiness business;

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    List<String> courses;

    @BeforeEach
    void setUp(){
        //business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock(){

        given(mockService.retrieveCourses("Leandro"))
                .willReturn(courses);

        //When (Act)
        var filteredCourses = business
                .retrieveCoursesRelatedToSpring("Leandro");

        //Then (Assert)
        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method")
    @Test
    void testCourseNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethod_deleteCourse(){

        given(mockService.retrieveCourses("Sandes"))
                .willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Sandes");

        verify(mockService)
                .deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService)
                .deleteCourse("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker");
        verify(mockService, never())
                .deleteCourse("REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker");
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method V2")
    @Test
    void testCourseNotRelatedToSpring_UsingMockitoVerify_ShouldCallMethod_deleteCourseV2(){

        given(mockService.retrieveCourses("Sandes"))
                .willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Sandes");

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";
        String architectureCourse = "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker";
        String restSpringCourse = "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker";

        then(mockService).should().deleteCourse(agileCourse);
        then(mockService).should().deleteCourse(architectureCourse);
        then(mockService).should(never()).deleteCourse(restSpringCourse);
    }

    @DisplayName("Delete Courses not Related to Spring Using Mockito should call Method V2")
    @Test
    void testCourseNotRelatedToSpring_CapturingArguments_ShouldCallMethod_deleteCourseV2(){

        given(mockService.retrieveCourses("Sandes"))
                .willReturn(courses);

        business.deleteCoursesNotRelatedToSpring("Sandes");

        String agileCourse = "Agile Desmistificado com Scrum, XP, Kanban e Trello";

        then(mockService).should(times(7)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(7));
    }
}