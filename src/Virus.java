import java.util.Random;

public class Virus extends Challenge {

    private int turnsLeft;
    private String endText;
    private String[] randomAccents = new String[]{"Chinese", "Polish", "German"};

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

    public String getChallenge() {
        if (challenge.contains("!RANDOMACCENT!")) {
            Random rand = new Random();
            String randomAccent = randomAccents[rand.nextInt(randomAccents.length)];
            challenge = challenge.replaceAll("!RANDOMACCENT!", randomAccent);
        }
        return challenge;
    }

    public void resetTurns() {
        Random rand = new Random();
        turnsLeft = rand.nextInt(11) + 4;
    }
}
