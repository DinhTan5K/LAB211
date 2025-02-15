package test;
import Week4.Menu;
import Week4.lab1.Student;
import Week4.lab1.StudentList;
import Week4.lab2.Controller;

public class TestWeek4 {
    public static void main(String[] args) {
        Input input = new Input();
        Controller controller = new Controller();

        StudentList sl = new StudentList();
        Menu menu = new Menu();
        int option;
        do{
            option = menu.menu();
            switch(option){
                case 2 -> controller.run();
                case 1 ->{
                    while(true)
                    {
                        System.out.println("-----------------MENU-----------------");
                        System.out.println("1. Add student");
                        System.out.println("2. Find and sort student by name");
                        System.out.println("3. Update/Delete student by ID");
                        System.out.println("4. Show student list");
                        System.out.println("5. Exit");
                        System.out.println("--------------------------------------");
                        System.out.print("Enter your choice: ");
                        int choice = input.getInt();
                        switch (choice)
                        {
                            case 1:
                                int dem = 0;
                                while(true)
                                {
                                    System.out.println("Enter student id");
                                    String id = input.getString();
                                    System.out.print("Enter student name: ");
                                    String name = input.getString();
                                    System.out.print("Enter semester: ");
                                    String semester = input.getString();
                                    System.out.print("Enter student course: ");
                                    String course;
                                    while (true){
                                        course = input.getString();
                                        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("C/C++") || course.equalsIgnoreCase(".Net")){
                                            break;
                                        }
                                        System.out.println("Course must be Java, C/C++ or .Net");
                                        System.out.print("Enter student course: ");
                                    }
                                    Student student = new Student(id, name, semester, course);
                                    if (sl.addStudent(student))
                                    {
                                        System.out.println("Add student successfully");
                                        dem++;
                                    }
                                    else
                                    {
                                        System.out.println("Add student failed");
                                    }
                                    if(dem >= 3)
                                    {
                                        System.out.print("Do you want to continue add student? (Y/N): ");
                                        String c = input.getString();
                                        if (c.equalsIgnoreCase("N"))
                                        {
                                            break;
                                        }
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Enter student name to find: ");
                                String name = input.getString();
                                sl.showStudent(sl.sortStudentByName(sl.findStudentByName(name)));
                                break;
                            case 3:
                                System.out.print("Enter student ID to update/delete: ");
                                String id = input.getString();
                                Student s = sl.findByID(id);
                                if(s!=null) {
                                    System.out.println("Student found: ");
                                    System.out.println(s);
                                    System.out.println("U. Update student");
                                    System.out.println("D. Delete student");
                                    System.out.print("Enter your choice: ");
                                    String ch = input.getString().toLowerCase();

                                    switch (ch) {
                                        case "u":
                                            System.out.print("Enter new student name: ");
                                            String name1 = input.getString();
                                            if (name1 != null && !name1.trim().isEmpty()) {
                                                s.setStudentName(name1);
                                            }
                                            System.out.print("Enter new semester: ");
                                            String semester = input.getString();
                                            if (semester != null && !semester.trim().isEmpty()) {
                                                s.setSemester(semester);
                                            }
                                            System.out.print("Enter new student course: ");
                                            String course = input.getString();
                                            if (course != null && !course.trim().isEmpty()) {
                                                s.setStudentCourse(course);
                                            }

                                            sl.updateStudent(s);
                                            System.out.println("Update student successfully");
                                            break;
                                        case "d":
                                            sl.deleteStudent(s);
                                            System.out.println("Delete student successfully");
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                    }
                                }
                                else
                                {
                                    System.out.println("Student not found");
                                }
                                break;
                            case 4:
                                sl.getCourseNumberReport();
                                break;
                            case 5:
                                System.out.println("Goodbye");
                                System.exit(0);
                            default:
                                System.out.println("Invalid choice");

                        }
                    }
                }
            }
        }while(option < 3);

    }
}
