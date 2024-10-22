package org.example.rampup;


import org.example.rampup.Configuration.AppConfig;
import org.example.rampup.Model.Course;
import org.example.rampup.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

   // @Autowired
   //public CourseService courseService;

    public static void main(String[] args) {

      //  ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
       ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Course c= context.getBean(Course.class);
//c.display();
//        System.out.println("Hello world!");


        CourseService cs= context.getBean(CourseService.class);

       // Main main=new Main();
        System.out.printf("courses" + cs.getCourses() );



    }
}