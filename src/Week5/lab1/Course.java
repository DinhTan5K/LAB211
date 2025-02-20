package Week5.lab1;

public class Course {
    protected String courseId;
    protected String courseName;
    protected int credits;


    public Course() {
        this.courseId = "";
        this.courseName = "";
        this.credits = 0;
    }
    
    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public String getCourseID() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String toString() {
        return String.format("\n| %-10s | %-30s | %-7s |", "Course ID", "Course Name", "Credits") +
                "\n|------------|--------------------------------|---------|" +
                String.format("\n| %-10s | %-30s | %-7d |", courseId, courseName, credits);
    }

}
