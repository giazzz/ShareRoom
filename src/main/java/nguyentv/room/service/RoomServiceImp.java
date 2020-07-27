package nguyentv.room.service;

import nguyentv.room.entity.Room;
import nguyentv.room.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImp implements RoomService{
    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> getAll() {
        return (List<Room>) roomRepository.findAll();
    }

    @Override
    public void saveRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Optional<Room> findRoomById(Integer id) {
        return roomRepository.findById(id);
    }

    @Override
    public Page<Room> findByStatusNot(Pageable pageable, Integer status) {
        return roomRepository.findByStatusNot(pageable, Room.statusEnum.Delete.value);
    }

    @Override
    public Page<Room> findByStatus(Pageable pageable, Integer status) {
        return roomRepository.findByStatus(pageable, status);
    }


}
