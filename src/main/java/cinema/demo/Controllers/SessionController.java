package cinema.demo.Controllers;


import cinema.demo.Entity.Session;
import cinema.demo.Services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionController {
    @Autowired
    private SessionService SessionService;
    @PostMapping("files/add")
    public String uploading (@RequestParam("titleName") String titleName,
                             @RequestParam("startFilm") String startFilm,
                             @RequestParam("price") Integer price,
                             @RequestParam("duration") String duration)
    {
        Session sessionObject = new Session(titleName, startFilm, price, duration);
        SessionService.add(sessionObject);
        return "redirect:/files";
    }

    @GetMapping("/files")
    public String listFiles(Model model) {
        List<Session> sessionObjectList = SessionService.getSessionObject();
        model.addAttribute("sessionObjectList", sessionObjectList);
        return "files";
    }
    @GetMapping("/delete/{id}")
    public String deleteFile(@PathVariable Integer id)
    {
        SessionService.delete(id);
        return "redirect:/files";
    }
    @GetMapping("/edit/{id}")
    public String editSessionById(@PathVariable Integer id, Model model)
    {
        List<Session> sessionObject = new ArrayList<>();
        sessionObject.add(SessionService.findSessionObjectById(id));
        model.addAttribute("sessionObject", sessionObject);
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editFile (@PathVariable Integer id,
                            @RequestParam("titleName") String titleName,
                            @RequestParam("startFilm") String startFilm,
                            @RequestParam("price") Integer price,
                            @RequestParam("duration") String duration)
    {
        Session sessionObject = new Session(id, titleName, startFilm, price, duration);
        SessionService.update(sessionObject);
        return "redirect:/files";
    }
}