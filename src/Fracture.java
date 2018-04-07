import java.util.ArrayList;

/**
 * Class used to run the game
 */
public class Fracture {

    private int numQuestions;
    private ArrayList<String> players = new ArrayList<>();

    public Fracture() {
        loadQuestions();
    }

    public void loadQuestions() {

    }

    public void addPlayer(String name) {
        players.add(name);
    }

    public void removePlayer(String name) {
        players.remove(name);
    }
}
