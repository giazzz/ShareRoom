package nguyentv.room.repository;

import nguyentv.room.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends PagingAndSortingRepository<Room, Integer> {
//    List<Room> findByStatusNot(Integer status);
//    List<Room> findByStatus(Integer status);

    Page<Room> findByStatusNot(Pageable pageable, Integer status);
    Page<Room> findByStatus(Pageable pageable, Integer status);
}
