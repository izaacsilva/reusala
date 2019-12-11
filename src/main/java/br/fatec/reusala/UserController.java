package br.fatec.reusala;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
@Log4j2
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/save")
    public @ResponseBody User saveUser(User user) {
        log.debug(user);
        System.out.println(user);
        return userRepository.save(user);
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(path="/delete")
    public @ResponseBody String deleteUser(@RequestParam Integer id) {
        try {
            userRepository.deleteById(id);
            return String.format("User id %d deleted!", id);
        } catch (EmptyResultDataAccessException e) {
            return String.format("User with id %d doesn't exist!", id);
        }
    }
}
