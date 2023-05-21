package cinema.demo.Repository;

import cinema.demo.Entity.Session;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.util.Objects;

@Repository
public class SessionRepository implements ISessionRepository {

    private List<Session> sessionObjectList = new ArrayList<>();
    private static String DB_Path = "src/main/resources/YAML_DB/dataBase.yaml";

    ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
    private int idCount=1;
    public SessionRepository () throws IOException {
        try
        {
            sessionObjectList = objectMapper.readValue(new File(DB_Path), new TypeReference<>() {});
            for (Session sessionObject: sessionObjectList)
            {
                if (sessionObject.getId() >= idCount)
                {
                    idCount = sessionObject.getId()+1;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Async
    public Session findSessionObjectById(Integer id)
    {
        for (Session sessionObject : sessionObjectList)
        {
            if (sessionObject.getId().equals(id))
            {
                return sessionObject;
            }
        }
        return null;
    }
    @Async
    public List<Session> getSessionObjectList() {
        return sessionObjectList;
    }
    @Async
    public void add(Session sessionObject)
    {
        sessionObject.setId(idCount++);
        sessionObjectList.add(sessionObject);
        save();
    }
    @Async
    public void update(Session sessionObject)
    {
        for (int i = 0; i < sessionObjectList.size(); i++)
        {
            if (sessionObjectList.get(i).getId().equals(sessionObject.getId()))
            {
                sessionObjectList.set(i, sessionObject);
                save();
                return;
            }
        }
    }

    @Async
    public void delete(Integer id)
    {
        sessionObjectList.removeIf(sessionObject -> sessionObject.getId().equals(id));
        save();
    }
    private void save()
    {
        try
        {
            objectMapper.writeValue(new File(DB_Path), sessionObjectList);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
