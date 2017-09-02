package org.community.controller;

import org.community.domain.User;
import org.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by frodoking on 2016/12/26.
 */
@RestController
@RequestMapping("/{version}/users")
public class UserController implements RestResource<User> {

    @Autowired
    private UserService userService;

    @GetMapping("/user/check")
    public ResponseEntity login(String username, String password) {
        return ResponseEntity.ok(userService.getByName(username));
    }

    @GetMapping
    @Override
    public List<User> list() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    @Override
    public User find(@PathVariable("id") Long id) {
        return userService.getById(id.intValue());
    }

    @PostMapping
    @Override
    public Long add(User user) {
        int resultCode = userService.addUser(user);
        if (resultCode == 0) {
            User mUser = userService.getById(user.getId());
            if (mUser != null) {
                return mUser.getId().longValue();
            }
        }
        return -1L;
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable("id") Long id) {
    }

    @PutMapping
    @Override
    public Long update(User entity) {
        return null;
    }
}
