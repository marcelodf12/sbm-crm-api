package dev.mfranco.sbm.crm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sbm_crm_role")
@Data
@NoArgsConstructor
public class Role {

    @Id
    private String rolePerson;
}
