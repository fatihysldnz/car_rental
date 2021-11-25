package com.lecture.carrental.service;

import com.lecture.carrental.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    // eskiden @Autowired diye yapardık simdi gerek yok AllArgsCons yaptik
    private final UserRepository userRepository;

}
