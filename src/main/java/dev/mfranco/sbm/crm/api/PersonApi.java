package dev.mfranco.sbm.crm.api;

import dev.mfranco.sbm.crm.dto.PersonDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/person")
public class PersonApi {

    @GetMapping()
    public PersonDto getPerson(){
        return new PersonDto();
    }

}
