import java.util.*;

public class OnboardingService {

    private final StudentParser parser;
    private final StudentValidator validator;
    private final StudentRecordFactory factory;
    private final StudentPrinter printer;

    public OnboardingService(
        StudentParser parser,
        StudentValidator validator,
        StudentRecordFactory factory,
        StudentPrinter printer
    ) {
        this.parser = parser;
        this.validator = validator;
        this.factory = factory;
        this.printer = printer;
    }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        System.out.println("INPUT: " + raw);
        Map<String, String> kv = parser.parse(raw);
        List<String> errors = validator.validate(kv);
        if (!errors.isEmpty()) {
            System.out.println("ERROR: cannot register");
            for (String e : errors) System.out.println("- " + e);
            return;
        }
        StudentRecord studentRecord = factory.createStudent(kv);
        printer.print(studentRecord);
    }
}
