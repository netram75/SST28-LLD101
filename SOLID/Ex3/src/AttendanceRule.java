public class AttendanceRule extends Rule {

    public AttendanceRule(String failMessage, StudentProfile studentProfile) {
        super(failMessage, studentProfile);
    }

    @Override
    boolean check() {
        int attendancePercent = this.profile.attendancePct;
        int minAttendance = RuleInput.minAttendance;
        return attendancePercent >= minAttendance;
    }
}
