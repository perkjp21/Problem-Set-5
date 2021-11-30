import java.awt.*;
import java.util.Random;

public class Draw {
    Random rand = new Random();
    public void cardsDealt(int first, int second) {
        int suit;
        String card1;
        String card2;
        card1 = String.valueOf(first);
        card2 = String.valueOf(second);


        StdDraw.rectangle(1,2,1,1.5);
        StdDraw.rectangle(3.5,2,1,1.5);
        if (first == 11) {
            StdDraw.text(1, 1, "Q");
        }
        else if (first == 12) {
            StdDraw.text(1,1, "K");
        }
        else if (first == 13) {
            StdDraw.text(1,1, "A");
        }
        else if (first == 10) {
            int a = rand.nextInt(2);
            if (a % 2 == 0) {
                StdDraw.text(1,1, "J");
            }
            else {
                StdDraw.text(1,1, card1);
            }

        }
        else {
            StdDraw.text(1,1, card1);
        }

        if (second == 11) {
            StdDraw.text(3.5, 1, "Q");
        }
        else if (second == 12) {
            StdDraw.text(3.5,1, "K");
        }
        else if (second == 13) {
            StdDraw.text(3.5,1, "A");
        }
        else if (second == 10) {
            int a = rand.nextInt(2);
            if (a % 2 == 0) {
                StdDraw.text(3.5,1, "J");
            }
            else {
                StdDraw.text(3.5,1, card2);
            }
        }
        else {
            StdDraw.text(3.5,1, card2);
        }

    }

    public void dealerCards(int second) {
        String card2;

        card2 = String.valueOf(second);

        String filename ="cardBack.png";
        StdDraw.picture(1,8, filename, 2 ,3);

        StdDraw.rectangle(1,8,1,1.5);
        StdDraw.rectangle(3.5,8,1,1.5);

        if (second == 11) {
            StdDraw.text(3.5, 9, "Q");
        }
        else if (second == 12) {
            StdDraw.text(3.5,9, "K");
        }
        else if (second == 13) {
            StdDraw.text(3.5,9, "A");
        }
        else if (second == 10) {
            int a = rand.nextInt(2);
            if (a % 2 == 0) {
                StdDraw.text(3.5,9, "J");
            }
            else {
                StdDraw.text(3.5,9, card2);
            }
        }
        else {
            StdDraw.text(3.5,9, card2);
        }
}
    public void dealerFlip(int first) {
        String card1;
        card1 = String.valueOf(first);
        StdDraw.text(1,8.5, card1);
    }
    public void playerHit(int card, int count) {
        String card1 = String.valueOf(card);
        StdDraw.rectangle(3.5 + count * 2.5,2,1,1.5);
        StdDraw.text(3.5 + count * 2.5,1, card1);
    }
    public void houseHits(int card, int count){
        String card1 = String.valueOf(card);
        StdDraw.rectangle(3.5 + count * 2.5,8,1,1.5);
        StdDraw.text(3.5 + count * 2.5,9, card1);
    }
    }


