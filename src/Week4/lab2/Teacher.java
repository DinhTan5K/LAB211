package Week4.lab2;

class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher(String ID, String fullname, String phoneNumber, int yearOfBirth, String major,
                   int yearInProfession, String contractType, double salaryCoefficient) {
        super(ID, fullname, phoneNumber, yearOfBirth, major);
        this.yearInProfession = yearInProfession;
        this.contractType = contractType;
        this.salaryCoefficient = salaryCoefficient;
    }
}



