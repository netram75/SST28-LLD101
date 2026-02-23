import java.util.*;

public class StudentValidator {
    private static final Set<String> ALLOWED_PROGRAMS = new HashSet<>(Arrays.asList("CSE", "AI", "SWE"));

    public List<String> validate(Map<String, String> studentInfo) {
        List<String> errorMessages = new LinkedList<>();

        String nameField = studentInfo.get("name") != null ? studentInfo.get("name").trim() : "";
        String emailField = studentInfo.get("email") != null ? studentInfo.get("email").trim() : "";
        String phoneField = studentInfo.get("phone") != null ? studentInfo.get("phone").trim() : "";
        String programField = studentInfo.get("program") != null ? studentInfo.get("program").trim() : "";

        if (nameField.length() == 0) {
            errorMessages.add("name is required");
        }
        if (emailField.length() == 0 || !emailField.contains("@")) {
            errorMessages.add("email is invalid");
        }
        if (phoneField.length() == 0 || !phoneField.chars().allMatch(Character::isDigit)) {
            errorMessages.add("phone is invalid");
        }
        if (!ALLOWED_PROGRAMS.contains(programField)) {
            errorMessages.add("program is invalid");
        }

        return errorMessages;
    }
}
