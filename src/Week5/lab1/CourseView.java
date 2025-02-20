package Week5.lab1;

import java.util.List;

public class CourseView {
    public void displayCourses(List<Course> courses) {
        for (Course course : courses) {
//            System.out.println(course);
            if(course instanceof OfflineCourse){
                System.out.println(course);
            } else if(course instanceof OnlineCourse){
                System.out.println(course);
            }

        }
    }
}
