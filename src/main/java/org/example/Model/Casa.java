package org.example.Model;

import java.math.BigDecimal;

public class Casa extends Imovel{

    public Casa(String endereco, String numero, boolean alugado, Proprietario proprietario, BigDecimal valorBaseAluguel){
        super(endereco, numero, alugado, proprietario, valorBaseAluguel);
    }

    @Override
    public boolean estaAlugado() {
        return alugado;
    }

    @Override
    public String getStatusDescricao() {
        return estaAlugado() ? "A casa está alugada" : "A casa está disponível";
    }
}
