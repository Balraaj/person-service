package com.forall.reacted.controller;

import com.forall.reacted.database.PersonDao;
import com.forall.reacted.database.entity.Person;
import com.forall.reacted.exceptions.NoPersonFoundException;
import com.forall.reacted.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/person-service")
public class ReactedController {

    private ReactedController(PersonDao personDao,
                              IService iService){
        this.personDao = personDao;
        this.iService = iService;
    }

    private final PersonDao personDao;
    private final IService iService;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ApplicationContext context;

    @GetMapping(value = { "/persons/{id}/{name}", "/persons/{id}" , "/persons/" })
    public List<Person> getPersons(@PathVariable(name = "id", required = false) final Integer id,
                                   @PathVariable(name = "name", required = false) final String name,
                                   HttpServletResponse response,
                                   Locale locale) {
        String message = context.getMessage("reacted.welcome.message", null, locale);
        if (id == null) return personDao.findAll();
        Optional<Person> person = personDao.findById(id);
        if(person.isEmpty()){
            // 1. response.setStatus(HttpStatus.NOT_FOUND.value());
            // 1. return null;

            // 2. throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %s and name %s not found", id, name));

            // 3. throw new NoPersonFoundException(marked with ResponseStatus) and don't define any handler
            // 4.
            throw new NoPersonFoundException(String.format("Person with id %s and name %s not found", id, name));
        }
        return person.map(Collections::singletonList).orElseGet(Arrays::asList);
    }

    @PostMapping(value = { "/persons/"}, consumes = MediaType.APPLICATION_JSON_VALUE )
    public void addPerson(@RequestBody final Person person){
        personDao.save(person);
    }

    private void someFun(){
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
