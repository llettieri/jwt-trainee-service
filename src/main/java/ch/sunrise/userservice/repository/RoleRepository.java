package ch.sunrise.userservice.repository;

import ch.sunrise.userservice.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, Long> {
    Role findByName(String name);
}
