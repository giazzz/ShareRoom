package nguyentv.room.service;

import nguyentv.room.entity.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAll();

    void saveRoom(Room room);

    void deleteRoom(Integer id);

    Optional<Room> findRoomById(Integer id);

    List<Room> findByStatusNot(Integer status);
}
