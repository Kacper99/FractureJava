import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class used to run the game
 */
public class Fracture {

    private int numQuestions;
    private ArrayList<String> players = new ArrayList<>();
    private ArrayList<Challenge> allChallenges, currentChallenges;

    public Fracture() {
        allChallenges = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("Challenges.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));

            String line;
            while ((line = br.readLine()) != null) {
                allChallenges.add(new Challenge(line));
            }
            currentChallenges = allChallenges;
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void updatePlayers(ArrayList<String> newPlayers) {
        players.clear();
        players = newPlayers;
        System.out.println(players);
    }

    public String getNextChallenge() {
        Random rand = new Random();
        Challenge randomChallenge = currentChallenges.get(rand.nextInt(currentChallenges.size()));

        String challengeText = randomChallenge.getChallenge();

        while (challengeText.contains("!NAME!")) {
            String randomName = players.get(rand.nextInt(players.size()));
            challengeText = challengeText.replaceFirst("!NAME!", randomName);
        }
        return challengeText;
    }
}
