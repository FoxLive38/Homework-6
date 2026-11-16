package Homework6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] products = { "Хлеб", "Молоко", "Сахор", "Гречка" };
        int[] price = { 50, 99, 74, 115 };

        if (products.length == price.length) {
            System.out.println("Список возможных товаров для покупки:");
            for (int i = 0; i < price.length; i++) {
                System.out.printf("%d %s %d руб./штука \n", i + 1, products[i], price[i]);
            }
        }

        int[] basket = new int[4];

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

        int summ = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != 0) {
                int priceCount = price[i] * basket[i];
                System.out.printf("%s %d штук %d руб./штука %d руб в сумме \n", products[i], basket[i], price[i],
                        priceCount);
                summ += priceCount;
            }
        }
        System.out.printf("Итого: %d руб", summ);
    }
}
