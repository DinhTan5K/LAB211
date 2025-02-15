package Week4.lab2;

class Student extends Person {
    private int yearOfAdmission;
    private int entranceEnglishScore;

    public Student(String ID, String fullname, String phoneNumber, int yearOfBirth, String major,
                   int yearOfAdmission, int entranceEnglishScore) {
        super(ID, fullname, phoneNumber, yearOfBirth, major);
        this.yearOfAdmission = yearOfAdmission;
        this.entranceEnglishScore = entranceEnglishScore;
    }
}
