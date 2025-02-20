package Week5.lab1;

import java.sql.SQLOutput;

public class OnlineCourse extends Course {
    private String platForm;
    private String instructor;
    private String note;

    public OnlineCourse() {
        super();
        this.platForm = "";
        this.instructor = "";
        this.note = "";
    }


    public OnlineCourse(String courseID, String courseName, int credits, String platform, String instructors, String note) {
        super(courseID, courseName, credits);
        this.platForm = platform;
        this.instructor = instructors;
        this.note = note;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPlatForm() {
        return platForm;
    }

    public void setPlatForm(String platForm) {
        this.platForm = platForm;
    }

    public String toString() {
        return String.format("| %-10s | %-30s | %-7d | %-15s | %-25s | %-15s |",
                        courseId , courseName, credits, platForm, instructor, note);
    }
}
