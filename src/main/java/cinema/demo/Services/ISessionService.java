package cinema.demo.Services;
import cinema.demo.Entity.Session;
import java.util.List;

public interface ISessionService {
    public List<Session> getSessionObject();
    public Session findSessionObjectById(Integer id);
    public void add(Session sessionObject);
    public void update(Session sessionObject);
    public void delete(Integer id);
}