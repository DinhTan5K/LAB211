package Week5.lab1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseController {
    private List<Course> courses = new ArrayList<>();
    private CourseView view = new CourseView();
    private Scanner scanner = new Scanner(System.in);

    public void addCourse() {
        String type;
        while (true) {
            System.out.print("Online (O) or Offline (F): ");
             type = scanner.nextLine().trim().toUpperCase();
            if (type.equals("O") || type.equals("F")) {
                break;
            }
            System.out.println("INPUT O or F");
        }
        String id;
        while (true) {
            System.out.print("Course ID: ");
            id = scanner.nextLine();
            boolean isDuplicate = false;

            for (Course c : courses) {
                if (c.getCourseID().equalsIgnoreCase(id)) {
                    System.out.println("Data input is invalid, ID must be unique");
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                break;
            }
        }

        System.out.print("Course Name: ");
        String name = scanner.nextLine();

        System.out.print("Credits: ");
        int credits = Integer.parseInt(scanner.nextLine());

        if (type.equals("O")) {
            System.out.print("Platform: ");
            String platform = scanner.nextLine();

            System.out.print("Instructors: ");
            String instructors = scanner.nextLine();

            System.out.print("Note: ");
            String note = scanner.nextLine();

            courses.add(new OnlineCourse(id, name, credits, platform, instructors, note));

        } else if (type.equals("F")) {
            System.out.print("Begin date (yyyy-mm-dd): ");
            LocalDate begin = LocalDate.parse(scanner.nextLine());

            System.out.print("End date (yyyy-mm-dd): ");
            LocalDate end = LocalDate.parse(scanner.nextLine());

            if (end.isBefore(begin)) {
                System.out.println("Data input is invalid, end must be after begin");
                return;
            }

            System.out.print("Campus: ");
            String campus = scanner.nextLine();

            courses.add(new OfflineCourse(id, name, credits, begin, end, campus));
        }
        System.out.println("Course added successfully!");
    }

    public void printAllCourses() {

        System.out.println("=========== ONLINE COURSES ===========");
        System.out.println(String.format("\n| %-10s | %-30s | %-7s | %-15s | %-25s | %-15s |",
                "Course ID", "Course Name", "Credits", "Platform", "Instructors", "Note") +
                "\n|------------|--------------------------------|---------|-----------------|---------------------------|-----------------|");

        for (Course course : courses) {
            if (course instanceof OnlineCourse) {
                System.out.println(course);
            }
        }


        System.out.println("\n=========== OFFLINE COURSES ===========");
        System.out.println(String.format("\n| %-10s | %-30s | %-7s | %-12s | %-12s | %-15s |",
                "Course ID", "Course Name", "Credits", "Begin", "End", "Campus") +
                "\n|------------|--------------------------------|---------|--------------|--------------|-----------------|");

        for (Course course : courses) {
            if (course instanceof OfflineCourse) {
                System.out.println(course);
            }
        }
    }


    public void printOnlineCourses() {
        System.out.print("ONLINE COURSE");
        System.out.println(String.format("\n| %-10s | %-30s | %-7s | %-15s | %-25s | %-15s |",
                "Course ID", "Course Name", "Credits", "Platform", "Instructors", "Note") +
                "\n|------------|--------------------------------|---------|-----------------|---------------------------|-----------------|");
        for (Course course : courses) {
            if(course instanceof OnlineCourse) {
                System.out.println(course);
            }
        }
    }

    public void printOfflineCourses() {
        System.out.print("OFFLINE COURSE");
        System.out.println(String.format("\n| %-10s | %-30s | %-7s | %-12s | %-12s | %-15s |",
                "Course ID", "Course Name", "Credits", "Begin", "End", "Campus") +
                "\n|------------|--------------------------------|---------|--------------|--------------|-----------------|");
        for (Course course : courses) {
            if(course instanceof OfflineCourse) {
                System.out.println(course);
            }
        }
    }

    public void searchCourse() {
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Course c : courses) {
            if (c.courseName.equalsIgnoreCase(name)) {
                System.out.println(c);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No course found!");
        }
    }

    public void deleteCourse() {
        System.out.print("Enter Course ID to delete: ");
        String id = scanner.nextLine();
        courses.removeIf(c -> c.getCourseID().equalsIgnoreCase(id));
        System.out.println("Course deleted successfully!");
    }

    public void updateCourse() {
        Scanner scanner = new Scanner(System.in);
        Course courseToUpdate;
        while (true) {
            System.out.print("Course ID: ");
            String id = scanner.nextLine().trim();


           courseToUpdate = null;
            for (Course c : courses) {
                if (c.getCourseID().equalsIgnoreCase(id)) {
                    courseToUpdate = c;
                    break;
                }
            }

            if (courseToUpdate == null) {
                System.out.print("No data found, do you want to find again? (Y/N): ");
                String choice = scanner.nextLine().trim().toUpperCase();
                if (!choice.equals("Y")) {
                    return;
                }
            } else {
                break;
            }
        }


        System.out.println("*** Search results ***");
        System.out.println(courseToUpdate);

        System.out.println("*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");


        System.out.print("Course ID: ");
        String newID = scanner.nextLine().trim();
        if (!newID.isEmpty()) courseToUpdate.setCourseId(newID);

        System.out.print("Course name: ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) courseToUpdate.setCourseName(newName);

        System.out.print("Credits: ");
        String newCredits = scanner.nextLine().trim();
        if (!newCredits.isEmpty()) courseToUpdate.setCredits(Integer.parseInt(newCredits));


        if (courseToUpdate instanceof OnlineCourse) {
            OnlineCourse online = (OnlineCourse) courseToUpdate;

            System.out.print("Platform: ");
            String newPlatform = scanner.nextLine().trim();
            if (!newPlatform.isEmpty()) online.setPlatForm(newPlatform);

            System.out.print("Instructors: ");
            String newInstructors = scanner.nextLine().trim();
            if (!newInstructors.isEmpty()) online.setInstructor(newInstructors);

            System.out.print("Note: ");
            String newNote = scanner.nextLine().trim();
            if (!newNote.isEmpty()) online.setNote(newNote);
        }


        if (courseToUpdate instanceof OfflineCourse) {
            OfflineCourse offline = (OfflineCourse) courseToUpdate;
            while (true) {
                System.out.print("Begin (dd/MM/yyyy): ");
                String newBegin = scanner.nextLine().trim();
                LocalDate parsedBeginDate = null;

                if (!newBegin.isEmpty()) {
                    try {
                        parsedBeginDate = LocalDate.parse(newBegin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        offline.setBegin(parsedBeginDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
                        continue;
                    }
                }

                System.out.print("End (dd/MM/yyyy): ");
                String newEnd = scanner.nextLine().trim();
                LocalDate parsedEndDate = null;

                if (!newEnd.isEmpty()) {
                    try {
                        parsedEndDate = LocalDate.parse(newEnd, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        offline.setEnd(parsedEndDate);
                    } catch (DateTimeParseException e) {
                        System.out.println("Ngày nhập không hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
                        continue;
                    }
                }


                if (parsedBeginDate != null && parsedEndDate != null) {
                    if (parsedEndDate.isBefore(parsedBeginDate)) {
                        System.out.println("Ngày kết thúc phải sau ngày bắt đầu. Vui lòng nhập lại.");
                        continue;
                    }
                }

                break;
            }


            System.out.print("Campus: ");
            String newCampus = scanner.nextLine().trim();
            if (!newCampus.isEmpty()) offline.setCampus(newCampus);
        }

        System.out.println("Updated successfully");
    }

}

