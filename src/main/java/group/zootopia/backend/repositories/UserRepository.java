package group.zootopia.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import group.zootopia.backend.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByUsername(String username);

}
