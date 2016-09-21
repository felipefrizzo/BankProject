package br.univel.model.agency;

import javax.persistence.*;

/**
 * Created by felipefrizzo on 9/5/16.
 */
@Entity
@Table(name = "agency")
public class Agency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "numero_agency")
    private String numero;
    @Column(name = "cidade")
    private String cidade;

    public Agency() {
    }

    protected Agency(final String name, final String numero, final String cidade) {
        this.name = name;
        this.numero = numero;
        this.cidade = cidade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
