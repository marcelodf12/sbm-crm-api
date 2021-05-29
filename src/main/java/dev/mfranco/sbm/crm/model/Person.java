package dev.mfranco.sbm.crm.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "sbm_crm_person", uniqueConstraints = { @UniqueConstraint(columnNames = { "document_char", "id_nationality", "id_type_document" }) })
@Data
@NoArgsConstructor
public class Person extends AuditModel {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", initialValue = 1000)
    private Long idPerson;

    @NotNull
    @Size(min = 1, max = 128)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 128)
    private String lastName;

    @NotNull
    @Size(min = 1, max = 32)
    @Column(name="document_char")
    private String documentChar;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @ElementCollection
    @CollectionTable(name = "sbm_crm_person_email", joinColumns = { @JoinColumn(name = "person_id") })
    @MapKeyColumn(name = "id_person_email")
    @Column(name = "email")
    private Map<String, String> emailList = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "sbm_crm_person_telephone", joinColumns = { @JoinColumn(name = "person_id") })
    @MapKeyColumn(name = "id_person_telephone")
    @Column(name = "telephone")
    private Map<String, String> telephoneList = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "sbm_crm_person_address", joinColumns = { @JoinColumn(name = "person_id") })
    @MapKeyColumn(name = "id_person_address")
    @Column(name = "addressList")
    private Map<String, String> addressList = new HashMap<>();

    @ElementCollection
    @CollectionTable(name = "sbm_crm_person_additional_field", joinColumns = { @JoinColumn(name = "person_id") })
    @MapKeyColumn(name = "id_person_additional_field")
    @Column(name = "additional_field")
    private Map<String, String> additionalFieldList = new HashMap<>();

    @Size(max = 512)
    private String photo;

    @Size(max = 2)
    private String gender;

    @ElementCollection
    @CollectionTable(name = "sbm_crm_person_type_person", joinColumns = { @JoinColumn(name = "person_id") })
    @MapKeyColumn(name = "id_person_type_person")
    @Column(name = "type_person")
    private Map<String, String> typePerson = new HashMap<>();

    @ManyToOne
    @JoinColumn(name = "id_nationality", nullable = false)
    private Nationality nationality;

    @ManyToOne
    @JoinColumn(name = "id_type_document", nullable = false)
    private TypeDocument typeDocument;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personKey")
    private List<PersonRelationship> personKeyRelationshipList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personRelation")
    private List<PersonRelationship> personRelationRelationshipList;

    @ManyToMany
    @JoinTable(
            name = "sbm_access_user_rol",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "role_person"))
    private List<Role> RolePersonList;

    @Transient
    public String getCode(){
        return this.documentChar + "-" + this.typeDocument.getCode() + "-" + this.nationality.getCode();
    }
}

