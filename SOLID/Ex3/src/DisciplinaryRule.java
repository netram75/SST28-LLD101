public class DisciplinaryRule extends Rule {

    public DisciplinaryRule(String failMessage, StudentProfile studentProfile) {
        super(failMessage, studentProfile);
    }

    @Override
    boolean check() {
        int flag = this.profile.disciplinaryFlag;
        return flag == LegacyFlags.NONE;
    }
}
