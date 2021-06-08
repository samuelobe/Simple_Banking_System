package com.samuelobe;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner inObj = new Scanner(System.in);
        Scanner enterNumberObj = new Scanner(System.in);
        Scanner enterPINObj = new Scanner(System.in);
        String input = "";
        String numberInput;
        String PINInput;
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
                    if (card == null) {
                        System.out.println("Card has not been created yet");
                    }
                    else{
                        while (true){
                            System.out.println("Enter your card number:");
                            numberInput = enterNumberObj.nextLine();
                            System.out.println("Enter your PIN:");
                            PINInput = enterPINObj.nextLine();
                            boolean correctValues = card.checkNumberAndPIN(numberInput, PINInput);
                            if (!correctValues){
                                System.out.println();
                                System.out.println("Wrong card number or PIN!");
                                System.out.println();
                            }
                            else{
                                System.out.println();
                                System.out.println("You have successfully logged in!");
                                break;
                            }
                        }

                    }
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
        int[] number = new int[16];
        number[0] = 4;
        for (int i = 1; i < 6; i++){
            number[i] = 0;
        }
        for (int i = 6; i < 16; i++) {
            number[i] = random.nextInt(10);
        }
        // Generate PIN number
        int[] PIN = new int[4];
        for (int i = 0; i < 4; i++) {
            PIN[i] = random.nextInt(4);
        }

        this.numberStr = convertToString(number);
        this.PINStr = convertToString(PIN);
    }

    private final String numberStr;
    private final String PINStr;

    private String convertToString(int[] num){
        StringBuilder str = new StringBuilder();
        for (int n:
                num) {
            str.append(n);
        }
        return str.toString();
    }


    public void printNumber() {
        System.out.println(numberStr);
    }

    public void printPIN() {
        System.out.println(PINStr);
    }

    public boolean checkNumberAndPIN(String cardNumber, String cardPIN){
        return cardNumber.equals(this.numberStr) && cardPIN.equals(this.PINStr);
    }
}