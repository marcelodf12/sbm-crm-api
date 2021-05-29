package dev.mfranco.sbm.crm.mapper;

import dev.mfranco.sbm.crm.dto.PersonDto;
import dev.mfranco.sbm.crm.model.Nationality;
import dev.mfranco.sbm.crm.model.Person;
import dev.mfranco.sbm.crm.model.TypeDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mappings({
            @Mapping(target = "nationality", source = "person.nationality.code"),
            @Mapping(target = "typeDocument", source = "person.typeDocument.code"),
            @Mapping(target = "birthDate", source = "person.birthDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    PersonDto personToPersonDto(Person person);

    Person personDtoToPerson(PersonDto personDto);

    @Mappings({
            @Mapping(target = "code", source = "value")
    })
    Nationality mapNationality(String value);

    @Mappings({
            @Mapping(target = "code", source = "value")
    })
    TypeDocument mapTypeDocument(String value);
}
