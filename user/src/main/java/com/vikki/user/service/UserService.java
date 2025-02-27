package com.vikki.user.service;

import com.vikki.user.model.User;
//import com.vikki.user.repository.UserJPARepo;
import com.vikki.user.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user)
    {
        Optional<User> saveUser = userRepo.findByUserId(user.getUserId());
        if (saveUser.isPresent())
        {
            throw new RuntimeException("User with userId : "+user.getUserId());
        }
        userRepo.save(user);
    }

    public User getUser(Long id)
    {
        return userRepo.findById(id).orElse(null);
    }

    public User getUserByUserId(String userId)
    {
        Optional<User> user = userRepo.findByUserId(userId);
        if (!user.isPresent())
        {
            throw new RuntimeException("User not found with userId : "+userId);
        }
        return user.get();
    }
}
