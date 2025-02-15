package Week4.lab1;

public class Student implements Comparable<Student> {
    private String id;
    private String StudentName;
    private String Semester;
    private String StudentCourse;

    public Student(String id, String studentName, String semester, String studentCourse) {
        this.id = id;
        StudentName = studentName;
        Semester = semester;
        StudentCourse = studentCourse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return StudentName;
    }


    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getStudentCourse() {
        return StudentCourse;
    }


    public void setStudentCourse(String studentCourse) {
        StudentCourse = studentCourse;
    }
    @Override
    public int compareTo(Student other) {
        return this.StudentName.compareTo(other.StudentName);
    }

    @Override
    public String toString() {
        return "Student:" + "id=" + id + ' ' + ", StudentName=" + StudentName + ' ' + ", Semester=" + Semester + ' ' + ", StudentCourse=" + StudentCourse + ' ';
    }
}
