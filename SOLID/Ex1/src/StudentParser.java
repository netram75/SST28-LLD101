import java.util.LinkedHashMap;
import java.util.Map;

public class StudentParser {

    private static final String DELIM = ";";
    private static final String ASSIGN = "=";

    public Map<String, String> parse(String rawInput) {
        Map<String, String> map = new LinkedHashMap<>();
        String[] tokens = rawInput.split(DELIM);
        for (String token : tokens) {
            int idx = token.indexOf(ASSIGN);
            if (idx > 0 && idx < token.length() - 1) {
                String key = token.substring(0, idx).trim();
                String value = token.substring(idx + 1).trim();
                map.put(key, value);
            }
        }
        return map;
    }
}
