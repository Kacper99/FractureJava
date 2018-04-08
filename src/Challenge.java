public class Challenge {

    private String challenge;
    private String followup;
    private boolean isFollowup;

    public Challenge(String challenge) {
        this.challenge = challenge;
        isFollowup = false;
    }

    public Challenge(String challenge, String followup) {
        this.challenge = challenge;
        this.followup = followup;
        isFollowup = true;
    }

    public String getChallenge() {
        return challenge;
    }

    public String getFollowup() {
        return followup;
    }

    public boolean hasFollowup() {
        return isFollowup;
    }
}
