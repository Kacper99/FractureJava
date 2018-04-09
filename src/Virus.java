import java.util.Random;

/**
 * Virus is a type of challenge which lasts for multiple turns
 */
public class Virus extends Challenge {

    private int turnsLeft;
    private String endText;
    private String[] randomAccents = new String[]{"Chinese", "Polish", "German"};

    public Virus(String challenge, String endText) {
        super(challenge);
        this.endText = endText;
        resetTurns();
    }

    /**
     * @return Tne number of turns until the challenge ends
     */
    public int getTurnsLeft() {
        return turnsLeft;
    }

    /**
     * Reduces one form the turns left
     */
    public void incrementTurn() {
        turnsLeft--;
    }

    /**
     * @return End of challenge text
     */
    public String getEndText() {
        return endText;
    }

    /**
     * WIll replace any keywords with the correct randomly selected word
     * @return The challenge
     */
    public String getChallenge() {
        if (challenge.contains("!RANDOMACCENT!")) {
            Random rand = new Random();
            String randomAccent = randomAccents[rand.nextInt(randomAccents.length)];
            challenge = challenge.replaceAll("!RANDOMACCENT!", randomAccent);
        }
        return challenge;
    }

    /**
     * Resets the number of turns to a new random number
     */
    public void resetTurns() {
        Random rand = new Random();
        turnsLeft = rand.nextInt(11) + 4;
    }
}
