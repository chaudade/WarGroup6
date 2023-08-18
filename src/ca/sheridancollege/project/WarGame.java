/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Adeem
 */
public class WarGame extends Game {
    private Deck deck;
    private WarPlayer player1;
    private WarPlayer player2;

    public WarGame(String name, WarPlayer player1, WarPlayer player2) {
        super(name);
        this.player1 = player1;
        this.player2 = player2;
        this.deck = new Deck();
        deck.shuffle();
        dealCards();
    }

    private void dealCards() {
        while(deck.getSize() > 0) {
            player1.receiveCard(deck.draw());
            player2.receiveCard(deck.draw());
        }
    }

    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        String response;

        do {
            WarCard card1 = player1.playCard();
            WarCard card2 = player2.playCard();
            System.out.println(player1.getName() + " plays " + card1);
            System.out.println(player2.getName() + " plays " + card2);

            if (card1.getRank().getCardValue() > card2.getRank().getCardValue()) {
                player1.receiveCard(card1);
                player1.receiveCard(card2);
                System.out.println(player1.getName() + " wins this round.");
            } else if (card1.getRank().getCardValue() < card2.getRank().getCardValue()) {
                player2.receiveCard(card1);
                player2.receiveCard(card2);
                System.out.println(player2.getName() + " wins this round.");
            } else {
                // Handle the war logic here
                System.out.println("It's a war!");

                // For simplicity, let's just draw one more card for the war
                WarCard warCard1 = player1.playCard();
                WarCard warCard2 = player2.playCard();

                if (warCard1.getRank().getCardValue() > warCard2.getRank().getCardValue()) {
                    player1.receiveCard(card1);
                    player1.receiveCard(card2);
                    player1.receiveCard(warCard1);
                    player1.receiveCard(warCard2);
                    System.out.println(player1.getName() + " wins the war.");
                } else if (warCard1.getRank().getCardValue() < warCard2.getRank().getCardValue()) {
                    player2.receiveCard(card1);
                    player2.receiveCard(card2);
                    player2.receiveCard(warCard1);
                    player2.receiveCard(warCard2);
                    System.out.println(player2.getName() + " wins the war.");
                } else {
                    // Cards remain on the table and are lost if there's another tie.
                    System.out.println("War is tied. Cards are lost.");
                }
            }

            declareWinner();

            System.out.println("Do you want to play another round? (yes/no)");
            response = scanner.nextLine().toLowerCase();

            if (response.equals("yes")) {
                deck = new Deck();  // Reset the deck
                deck.shuffle();     // Shuffle the cards
                dealCards();        // Deal the cards again
            }

        } while (response.equals("yes"));

        System.out.println("Thanks for playing!");
    }

    @Override
    public void declareWinner() {
        if(player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getName() + " is leading!");
        } else if(player1.getHandSize() < player2.getHandSize()) {
            System.out.println(player2.getName() + " is leading!");
        } else {
            System.out.println("Both players are tied!");
        }
    }
}
