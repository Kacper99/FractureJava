import java.util.Random;

public class Virus extends Challenge {

    private int turnsLeft;
    private String endText;

    public Virus(String challenge, String endText) {
        super(challenge);

        this.endText = endText;

        resetTurns();
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void incrementTurn() {
        turnsLeft--;
    }

    public String getEndText() {
        return endText;
    }

    public void resetTurns() {
        Random rand = new Random();
        turnsLeft = rand.nextInt(11) + 4;
    }
}
