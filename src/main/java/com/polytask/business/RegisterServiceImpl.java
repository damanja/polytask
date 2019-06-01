package com.polytask.business;

import com.polytask.repository.AuthorityRepository;
import com.polytask.repository.UserRepository;

public class RegisterServiceImpl implements RegisterService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public RegisterServiceImpl(UserRepository userRepository, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void register(User user) {
        userRepository.register(user);
        Authority authority = new Authority(user.getUsername());
        authorityRepository.add_authority(authority);
    }
}
