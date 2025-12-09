package cat.itacademy.s04.t01.userapi.Repository;

import cat.itacademy.s04.t01.userapi.entities.User;
import cat.itacademy.s04.t01.userapi.exceptions.UserNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class InMemoryUserRepository implements UserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("The user cannot be null.");
        }
        users.add(user);
        return user;
    }

    @Override
    public List<User> findAll() {

        return users;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> searchByName(String name) {
        if(name == null || name.isBlank()){
            return users;
        }

        String lower = name.toLowerCase();

        return users.stream()
                .filter(u -> u.getName().toLowerCase().contains(lower))
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("The email is invalid.");
        }

        return users.stream()
                .anyMatch(u -> u.getEmail().equals(email));

    }
}
