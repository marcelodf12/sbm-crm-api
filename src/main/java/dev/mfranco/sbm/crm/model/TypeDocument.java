package dev.mfranco.sbm.crm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sbm_crm_type_document")
@Data
@NoArgsConstructor
public class TypeDocument extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_document_generator")
    @SequenceGenerator(name = "type_document_generator", sequenceName = "type_document_sequence", initialValue = 1000)
    private Long idTypeDocument;

    @NotNull
    @Size(max=64)
    @Column(unique = true)
    private String name;

    @NotNull
    @Size(max=3)
    @Column(unique = true)
    private String code;

}

