package org.example.Model;

import java.math.BigDecimal;

public abstract class Imovel {
    protected String endereco;
    protected String numero;
    protected boolean alugado;
    private Proprietario proprietario;
    private BigDecimal valorBaseAluguel;

    public Imovel(String endereco, String numero, boolean alugado, Proprietario proprietario, BigDecimal valorBaseAluguel) {
        this.endereco = endereco;
        this.numero = numero;
        this.alugado = alugado;
        this.proprietario = proprietario;
        this.valorBaseAluguel=valorBaseAluguel;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getValorBaseAluguel() {
        return valorBaseAluguel;
    }

    public void setValorBaseAluguel(BigDecimal valorBaseAluguel) {
        this.valorBaseAluguel = valorBaseAluguel;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public boolean estaAlugado(){
        return this.alugado;
    };

    public String getStatusDescricao() {
        return estaAlugado() ? "O imóvel está alugado" : "O imóvel está disponível";
    }

    public String contatoProprietario(){
        return proprietario.getTelefone();
    }

    public Integer calcularAluguel(int meses){
        BigDecimal total = valorBaseAluguel.multiply(BigDecimal.valueOf(meses));
        return total.movePointRight(2).intValueExact();
    }

}
