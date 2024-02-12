package com.example.EcommerceJWT.Repository;

import com.example.EcommerceJWT.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // JPA extended using User, to give access to built in db functions
    //SELECT * FROM ecommerce_user
    //WHERE user_email= :userName;

    @Query(value = "SELECT u FROM User u WHERE u.userName = :userName and u.password1 = :password")
    User getUserByUsername(String userName,String password);

    // querying the database using the user entity to return a match during login in
    // used for token creation


}
