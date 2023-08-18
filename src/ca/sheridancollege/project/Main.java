/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Adeem
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for player names
        System.out.println("Enter the name of Player 1:");
        String player1Name = scanner.nextLine();

        System.out.println("Enter the name of Player 2:");
        String player2Name = scanner.nextLine();

        // Create players and the game
        WarPlayer player1 = new WarPlayer(player1Name);
        WarPlayer player2 = new WarPlayer(player2Name);
        WarGame game = new WarGame("Card Game War", player1, player2);

        // Play the game
        game.play();
    }
}