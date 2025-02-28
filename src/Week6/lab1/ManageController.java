package Week6.lab1;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ManageController {
        private Scanner sc = new Scanner(System.in);
        private ArrayList salaryHistory = new ArrayList();
        private SQLServerDataSource ds = new SQLServerDataSource();
        private ArrayList<Worker> workers = new ArrayList<>();
        private ArrayList<SalaryHistory> increaseSalaryHistory = new ArrayList<>();
    public void addWorker(){
        ds.setTrustServerCertificate(true);
        ds.setUser("sa");
        ds.setPassword("1234");
        ds.setServerName("LAPTOP-6BUQRB4T");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Worker");

        PreparedStatement ps;
        ResultSet resultSet;
        String id;
        while(true) {
            System.out.print("ID: ");
            id = sc.nextLine();
            boolean isDuplicate = false;
            try (Connection con = ds.getConnection()) {

                String selectSQL = "SELECT id FROM manageWorkers";
                ps = con.prepareStatement(selectSQL);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    if (resultSet.getString("id").equals(id)) {
                        System.out.println("DUPLICATE ID");
                        isDuplicate = true;
                        break;
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            if (!isDuplicate) {
                break;
            }
        }
        System.out.print("Name: ");
        String name = sc.nextLine();
        int age;
        while( true ){
            System.out.print("Age: ");
            age = sc.nextInt();
            if(50 < age || age < 18){
                System.out.println("INVALID");
            } else {
                break;
            }
        }
        double salary;
        while(true){
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            if(salary < 0){
                System.out.println("INVALID");
            }else {
                break;
            }

        }
        sc.nextLine();
        System.out.print("Work Location: ");
        String location = sc.nextLine();


        try(Connection con = ds.getConnection()) {
            String insertSQL = "INSERT INTO manageWorkers (id,name,age,salary,work_location) VALUES (?,?,?,?,?)";
            ps = con.prepareStatement(insertSQL);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setBigDecimal(4, new BigDecimal(salary));
            ps.setString(5, location);
            ps.executeUpdate();
            System.out.println("[Valid]");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        workers.add(new Worker(id,name,age,salary,location));

    }

    public void increaseSalary() {
        System.out.println("========= Increase Salary =========");
        String id;
        Worker selectedWorker = null;

        while (true) {
            System.out.print("ID: ");
            id = sc.nextLine();


            for (Worker w : workers) {
                if (w.getIdWorker().equals(id)) {
                    selectedWorker = w;
                    break;
                }
            }


            if (selectedWorker == null) {
                String choice;
                do {
                    System.out.print("Invalid ID , wanna input again? (Y/N): ");
                    choice = sc.nextLine().trim().toUpperCase();
                } while (!choice.equals("Y") && !choice.equals("N"));

                if (choice.equals("N")) {
                    System.out.println("EXIT");
                    return;
                }
            }else {
                break;
            }
        }

        double salaryIncrease;
        while (true) {
            System.out.print("Salary you want to increase: ");
            salaryIncrease = sc.nextDouble();
            if (salaryIncrease > 0) {
                break;
            } else {
                System.out.println("Must be greater than 0. Please re-enter!");
            }
        }

        selectedWorker.setSalary(selectedWorker.getSalary() + salaryIncrease);
        sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        String dateIncrease;
        while (true) {
            try {
                System.out.print("Date Increase (dd-MM-yyyy): ");
                dateIncrease = sc.nextLine();
                dateFormat.parse(dateIncrease);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid Date! Please re-enter.");
            }
        }


        increaseSalaryHistory.add(new SalaryHistory(id,salaryIncrease, "INCREASE", dateIncrease));
        System.out.println("Increase Successfully!");
    }

    public void decreaseSalary() {
        System.out.println("========= Decrease Salary =========");
        String id;
        Worker selectedWorker = null;


        do {
            System.out.print("ID: ");
            id = sc.nextLine().trim();

            for (Worker w : workers) {
                if (w.getIdWorker().equals(id)) {
                    selectedWorker = w;
                    break;
                }
            }

            if (selectedWorker == null) {
                String choice;
                do {
                    System.out.print("Invalid ID , wanna input again? (Y/N): ");
                    choice = sc.nextLine().trim().toUpperCase();
                } while (!choice.equals("Y") && !choice.equals("N"));

                if (choice.equals("N")) {
                    System.out.println("EXIT");
                    return;
                }
            }
        } while (selectedWorker == null);

        double decreaseAmount;
        while (true) {
            System.out.print("Salary you want to decrease: ");
            decreaseAmount = sc.nextDouble();

            if (decreaseAmount <= 0) {
                System.out.println("Must be greater than 0. Enter again!");
            } else if (decreaseAmount > selectedWorker.getSalary()) {
                System.out.println("Cannot reduce beyond current salary! Please re-enter.");
            } else {
                break;
            }
        }
        sc.nextLine();


        selectedWorker.setSalary(selectedWorker.getSalary() - decreaseAmount);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        String dateDECREASE;

        while (true) {
            try {
                System.out.print("Date Decrease (dd-MM-yyyy): ");
                dateDECREASE = sc.nextLine().trim();
                Date date = dateFormat.parse(dateDECREASE);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid Date! Please re-enter.");
            }
        }

        increaseSalaryHistory.add(new SalaryHistory(id,decreaseAmount, "DECREASE", dateDECREASE));

        System.out.println("Decrease Successfully!");
    }



    public void displaySalaryHistory() {
        System.out.println("======== Salary Adjustment History ========");

        if (increaseSalaryHistory.isEmpty()) {
            System.out.println("NONE.");
            return;
        }

        System.out.println("+--------+---------------+--------------+------------+--------------+");
        System.out.println("|  ID    | Name          | Amount       | Type       | Date         |");
        System.out.println("+--------+---------------+--------------+------------+--------------+");

        for (SalaryHistory sh : increaseSalaryHistory) {
            String workerName = "";
            for (Worker w : workers) {
                if (w.getIdWorker().equals(sh.getWorkerID())) {
                    workerName = w.getName();
                    break;
                }
            }

            System.out.printf("| %-6s | %-13s | %-12.2f | %-10s | %-12s |\n",
                    sh.getWorkerID(), workerName, sh.getAmount(), sh.getType(), sh.getDate());
        }

        System.out.println("+--------+---------------+--------------+------------+--------------+");

    }
}
