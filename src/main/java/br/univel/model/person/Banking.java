package br.univel.model.person;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by felipefrizzo on 8/16/16.
 */
@Entity
@Table(name = "Person")
public class Banking extends AbstractPerson {
    protected Banking(String name, String username, Integer age, String cpf, TypePerson typePerson,
                      String accessPassword, String operationPassword) {
        super(name, username, age, cpf, typePerson, accessPassword, operationPassword);
    }

    protected Banking() {
    }
}
