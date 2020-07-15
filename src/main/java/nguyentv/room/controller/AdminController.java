package nguyentv.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String AdminHome(){
        return "adminpages/index";
    }

    @RequestMapping("/login")
    public String Login(){
        return "adminpages/login";
    }

    @RequestMapping("/list")
    public String ListRoom(){
        return "adminpages/list_room";
    }

    @RequestMapping("/add")
    public String AddRoom(){
        return "adminpages/add_room";
    }
}
