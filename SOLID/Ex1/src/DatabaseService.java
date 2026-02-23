import java.util.List;

public interface DatabaseService {
    public void save(StudentRecord r);
    public int count();
    public List<StudentRecord> all();
}
