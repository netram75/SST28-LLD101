public class CGRRule extends Rule {

    public CGRRule(String failMessage, StudentProfile studentProfile) {
        super(failMessage, studentProfile);
    }

    @Override
    boolean check() {
        double cgrValue = this.profile.cgr;
        double minCgr = RuleInput.minCgr;
        return cgrValue >= minCgr;
    }
}
