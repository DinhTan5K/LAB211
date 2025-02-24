package Week5.lab2;

import java.util.Scanner;

import java.util.Scanner;

class ReservationView {
    private Scanner scanner = new Scanner(System.in);

    public String getInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    public String getInput(String message, int number) {
        String string = getInput(message);
        while(true){
            if(string.length() != number){
                System.out.println("Data input is invalid");
                string = getInput(message);
            } else {
                break;
            }
        }
        return string;
    }

    public String getInput(String message, String regex) {
        String string = getInput(message);
        while(true){
            if(!string.matches(regex)){
                System.out.println("Data input is invalid");
                string = getInput(message);
            } else {
                break;
            }
        }
        return string;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void printReservations(java.util.List<Reservation> reservations) {
        System.out.println("*** Reservation Information ***");
        for (Reservation r : reservations) {
            System.out.printf("%s - %s - %s - %s - %s",
                    r.getBookingID(), r.getCustomerName(), r.getPhoneNumber(),
                    r.getRoomNumber(), r.getBookingDate());

            if (r.getFlightInfo() != null) {
                System.out.printf(" - %s - %s - %s",
                        r.getFlightInfo().getFlightNumber(), r.getFlightInfo().getSeatNumber(),
                        r.getFlightInfo().getTimePickUp());
            }
            System.out.println();
        }
    }
}


