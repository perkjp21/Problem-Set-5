import java.util.Scanner;
import java.util.Random;

public class BlackJack {
    static boolean playerStillPlaying = true;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Random rndm = new Random();
        Game game = new Game();
        int playerTotal = 0;
        int houseTotal = 0;
        int playerCard1, playerCard2, houseCard1, houseCard2, card;
        int result;
        char response;


        int[][] deck = new int[4][13];

        game.resetDeck(deck);
        // begin game, will make into method in a little
        houseCard1 = game.returnActualCard(deck);
        houseTotal += game.cardBJValue(houseCard1);
        playerCard1 = game.returnActualCard(deck); // first card
        playerTotal += game.cardBJValue(playerCard1);
        houseCard2 = game.returnActualCard(deck);
        houseTotal += game.cardBJValue(houseCard2);
        playerCard2 = game.returnActualCard(deck); // second card
        playerTotal += game.cardBJValue(playerCard2);

        // will add specifics later


        System.out.println("player has: " + playerCard1 + ", " + playerCard2 + " with a total of " + playerTotal);
        System.out.println("house is showing " + houseCard1);
        result = game.seeIfResult(playerTotal);
        if (result == 1) {
            System.out.println("Type h for hit or s for stay");
        } else if (result == 3) {
            System.out.println("Blackjack!");
            // technically could be situation where dealer has bj as well but will deal with that later
        }
        response = scnr.next().charAt(0);
        while (true) {
            if (response == 'h') {
                card = game.returnActualCard(deck);
                playerTotal += game.cardBJValue(card);
                result = game.seeIfResult(playerTotal);
                if (result == 1) {
                    System.out.println("You got a " + card + "you now have " + playerTotal);
                    System.out.println("Type h for hit or s for stay");
                    response = scnr.next().charAt(0);
                } else if (result == 2) {
                    System.out.println("You busted with " + playerTotal + ". Dealer Wins");
                    System.out.println("Would you like to play again?");
                    response = scnr.next().charAt(0);

                } else if (result == 3) {
                    System.out.println("21");
                    // technically could be situation where dealer has bj as well but will deal with that later
                    System.out.println("would you like to play again?");
                }
            } else if (response == 's') {
                // dealers turn
                // reveals card
                // will continue hitting until
            }
        }





    }
}
