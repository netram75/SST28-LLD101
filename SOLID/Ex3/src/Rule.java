public abstract class Rule {
    String reason;
    StudentProfile profile;

    public Rule(String reason, StudentProfile profile) {
        this.reason = reason;
        this.profile = profile;
    }

    // Check fails if false is returned and vice-versa.
    abstract boolean check();
}
