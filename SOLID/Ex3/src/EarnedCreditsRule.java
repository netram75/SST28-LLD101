public class EarnedCreditsRule extends Rule {

    public EarnedCreditsRule(String failMessage, StudentProfile studentProfile) {
        super(failMessage, studentProfile);
    }

    @Override
    boolean check() {
        int credits = this.profile.earnedCredits;
        int minCredits = RuleInput.minCredits;
        return credits >= minCredits;
    }
}
