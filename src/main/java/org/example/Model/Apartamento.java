package org.example.Model;

import java.math.BigDecimal;


public class Apartamento extends Imovel {
    private int numeroComplemento;

    public Apartamento(String endereco, String numero, boolean alugado, Proprietario proprietario,
                       BigDecimal valorBaseAluguel, int numeroComplemento) {
        super(endereco, numero, alugado, proprietario, valorBaseAluguel);
        this.numeroComplemento = numeroComplemento;
    }

    @Override
    public boolean estaAlugado() {
        return alugado;
    }

    @Override
    public String getStatusDescricao() {
        return estaAlugado() ?
                "O apartamento de número " + numeroComplemento + " está alugado" :
                "O apartamento de número " + numeroComplemento + " está disponível";
    }

    public int getnumeroComplemento() {
        return numeroComplemento;
    }

    public void setnumeroComplemento(int numeroComplemento) {
        this.numeroComplemento = numeroComplemento;
    }
}

