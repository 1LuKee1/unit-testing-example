package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class UserManagementService {

    private final Map<String, User> usersMap = new HashMap<>();

    public void create(User user) {
        if (usersMap.containsKey(user.getEmail())) {
            throw new RuntimeException(String.format("User with email: [%s] is already created", user.getEmail()));
        } else {
            usersMap.put(user.getEmail(), user);
        }
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(usersMap.get(email));
    }


    public List<User> findAll() {
        return new ArrayList<>(usersMap.values());
    }

    public void update(String email, User updatedUser) {
        if (!usersMap.containsKey(email)) {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }

        if (!email.equals(updatedUser.getEmail())) {
            usersMap.remove(email);
        }
        usersMap.put(updatedUser.getEmail(), updatedUser);

    }


    public void delete(String email) {
        if (!usersMap.containsKey(email)) {
            throw new RuntimeException(String.format("User with email: [%s] doesn't exist", email));
        }
        usersMap.remove(email);
    }

    public List<User> findByName(String name) {
        return usersMap.values().stream()
                .filter(user -> name.equals(user.getName()))
                .collect(Collectors.toList());
    }
}
