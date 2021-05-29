package dev.mfranco.sbm.crm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sbm_crm_relationship")
@Data
@NoArgsConstructor
public class Relationship extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relationship_generator")
    @SequenceGenerator(name = "relationship_generator", sequenceName = "relationship_sequence", initialValue = 1000)
    private Long idRelationship;

    @NotNull
    @Size(max=32)
    @Column(unique = true)
    private String name;

    @NotNull
    private Short level;

    @OneToOne
    @Null
    @JoinColumn(name = "id_relationship_bidirectional", updatable = false, nullable = false)
    private Relationship bidirectional;

}
