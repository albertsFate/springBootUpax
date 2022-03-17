package com.examu.upaxrest.service.Impl;

import com.examu.upaxrest.models.Gender;
import com.examu.upaxrest.repository.GenderRepo;
import com.examu.upaxrest.service.GenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenderServiceImplement implements GenderService {

    private final GenderRepo genderRepo;

    @Override
    public Gender getGender(Long id){
        Optional<Gender> gender = genderRepo.findById(id);
        if (gender.isPresent()){
            return gender.get();
        }else return null;

    }
}
