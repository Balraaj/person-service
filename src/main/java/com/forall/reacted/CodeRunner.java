package com.forall.reacted;

import com.forall.reacted.database.PersonDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class CodeRunner implements CommandLineRunner {

    @Autowired
    private PersonDao dao;

    @Autowired
    private SessionFactory session;

    Logger logger = LoggerFactory.getLogger(CodeRunner.class);

    @Override
    public void run(String... args) throws Exception {
    }
}
