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

    private ArrayList<String> players = new ArrayList<>();
    private ArrayList<Challenge> allChallenges, currentChallenges;
    private ArrayList<Virus> activeViruses = new ArrayList<>();

    public Fracture() throws IOException {
        allChallenges = new ArrayList<>();
        FileInputStream fis = new FileInputStream("Challenges.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains("!VIRUS!")) {
                line = line.replaceAll("!VIRUS!", "");
                String endText = br.readLine();

                allChallenges.add(new Virus(line, endText));
            } else {
                allChallenges.add(new Challenge(line));
            }
        }
        currentChallenges = new ArrayList<>(allChallenges);
    }

    public void updatePlayers(ArrayList<String> newPlayers) {
        players.clear();
        players = newPlayers;
        System.out.println(players);
    }

    public String getNextChallenge() {
        //Check there are questions, if not reset
        if (currentChallenges.isEmpty()) {

            if (!activeViruses.isEmpty()) {
                Virus v = activeViruses.get(0);
                activeViruses.remove(v);
                return v.getEndText();
            }
            currentChallenges = new ArrayList<>(allChallenges);
            return "All challenges completed, resetting";
        }
        //Check there is enough players
        if (players.size() < 3) {
            return "Not enough players, please make sure there are at least 3 players ";
        }

        for (Virus v: activeViruses) {
            if (v.getTurnsLeft() == 0) {
                String virusFinishedText = v.getEndText();
                activeViruses.remove(v);
                return virusFinishedText;
            }
            v.incrementTurn();
        }

        Random rand = new Random();
        Challenge randomChallenge = currentChallenges.get(rand.nextInt(currentChallenges.size()));
        //System.out.println("Challenge pulled" + randomChallenge);

        if (randomChallenge instanceof Virus) {
            //System.out.println("Found a virus");
            Virus randomVirus = (Virus) randomChallenge;
            randomVirus.resetTurns();
            activeViruses.add(randomVirus);
        }

        String challengeText = randomChallenge.getChallenge();

        ArrayList<String> availableNames = new ArrayList<>(players);
        while (challengeText.contains("!NAME!")) {
            String randomName = availableNames.get(rand.nextInt(availableNames.size()));
            availableNames.remove(randomName);
            challengeText = challengeText.replaceFirst("!NAME!", randomName);
        }

        //Remove this challenge
        currentChallenges.remove(randomChallenge);
        //System.out.println(currentChallenges.toString());

        return challengeText;
    }
}
