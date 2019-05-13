package com.lambdaschool.school;

import com.lambdaschool.school.model.Course;
import com.lambdaschool.school.service.CourseService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SchoolApplication.class)
public class SchoolApplicationTests
{

    @Autowired
    private CourseService courseService;

    private List<Course> courseList;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void contextLoads()
    {
    }

    @Test
    public void findCourseById()
    {
        assertNotNull(courseService.findCourseById(1));
    }

    @Test
    public void deleteFound()
    {
        courseService.delete(1);
        assertEquals(5, courseService.findAll().size());
    }

    @Test(expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        courseService.delete(100);
        assertEquals(6, courseService.findAll().size());
    }

    @Test
    public void findAll()
    {
        assertEquals(6, courseService.findAll().size());
    }

    // @Test
    // public void listAllCourses() throws Exception
    // {
    //     String apiUrl = "/courses/courses";
    //
    //     Mockito.when(courseService.findAll());
    //
    //     RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
    //
    // }

}
