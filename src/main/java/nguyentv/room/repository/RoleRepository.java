package nguyentv.room.repository;

import nguyentv.room.entity.Role;
import nguyentv.room.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
