package com.samuelobe;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner inObj = new Scanner(System.in);
        String input = "";
        Card card = null;

        while(!(input.equals("0"))){
            printPrompt();
            input = inObj.nextLine();
            switch (input) {
                case "1" -> {
                    System.out.println();
                    if (card == null) {
                        System.out.println("Your card has been created");
                        card = new Card();
                        System.out.println("Your card number:");
                        card.printNumber();
                        System.out.println("Your card PIN:");
                        card.printPIN();
                    } else {
                        System.out.println("Card already created!");
                    }
                    System.out.println();

                }
                case "2" -> {
                    System.out.println();
                    System.out.println("Enter your card number:");
                    System.out.println("Enter your PIN:");
                    System.out.println();
                }
                case "0" -> System.out.println("\nBye!");
            }
        }
    }

    private static void printPrompt(){
        System.out.println("1. Create an account");
        System.out.println("2. Log into account");
        System.out.println("0. Exit");
    }


}

class Card {
    Card(){
        Random random = new Random();
        // Generate Card number
        this.number = new int[16];
        this.number[0] = 4;
        for (int i = 1; i < 6; i++){
            this.number[i] = 0;
        }
        for (int i = 6; i < 16; i++) {
            this.number[i] = random.nextInt(10);
        }
        // Generate PIN number
        this.PIN = new int[4];
        for (int i = 0; i < 4; i++) {
            this.PIN[i] = random.nextInt(4);
        }
    }

    private int[] number;
    private int[] PIN;

    public void printNumber() {
        StringBuilder str = new StringBuilder();
        for (int n:
             this.number) {
            str.append(n);
        }
        System.out.println(str);
    }

    public void printPIN() {
        StringBuilder str = new StringBuilder();
        for (int n:
                this.PIN) {
            str.append(n);
        }
        System.out.println(str);
    }

    public boolean checkNumberAndPIN(String cardNumber, String cardPIN){

        return false;
    }
}


