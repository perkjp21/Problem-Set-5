import java.awt.*;
import java.util.Random;

public class Draw {
    Random rand = new Random();

    public void cardsDealt(int first, int second) {
        int suit1 = rand.nextInt(4);
        int suit2 = rand.nextInt(4);

        String card1;
        String card2;
        card1 = String.valueOf(first);
        card2 = String.valueOf(second);

        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(1,2,1,1.5);
        StdDraw.filledRectangle(3.5,2,1,1.5);

        if (suit1 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit1 == 1) {
                String filename ="Club.png";
                StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit1 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit1 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(1,2, filename, .5 ,.75);
        }
        if (suit2 == 0) {
            String filename ="Heart.png";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        if (suit2 == 1) {
            String filename ="Club.png";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        if (suit2 == 2) {
            String filename ="Spade4.jpeg";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        if (suit2 == 3) {
            String filename ="Diamond.png";
            StdDraw.picture(3.5,2, filename, .5 ,.75);
        }
        StdDraw.setPenColor(Color.black);
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
        } else {
            StdDraw.text(1,1, card1);
        }

        if (second == 11) {
            StdDraw.text(3.5, 1, "J");
        }
        else if (second == 12) {
            StdDraw.text(3.5,1, "Q");
        }
        else if (second == 13) {
            StdDraw.text(3.5,1, "K");
        }
        else if (second == 1) {
            StdDraw.text(3.5,1, "A");
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

        StdDraw.setPenColor(Color.white);
        //StdDraw.rectangle(1,8,1,1.5);
        StdDraw.filledRectangle(3.5,8,1,1.5);

        StdDraw.setPenColor(Color.black);
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

        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(1,8,1,1.5);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(1,9, card1);
    }
    public void playerHit(int card, int count) {
        String card1 = String.valueOf(card);

        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(3.5 + count * 2.5,2,1,1.5);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(3.5 + count * 2.5,1, card1);
    }
    public void houseHits(int card, int count){
        String card1 = String.valueOf(card);

        StdDraw.setPenColor(Color.white);
        StdDraw.filledRectangle(3.5 + count * 2.5,8,1,1.5);
        StdDraw.setPenColor(Color.black);
        StdDraw.text(3.5 + count * 2.5,9, card1);
    }
}


