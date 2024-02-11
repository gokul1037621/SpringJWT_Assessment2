package com.example.EcommerceJWT.Service;

import com.example.EcommerceJWT.Model.User;
import com.example.EcommerceJWT.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepo;
    private TokenService tokenService;

    @Autowired
    public UserService(UserRepository userRepo, TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService = tokenService;
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public List<User> saveAllUsers(List<User> allUsers){
        return userRepo.saveAll(allUsers);
    }

    public User findUserById(int id){
        Optional<User> findUserObj = userRepo.findById(id);
        return findUserObj.get();
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public boolean existUserById(int id){
        System.out.println(userRepo.existsById(id));
        return userRepo.existsById(id);
    }

    public void deleteUserById(int id){
        userRepo.deleteById(id);
    }

    public void deleteAllProducts(){
        userRepo.deleteAll();
    }

    public User updateUser(User user){
        User userObj = userRepo.saveAndFlush(user);
        return userObj;
    }

    public Boolean existByEmail(String email) {
//        Optional<User> usersObj = Optional.ofNullable(userRepo.getUserByUsername(email));
//        System.out.println(usersObj);
//        if(!usersObj.isEmpty()){
//            return true;
//        }
//        return false;
        ArrayList<User> userObj = (ArrayList<User>) userRepo.findAll();
        for(User u : userObj){
            System.out.println(u);
            if(u.getEmail().equals(email)){
                return true;
            }

        }
        return false;
    }


    public String userLogin(String email, String password ) {
        boolean foundUsers = existByEmail(email);
        if(foundUsers) {
            ArrayList<User> userObj = (ArrayList<User>) userRepo.findAll();
            User user = userObj.get(0);
            if(user.getPassword().equals(password)) {
                return "{" +
                        "\"message\":"+"Successfully logged in,\n"+
                        "\"data\":"+user+",\n"+
                        "\"Email\": "+user.getEmail()+",\n"+
                        "\"Token\": "+tokenService.createTokenFunction(user.getId())+
                        "}";
            }
        }
        return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";
    }
}
