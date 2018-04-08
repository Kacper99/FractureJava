import java.util.ArrayList;

/**
 * Class used to run the game
 */
public class Fracture {

    private int numQuestions;
    private ArrayList<String> players = new ArrayList<>();
    private ArrayList<Challenge> allChallenges, currentChallenges;

    public Fracture() {
        loadQuestions();
    }

    public void loadQuestions() {

    }

    public void updatePlayers(ArrayList<String> newPlayers) {
        players.clear();
        players = newPlayers;
        System.out.println(players);
    }
}
