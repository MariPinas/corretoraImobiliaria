package org.example.Repository;

import org.example.Model.Imovel;

import java.util.ArrayList;
import java.util.List;

public class ImobiliariaRepository {

    private final List<Imovel> listaImoveis = new ArrayList<>();

    public void salvar(Imovel imovel) {
        listaImoveis.add(imovel);
    }

    public List<Imovel> buscarTodos() {
        return new ArrayList<>(listaImoveis);
    }

    public Imovel buscarPorId(int id) {
        if (id >= 0 && id < listaImoveis.size()) {
            return listaImoveis.get(id);
        }
        return null;
    }

    public boolean remover(int id) {
        if (id >= 0 && id < listaImoveis.size()) {
            listaImoveis.remove(id);
            return true;
        }
        return false;
    }
}