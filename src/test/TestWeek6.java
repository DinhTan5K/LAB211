package test;
import Week6.Menu;
import Week6.lab1.ManageController;
import Week6.lab2.ContactManager;

import java.util.Scanner;

public class TestWeek6 {

    public static void main(String[] args) {
        ManageController mc = new ManageController();
       ContactManager cm = new ContactManager();
        Menu menu = new Menu();
        int option = 0;
        do{
            option = menu.menuLab();
            switch(option){
                case 1 ->{
                    int optionLab1;
                    do{
                        optionLab1 = menu.menuLab1();
                        switch(optionLab1){
                            case 1 ->mc.addWorker();
                            case 2 -> mc.increaseSalary();
                            case 3 -> mc.decreaseSalary();
                            case 4 -> mc.displaySalaryHistory();

                        }
                    }while (optionLab1 < 5);
                }
                case 2 -> {
                    int optionLab2 ;
                    do{
                        optionLab2 = menu.menuLab2();
                        switch(optionLab2){
                            case 1 -> cm.addContact(new Scanner(System.in));
                            case 2 -> cm.displayAll();
                            case 3 -> cm.deleteContact(new Scanner(System.in));
                        }
                    }while (optionLab2 < 4);
                }

            }
        }while (option < 3);


    }

}
