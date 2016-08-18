package br.univel.model.person;

import java.util.Objects;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public class TypePersonFactory implements PersonFactory {
    @Override
    public Person create(TypePerson typePerson, String name, Integer age, String cpf, String accessPassword, String operationPassword) {
        Objects.requireNonNull(typePerson, "Type Person cannot be null.");
        switch (typePerson) {
            case CUSTOMER:
                return new Customer(name, age, cpf, typePerson, accessPassword, operationPassword);
            case BANKING:
                return new Banking(name, age, cpf, typePerson, accessPassword, operationPassword);
            default:
                throw new RuntimeException("Type cannot be found.");
        }
    }

}
