package Week6.lab2;

class Contact {
    private int id;
    private String fullName;
    private String firstName;
    private String lastName;
    private String group;
    private String address;
    private String phone;

    public Contact(int id, String fullName, String group, String address, String phone) {
        this.id = id;
        this.fullName = fullName;
        String[] nameParts = fullName.split(" ", 2);
        this.firstName = nameParts[0];
        this.lastName = nameParts.length > 1 ? nameParts[1] : "";
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroup() {
        return group;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("| %-2d | %-20s | %-10s | %-10s | %-10s | %-15s | %-15s |", id, fullName, firstName, lastName, group, address, phone);
    }
}