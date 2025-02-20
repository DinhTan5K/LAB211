package Week5.lab1;

import java.time.LocalDate;

public class OfflineCourse extends Course {
    private LocalDate begin;
    private LocalDate end;
    private String campus;


    public OfflineCourse() {
        super();
        this.begin = null;
        this.end = null;
        this.campus = "";
    }


    public OfflineCourse(String courseID, String courseName, int credits, LocalDate begin, LocalDate end, String campus) {
        super(courseID, courseName, credits);
        this.begin = begin;
        this.end = end;
        this.campus = campus;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {

        return String.format("| %-10s | %-30s | %-7d | %-12s | %-12s | %-15s |",
                        courseId, courseName, credits, begin, end, campus);
    }
}
