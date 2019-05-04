package com.utad.curso.desarrollo.seguro.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utad.curso.desarrollo.seguro.dto.UserDto;
import com.utad.curso.desarrollo.seguro.mapper.UsersMapper;
import com.utad.curso.desarrollo.seguro.repository.UsersRepository;

@Service
@Transactional
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersMapper usersMapper;

    public UserDto getByUsername(
            String username) {

        return usersMapper.toDto(usersRepository.findByUsername(username));

    }

}
