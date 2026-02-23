public class Main {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile s = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        EligibilityStore store = new FakeEligibilityStore();
        Rule[] rules = { new DisciplinaryRule("disciplinary flag present", s),
                new AttendanceRule("attendance below 75", s), new EarnedCreditsRule("credits below 20", s),
                new CGRRule("CGR below 8.0", s) };
        EligibilityEngine engine = new EligibilityEngine(store, rules);
        engine.runAndPrint(s);
    }
}
