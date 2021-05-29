package dev.mfranco.sbm.crm.api;

import dev.mfranco.sbm.crm.dto.PersonDto;
import dev.mfranco.sbm.crm.mapper.PersonMapper;
import dev.mfranco.sbm.crm.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/person")
public class PersonApi {

    @Autowired
    private PersonMapper personMapper;

    @PostMapping()
    public Person createPerson(@RequestBody PersonDto p){
        Person person = this.personMapper.personDtoToPerson(p);
        return person;
    }

}
