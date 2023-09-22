package com.test.restfulwebservices.dao;

import com.test.restfulwebservices.model.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class UserDao {

    private static int userCount = 0;

    private static List<User> users = new ArrayList<>();

    static {
       // users.add(new User(++userCount, "debashree", LocalDate.of(2022, 03, 15)));
      //  users.add(new User(++userCount, "sagar", LocalDate.of(2021, 06, 10)));
        //users.add(new User(++userCount, "krishna", LocalDate.of(2020, 01, 5)));
    }

    public List<User> getAllUsers() {
        return users;
    }
    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public User createUser(User user) {
//        User newUser = new User(++userCount, user.getName(), user.getDob());
//        users.add(newUser);
//        return newUser;
        return user;
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId()==id;
        users.removeIf(predicate);
    }


}
