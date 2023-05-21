package cinema.demo.Services;
import cinema.demo.Entity.Session;
import cinema.demo.Repository.ISessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private ISessionRepository sessionRepository;

    @Async
    public List<Session> getSessionObject() {
        return sessionRepository.getSessionObjectList();
    }

    @Async
    public Session findSessionObjectById(Integer id) {
        return sessionRepository.findSessionObjectById(id);
    }

    @Async
    public void add(Session sessionObject) { sessionRepository.add(sessionObject);}

    @Async
    public void update(Session sessionObject) {sessionRepository.update(sessionObject);}

    @Async
    public void delete(Integer id) {
        sessionRepository.delete(id);
    }
}