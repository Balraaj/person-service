package com.forall.reacted;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.*;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class SomeClass {

    @Bean
    @Primary
    public String str1() { return "1234"; }

    @Bean
    public String str2() { return "12345"; }

    @Bean
    public Integer someInt(String str){
        return Integer.valueOf(str);
    }
}
