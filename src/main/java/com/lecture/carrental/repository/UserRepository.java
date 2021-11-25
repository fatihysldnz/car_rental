package com.lecture.carrental.repository;

import com.lecture.carrental.domain.User;
import com.lecture.carrental.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
                                        // ihtiyaca gore farkli springboot classlari kullanabilirsiniz
                                        // bu project icin bu jpqRepo yeterli

    Optional<User> findByUsername(String usurname) throws ResourceNotFoundException;

}
