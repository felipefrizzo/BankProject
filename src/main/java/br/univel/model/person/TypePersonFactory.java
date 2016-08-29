package br.univel.model.person;

import br.univel.cryptography.person.CryptographyFactory;

import java.util.Objects;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public class TypePersonFactory implements PersonFactory {
    private String pwd;
    @Override
    public Person create(TypePerson typePerson, String name, Integer age, String cpf, String accessPassword, String operationPassword) {
        Objects.requireNonNull(typePerson, "Type Person cannot be null.");
        switch (typePerson) {
            case CUSTOMER:
                StringBuilder newPassword = new StringBuilder();
                newPassword.append(name).append(accessPassword);

                pwd = new CryptographyFactory().create(newPassword.toString(), typePerson);
                return new Customer(name, age, cpf, typePerson, pwd, operationPassword);
            case BANKING:
                pwd = new CryptographyFactory().create(accessPassword, typePerson);
                return new Banking(name, age, cpf, typePerson, pwd, operationPassword);
            default:
                throw new RuntimeException("Type cannot be found.");
        }
    }

}
