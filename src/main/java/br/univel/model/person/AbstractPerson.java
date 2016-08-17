package br.univel.model.person;

import javax.persistence.*;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public abstract class AbstractPerson implements Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private final Long id;
    @Column(name = "name")
    private final String name;
    @Column(name = "age")
    private final Integer age;
    @Column(name = "cpf")
    private final String cpf;
    @Column(name = "type_person")
    private final TypePerson typePerson;
    @Column(name = "access_password")
    private final String accessPassword;
    @Column(name = "operation_password")
    private final String operationPassword;

    protected AbstractPerson(final Long id, final String name, final Integer age, final String cpf,
                             TypePerson typePerson, final String accessPassword, final String operationPassword) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cpf = cpf;
        this.typePerson = typePerson;
        this.accessPassword = accessPassword;
        this.operationPassword = operationPassword;
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
}
