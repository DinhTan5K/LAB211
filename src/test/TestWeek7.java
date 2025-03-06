package test;

import Week7.lab1.FruitController;
import Week7.lab1.Menu;

public class TestWeek7 {
    public static void main(String[] args) {
        FruitController fruitController = new FruitController();
        Menu menu = new Menu();
        int choice;
        do {
                 choice = menu.menuLab();
            switch (choice) {
                case 1 ->  fruitController.addFruit();


                case 2 -> fruitController.viewOrders();


                case 3 -> fruitController.shopping();

                case 4 ->System.out.println("Exiting... Thank you for using the Fruit Shop System!");



            }
        } while (choice < 4);
    }
}
