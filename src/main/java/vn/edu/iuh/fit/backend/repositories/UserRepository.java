package vn.edu.iuh.fit.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.backend.models.User;

public interface UserRepository extends CrudRepository<User,Long> {
}
