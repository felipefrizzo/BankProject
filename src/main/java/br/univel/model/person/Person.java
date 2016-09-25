package br.univel.model.person;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public interface Person {

    public Long getId();

    public String getName();

    public String getUsername();

    public Integer getAge();

    public String getCpf();

    public TypePerson getTypePerson();

    public String getAccessPassword();

    public String getOperationPassword();

    public void setId(Long id);

    public void setName(String name);

    public void setAge(Integer age);

    public void setCpf(String cpf);

    public void setTypePerson(TypePerson typePerson);

    public void setAccessPassword(String accessPassword);

    public void setOperationPassword(String operationPassword);
}
