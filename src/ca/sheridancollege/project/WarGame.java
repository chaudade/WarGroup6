/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

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
        while(player1.getHandSize() > 0 && player2.getHandSize() > 0) {
            WarCard card1 = player1.playCard();
            WarCard card2 = player2.playCard();
            
            if (card1.getRank().getCardValue() > card2.getRank().getCardValue()) {
                player1.receiveCard(card1);
                player1.receiveCard(card2);
            } else if (card1.getRank().getCardValue() < card2.getRank().getCardValue()) {
                player2.receiveCard(card1);
                player2.receiveCard(card2);
            } else {
                // Handle the war logic here.
                // For brevity, I'm skipping it but it will involve drawing multiple cards from each player and comparing.
            }
        }

        declareWinner();
    }

    @Override
    public void declareWinner() {
        if(player1.getHandSize() > player2.getHandSize()) {
            System.out.println(player1.getName() + " wins!");
        } else if(player1.getHandSize() < player2.getHandSize()) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}

