package nguyentv.room.service;

import nguyentv.room.entity.Room;
import nguyentv.room.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService{
    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> getAll() {
        return (List<Room>) roomRepository.findAll();
    }
}
