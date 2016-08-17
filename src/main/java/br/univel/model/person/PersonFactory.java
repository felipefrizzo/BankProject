package br.univel.model.person;

/**
 * Created by felipefrizzo on 8/16/16.
 */
public interface PersonFactory {
    Person create(TypePerson typePerson, final String name, final Integer age,
                  final String cpf, final String accessPassword, final String operationPassword);
}
