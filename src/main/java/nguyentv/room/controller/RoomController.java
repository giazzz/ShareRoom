package nguyentv.room.controller;

import nguyentv.room.entity.Room;
import nguyentv.room.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @RequestMapping("/")
    public String index(@PageableDefault(size = 6) Pageable pageable, Model model) {
//        List<Room> allRoom = roomService.findByStatus(Room.statusEnum.Active.value);
        Page<Room> allRoom = roomService.findByStatus(pageable, Room.statusEnum.Active.value);
        model.addAttribute("allRoom", allRoom);
        return "index";
    }
}
