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

    public boolean hasFollowup() {
        return isFollowup;
    }
}
