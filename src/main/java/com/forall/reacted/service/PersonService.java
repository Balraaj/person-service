package com.forall.reacted.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements IService{

    @NotNull
    @Override
    public String getData() {
        return "HELLO WORLD";
    }
}
