package cinema.demo.Repository;

import cinema.demo.Entity.Session;

import java.util.List;

public interface ISessionRepository {
    public List<Session> getSessionObjectList();
    public Session findSessionObjectById(Integer id);
    public void add(Session sessionObject);
    public void update(Session sessionObject);
    public void delete(Integer id);
}
