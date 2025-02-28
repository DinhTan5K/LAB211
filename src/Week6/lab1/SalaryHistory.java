package Week6.lab1;

class SalaryHistory {
    private String workerID;
    private double amount;
    private String type;
    private String date;

    // Constructor
    public SalaryHistory(String workerID, double amount, String type, String date) {
        this.workerID = workerID;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public String getWorkerID() {
        return workerID;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {

        return String.format("| %-10s | %-10.2f | %-10s | %-12s |", workerID, amount, type, date);
    }

}
