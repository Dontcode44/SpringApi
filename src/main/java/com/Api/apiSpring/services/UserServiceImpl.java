package com.Api.apiSpring.services;

import com.Api.apiSpring.models.User;
import com.Api.apiSpring.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    @Override
    public User createUser(User user) {
        var userFound = this.userRepo.findAll(

        );
        System.out.println(userFound);
        return userRepo.save(user);
    }


    @Override
    public Optional<User> getUser(Long userId) {
        try {
            return userRepo.findById(userId);
        }  catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    @Override
    public User updateUser(Long id, User toUpdateUser) {
        User foundUser = userRepo.findById(id).get();
        foundUser.setCc(toUpdateUser.getCc());
        foundUser.setFirstName(toUpdateUser.getFirstName());
        foundUser.setLastName(toUpdateUser.getLastName());
        foundUser.setPhone(toUpdateUser.getPhone());

        return userRepo.save(foundUser);
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
