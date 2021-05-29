package dev.mfranco.sbm.crm.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sbm_crm_person_relationship")
@Data
@NoArgsConstructor
public class PersonRelationship extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_relationship_generator")
    @SequenceGenerator(name = "person_relationship_generator", sequenceName = "person_relationship_sequence", initialValue = 1000)
    private Long idPersonRelationship;

    @ManyToOne
    @JoinColumn(name = "id_person_key", nullable = false, updatable = false)
    private Person personKey;

    @ManyToOne
    @JoinColumn(name = "id_person_relation", nullable = false, updatable = false)
    private Person personRelation;

    @ManyToOne
    @JoinColumn(name = "id_relationship", nullable = false, updatable = false)
    private Relationship relationship;

}
