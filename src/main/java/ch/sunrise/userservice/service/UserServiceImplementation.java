package ch.sunrise.userservice.service;

import ch.sunrise.userservice.model.Role;
import ch.sunrise.userservice.model.User;
import ch.sunrise.userservice.repository.RoleRepository;
import ch.sunrise.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserServiceImplementation(UserRepository userRepo, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }

    public RoleRepository getRoleRepo() {
        return roleRepo;
    }

    @Override
    public User saveUser(User user) {
        System.out.println("Saving new user " + user.getName() + " the database");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        System.out.println("Saving new role " + role.getName() + " the database");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        System.out.println("Adding role " + roleName + " to user " + username);
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        System.out.println("Fetching user " + username);
        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        System.out.println("Fetching all users");
        return userRepo.findAll();
    }
}
