package nguyentv.room.controller;

import nguyentv.room.dto.RoomDTO;
import nguyentv.room.entity.Role;
import nguyentv.room.entity.Room;
import nguyentv.room.entity.RoomValidator;
import nguyentv.room.entity.User;
import nguyentv.room.service.RoomService;
import nguyentv.room.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class AdminController {
    @Autowired
    RoomService roomService;

    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/admin")
    public String AdminHome(){
//        User u = new User();
//        u.setEmail("user@gmail.com");
//        u.setPassword(passwordEncoder.encode("123456"));
//
//        Set<Role> _roles = new HashSet<>();
//        Role r = new Role();
//        r.setName("MEMBER");
//        _roles.add(r);
//        u.setRoles(_roles);
//        userService.saveUser(u);

        return "admin/index";
    }

    @RequestMapping(value = "/login")
    public String Login(){
        return "admin/login";
    }

    @RequestMapping(value = "/admin/list")
    public String ListRoom(@PageableDefault(size = 6) Pageable pageable, Model model){
//        List<Room> allRoom = roomService.findByStatusNot(Room.statusEnum.Delete.value);

        Page<Room> allRoom = roomService.findByStatusNot(pageable, Room.statusEnum.Delete.value);
        model.addAttribute("allRoom", allRoom);
        return "admin/list_room";
    }

    @GetMapping("/admin/add")
    public String AddRoom(Model model){
        model.addAttribute("room", new Room());
        return "admin/add_room";
    }

    @RequestMapping(value = "/saveNewRoom", method = RequestMethod.POST)
    public String SaveRoom(@Validated @ModelAttribute("room") RoomDTO roomDTO, BindingResult bindingResult){
        List<ObjectError> listError = bindingResult.getAllErrors();
        if(bindingResult.hasErrors()){
            return "admin/add_room";
        }else{
            Room r = new Room();
            r.setName(roomDTO.getName());
            r.setArea(roomDTO.getArea());
            r.setDescription(roomDTO.getDescription());
            r.setPicture(roomDTO.getPicture());
            r.setPriceDay(roomDTO.getPriceDay());
            r.setPriceMonth(roomDTO.getPriceMonth());
            r.setStatus(Room.statusEnum.Active.value);

            roomService.saveRoom(r);
            return "redirect:/admin/list";
        }
    }

    @GetMapping("/admin/edit")
    public String Edit(@RequestParam("id") Integer roomId, Model model){
        Optional<Room> roomEdit = roomService.findRoomById(roomId);
        roomEdit.ifPresent(room -> model.addAttribute("room", roomEdit));
        return "admin/edit";
    }

    @PostMapping("admin/edit")
    public String EditProcess(@ModelAttribute("room") Room room, BindingResult bindingResult){
        new RoomValidator().validate(room, bindingResult);
        if(bindingResult.hasErrors()){
            return "admin/edit";
        }else{
            roomService.saveRoom(room);
            return "redirect:/admin/list";
        }
    }

    @GetMapping("/admin/delete")
    public String Delete(@RequestParam("id") Integer roomId){
        Optional<Room> roomDelete = roomService.findRoomById(roomId);
        if(roomDelete.isPresent()){
            Room r = roomDelete.get();
            r.setStatus(Room.statusEnum.Delete.value);
            roomService.saveRoom(r);
        }
        return "redirect:/admin/list";
    }
}
