package dev.mfranco.sbm.crm.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sbm_crm_nationality")
@Data
@NoArgsConstructor
public class Nationality extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nationality_generator")
    @SequenceGenerator(name = "nationality_generator", sequenceName = "nationality_sequence", initialValue = 1000)
    private Long idNationality;

    @NotNull
    @Size(max=32)
    @Column(unique = true)
    private String countryName;

    @NotNull
    @Size(max=32)
    @Column(unique = true)
    private String demonym;

    @NotNull
    @Size(max=3)
    @Column(unique = true)
    private String code;

}
