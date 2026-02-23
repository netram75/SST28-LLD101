public class DefaultPrinter implements StudentPrinter {

    private final DatabaseService dbService;

    public DefaultPrinter(DatabaseService dbService) {
        this.dbService = dbService;
    }

    @Override
    public void print(StudentRecord studentRecord) {
        StringBuilder sb = new StringBuilder();
        sb.append("OK: created student ").append(studentRecord.id).append("\n");
        sb.append("Saved. Total students: ").append(dbService.count()).append("\n");
        sb.append("CONFIRMATION:\n");
        sb.append(studentRecord).append("\n");
        System.out.print(sb.toString());
    }
}
