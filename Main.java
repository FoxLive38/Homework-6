package Homework6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] products = { "Хлеб", "Молоко", "Сахор", "Гречка" };
        int[] price = { 50, 99, 74, 115 };
        int[] basket = new int[products.length];        

        showAssortiment(products, price);

        doDialogCustomer(scan, basket);

        showResult(products, price, basket);
        
    }

    public static void showAssortiment(String[] products, int[] price){
        System.out.println("Список возможных товаров для покупки:");
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d %s %d руб./штука \n", i + 1, products[i], price[i]);
        }
    }

    public static void doDialogCustomer(Scanner scan, int[] basket){
         while (true) {
            System.out.println("Выберите товар и количество или введите end");
            String input = scan.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] order = input.split(" ");
            int product = Integer.parseInt(order[0]) - 1;
            int coll = Integer.parseInt(order[1]);

            basket[product] += coll;
        }
    }

    public static void showResult(String[] products, int[] price, int[] basket){
        System.out.println("Ваша корзина:\n");
        int summ = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != 0) {
                int priceCount = price[i] * basket[i];
                System.out.printf(
                        "%s %d штук %d руб./штука %d руб в сумме \n",
                        products[i],
                        basket[i],
                        price[i],
                        priceCount);
                summ += priceCount;
            }
        }
        System.out.printf("Итого: %d руб", summ);
    }
}
