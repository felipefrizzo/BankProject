package br.univel.model.agency;

import java.util.Objects;

/**
 * Created by felipefrizzo on 9/6/16.
 */
public class AgencyFactory {
    public Agency create (final String name, final Long numberAgency, final String numero, final String cidade) {
        Objects.requireNonNull(name, "Name cannot be null");

        return new Agency(name, numberAgency, numero, cidade);
    }
}
