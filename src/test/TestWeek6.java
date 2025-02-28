package test;
import Week6.Menu;
import Week6.lab1.ManageController;


public class TestWeek6 {

    public static void main(String[] args) {
        ManageController mc = new ManageController();

        Menu menu = new Menu();
        int option = 0;
        do{
            option = menu.menuLab();
            switch(option){
                case 1 ->{
                    int optionLab1 = 0;
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

            }
        }while (option < 3);


    }

}
