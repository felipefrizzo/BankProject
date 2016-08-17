package br.univel.model.person;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public interface Person {

    public Long getId();

    public String getName();

    public Integer getAge();

    public String getCpf();

    public TypePerson getTypePerson();

    public String getAccessPassword();

    public String getOperationPassword();
}
