import java.util.Random;

public class Virus extends Challenge {

    private int inEffectFor;

    public Virus(String challenge) {
        super(challenge);

        Random rand = new Random();
        inEffectFor = rand.nextInt(11) + 4;
    }

    public int getInEffectFor() {
        return inEffectFor;
    }
}
