package edu.romathew.ehr.service;

import edu.romathew.ehr.domain.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private Map<String, User> usersMap = null;

    @PostConstruct
    void loadAllUsers() {
        usersMap = new HashMap<>();
        User user1 = new User("mmuser", "Matthew", "User");
        User user2 = new User("jjuser", "Jane", "User");
        User user3 = new User("ppuser", "Peter", "User");
        User user4 = new User("lluser", "Liza", "User");
        usersMap.put(user1.getUserId(), user1);
        usersMap.put(user2.getUserId(), user2);
        usersMap.put(user3.getUserId(), user3);
        usersMap.put(user4.getUserId(), user4);
    }

    public List<User> getAllUsers() {
        return usersMap.values().stream().collect(Collectors.toList());
    }

    public Optional<User> getUserByUserId(String userId) {
        return Optional.ofNullable(usersMap.get(userId));
    }
}
