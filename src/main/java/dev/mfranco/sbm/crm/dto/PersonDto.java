package dev.mfranco.sbm.crm.dto;

import dev.mfranco.sbm.crm.model.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
public class PersonDto {
    private String personCode;
    private String firstName;
    private String lastName;
    private String documentChar;
    private String birthDate;
    private String nationality;
    private String typeDocument;
    private Map<String, String> emailList;
    private Map<String, String> telephoneList;
    private Map<String, String> addressList;
    private Map<String, String> additionalFieldList;
    private String photo;
    private String gender;

}

