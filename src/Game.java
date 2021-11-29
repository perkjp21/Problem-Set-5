import java.util.Random;

public class Game {
    private int playerTotal;
    private int houseTotal;

    public Game() {
    }

    public void resetDeck(int[][] deck) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                deck[i][j] = j + 1;
                // 1 exists
                // 2 doesn't exist

                // spades: 1111111111111
                // clubs: 1111111111111
                // hearts: 1111111111111
                // diamonds: 1111111111111

                // 11: jack
                // 12: queen
                // 13: king
                // 1: ace
                // every other number: itself
            }
        }
    }

    public void printDeck(int[][] deck) {
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                System.out.print("Spades: ");
            } else if (i == 1) {
                System.out.print("Clubs: ");
            } else if (i == 2) {
                System.out.print("Hearts: ");
            } else if (i == 3) {
                System.out.print("Diamonds:");
            }

            for (int j = 0; j < 13; j++) {
                System.out.print(deck[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int returnActualCard(int[][] deck) {
        Random rndm = new Random();
        int randSuit;
        int randNum;

        randSuit = rndm.nextInt(3) + 1;
        randNum = rndm.nextInt(12) + 1;

        while (true) {
            if (deck[randSuit][randNum] != 0) {
                deck[randSuit][randNum] = 0;
                break;
            } else {
                randSuit = rndm.nextInt(3) + 1;
                randNum = rndm.nextInt(12) + 1;
            }
        }
        return randNum;
    }

    public int cardBJValue(int randNum) {
        int finalInt;
        if (randNum == 10 || randNum == 11 || randNum == 12 || randNum == 13) {
            finalInt = 10;
        } else {
            finalInt = randNum;
        }
        return finalInt;
    }

    public void deal(int initialCard, int playerTotal, int houseTotal, int[][] deck) {

    }

    public int seeIfResult(int playerTotal) {
        if (playerTotal == 21) {
            return 3; // bj
        } else if (playerTotal > 21) {
            return 2; // bust
        } else {
            return 1; // keep playing
        }
    }

}
