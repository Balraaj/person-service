package com.forall.reacted.database;

import com.forall.reacted.database.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonDao extends JpaRepository<Person, Integer> {

}
