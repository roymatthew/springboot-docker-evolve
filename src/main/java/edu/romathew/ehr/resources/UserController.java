package edu.romathew.ehr.resources;

import edu.romathew.ehr.domain.User;
import edu.romathew.ehr.exception.UserNotFoundException;
import edu.romathew.ehr.service.UserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> listOfAllUsers = userService.getAllUsers();
        return ResponseEntity.ok().body(listOfAllUsers);
    }

    @GetMapping("/userid/{userId}")
    public ResponseEntity<User> getUserByUserId(@PathVariable String userId) throws UserNotFoundException {

        log.info("getUserByUserId: {}", userId);
        User user = userService.getUserByUserId(userId)
                .orElseThrow(() -> new UserNotFoundException());

        return ResponseEntity.ok().body(user);
    }

//    echo "# springboot-docker-evolve" >> README.md
//    git init
//    git add README.md
//    git commit -m "first commit"
//    git branch -M main
//    git remote add origin https://github.com/roymatthew/springboot-docker-evolve.git
//    git push -u origin main
}
