package group.zootopia.backend.services;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import group.zootopia.backend.exception.NotFound;
import group.zootopia.backend.interfaces.IGenericLimitedService;
import group.zootopia.backend.models.User;
import group.zootopia.backend.repositories.UserRepository;

@Service
public class UserService implements IGenericLimitedService<User> {

    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        List<User> types = repository.findAll();
        return types;
    }

    public User getById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new NotFound("User not found"));

        return user;
    }

    public User save(@NonNull User type) {

        User newUser = new User();

        repository.save(newUser);
        return newUser;
    }
}
