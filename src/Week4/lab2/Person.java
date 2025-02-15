package Week4.lab2;

class Person {
    protected String ID;
    protected String fullname;
    protected String phoneNumber;
    protected int yearOfBirth;
    protected String major;

    public Person() {}

    public Person(String ID, String fullname, String phoneNumber, int yearOfBirth, String major) {
        this.ID = ID;
        this.fullname = fullname;
        this.phoneNumber = phoneNumber;
        this.yearOfBirth = yearOfBirth;
        this.major = major;
    }

    public String getFullname() {
        return fullname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String toString() {
        return String.format("| %-6s | %-18.5s | %-15s | %-4d | %-23s |", ID, fullname, phoneNumber, yearOfBirth, major);
    }
}

