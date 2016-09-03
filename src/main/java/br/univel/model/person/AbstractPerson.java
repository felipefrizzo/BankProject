package br.univel.model.person;

import javax.persistence.*;

/**
 * Created by felipefrizzo on 8/16/16.
 */
@MappedSuperclass
public abstract class AbstractPerson implements Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "username")
    private String username;
    @Column(name = "age")
    private Integer age;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "type_person")
    private TypePerson typePerson;
    @Column(name = "access_password")
    private String accessPassword;
    @Column(name = "operation_password")
    private String operationPassword;

    protected AbstractPerson(final String name, final String username, final Integer age, final String cpf,
                             TypePerson typePerson, final String accessPassword, final String operationPassword) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.cpf = cpf;
        this.typePerson = typePerson;
        this.accessPassword = accessPassword;
        this.operationPassword = operationPassword;
    }

    protected AbstractPerson() {
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getCpf() {
        return this.cpf;
    }

    @Override
    public TypePerson getTypePerson() {
        return this.typePerson;
    }

    @Override
    public String getAccessPassword() {
        return this.accessPassword;
    }

    @Override
    public String getOperationPassword() {
        return this.operationPassword;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTypePerson(TypePerson typePerson) {
        this.typePerson = typePerson;
    }

    public void setAccessPassword(String accessPassword) {
        this.accessPassword = accessPassword;
    }

    public void setOperationPassword(String operationPassword) {
        this.operationPassword = operationPassword;
    }
}
