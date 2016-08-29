package br.univel.cryptography.person;

import br.univel.model.person.TypePerson;

/**
 * Created by felipefrizzo on 8/29/16.
 */
public class CryptographyFactory {
    public String create(String password, TypePerson typePerson) {
        switch (typePerson) {
            case CUSTOMER:
                return new CryptographyCustomer().createCryptography(password);
            case BANKING:
                return new CryptographyBanking().createCryptography(password);
            default:
                throw new RuntimeException("Type cannot be found.");
        }
    }
}
