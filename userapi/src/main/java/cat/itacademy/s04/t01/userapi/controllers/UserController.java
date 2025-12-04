package cat.itacademy.s04.t01.userapi.controllers;

import cat.itacademy.s04.t01.userapi.entities.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserController {
    private static List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public static List<User> getUsers() {
        return Collections.unmodifiableList(this.users);
    }


}
