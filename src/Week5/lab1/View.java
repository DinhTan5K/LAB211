package Week5.lab1;

public class View {
    public void formatOffline(){
        System.out.println(String.format("\n| %-10s | %-30s | %-7s | %-12s | %-12s | %-15s |",
                "Course ID", "Course Name", "Credits", "Begin", "End", "Campus") +
                "\n|------------|--------------------------------|---------|--------------|--------------|-----------------|");
    }
    public void formatOnline(){
        System.out.println(String.format("\n| %-10s | %-30s | %-7s | %-15s | %-25s | %-15s |",
                "Course ID", "Course Name", "Credits", "Platform", "Instructors", "Note") +
                "\n|------------|--------------------------------|---------|-----------------|---------------------------|-----------------|");

    }
}
