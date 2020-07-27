package nguyentv.room.service;

import nguyentv.room.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    List<Room> getAll();

    void saveRoom(Room room);

    void deleteRoom(Integer id);

    Optional<Room> findRoomById(Integer id);

//    List<Room> findByStatusNot(Integer status);

//    List<Room> findByStatus(Integer status);

    Page<Room> findByStatusNot(Pageable pageable, Integer status);

    Page<Room> findByStatus(Pageable pageable, Integer status);
}
