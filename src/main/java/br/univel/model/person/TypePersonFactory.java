package br.univel.model.person;

import br.univel.cryptography.person.CryptographyFactory;

import java.util.Objects;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public class TypePersonFactory implements PersonFactory {
    private String pwd;
    private String passwd;
    @Override
    public Person create(TypePerson typePerson, String name, String username, Integer age, String cpf, String accessPassword, String operationPassword) {
        Objects.requireNonNull(typePerson, "Type Person cannot be null.");

        if (typePerson == TypePerson.CUSTOMER) {
            passwd = username + accessPassword;
        }

        switch (typePerson) {
            case CUSTOMER:
                pwd = new CryptographyFactory().create(passwd, typePerson);
                return new Customer(name, username, age, cpf, typePerson, pwd, operationPassword);
            case BANKING:
                pwd = new CryptographyFactory().create(accessPassword, typePerson);
                return new Banking(name, username, age, cpf, typePerson, pwd, operationPassword);
            default:
                throw new RuntimeException("Type cannot be found.");
        }
    }

}
