import java.util.*;

public class OnboardingService {
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final StudentRepository repo;
    private final StudentPrinter printer = new StudentPrinter();

    public OnboardingService(StudentRepository repo) {
        this.repo = repo;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        List<String> errors = validator.validate(kv);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(repo.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        repo.save(rec);

        printer.printSuccess(id, repo.count(), rec);
    }
}