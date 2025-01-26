package com.capx.assignmentProject.repositories;

import com.capx.assignmentProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
