package com.swann.knowyourneighborhood.googlefacebook.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swann.knowyourneighborhood.googlefacebook.login.dao.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
	
	//Check or Find duplicate email
	Optional<Users> findByEmail(String email);
	
    //Check existing or duplicate mail
	Boolean existsByEmail(String email);

}






