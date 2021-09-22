package ch.sunrise.userservice.repository;

import ch.sunrise.userservice.model.Role;
import ch.sunrise.userservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByName(String name);
}
