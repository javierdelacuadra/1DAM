package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Blackjack blackjack = new Blackjack();
        blackjack.blackjack(sc);
    }
}
