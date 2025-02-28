package Week6.lab1;

public class Worker {

    private String idWorker;
    private String name;
    private int age;
    private double salary;
    private String workLocation;

    public Worker(String idWorker, String name,int age , double salary, String workLocation) {
        this.age = age;
        this.idWorker = idWorker;
        this.name = name;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(String idWorker) {
        this.idWorker = idWorker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }


    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %-3d | %-10.2f | %-15s |", idWorker, name, age, salary, workLocation);
    }


}


