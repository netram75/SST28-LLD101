import java.util.Map;

public class StudentRecordFactory {

    private final DatabaseService db;

    public StudentRecordFactory(DatabaseService db) {
        this.db = db;
    }

    public StudentRecord createStudent(Map<String, String> fields) {
        String studentId = IdUtil.nextStudentId(db.count());
        String name = fields.containsKey("name") ? fields.get("name") : "";
        String email = fields.containsKey("email") ? fields.get("email") : "";
        String phone = fields.containsKey("phone") ? fields.get("phone") : "";
        String program = fields.containsKey("program") ? fields.get("program") : "";

        StudentRecord record = new StudentRecord(studentId, name, email, phone, program);
        db.save(record);
        return record;
    }
}
