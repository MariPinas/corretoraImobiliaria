package org.example.Service;

import org.example.Model.Imovel;
import org.example.Model.Proprietario;
import org.example.Repository.ImobiliariaRepository;

import java.util.List;

public class ImobiliariaService {
    private final ImobiliariaRepository imobiliariaRepository;

    public ImobiliariaService(ImobiliariaRepository imobiliariaRepository) {
        this.imobiliariaRepository = imobiliariaRepository;
    }
    public void cadastrarImovel(Imovel imovel) {
        imobiliariaRepository.salvar(imovel);
    }

    public boolean deletarImovel(int id) {
        Imovel imovel = imobiliariaRepository.buscarPorId(id);

        if (imovel == null) {
            return false;
        }
        if (imovel.estaAlugado()) {
            System.out.println("ERRO: Imóvel não pode ser deletado enquanto estiver alugado.");
            return false;
        }
        return imobiliariaRepository.remover(id);
    }

    public void listarTodos() {
        System.out.println("\n--- Lista de Imóveis ---");
        List<Imovel> lista = imobiliariaRepository.buscarTodos();
        if (lista.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
        }
        for (int i = 0; i < lista.size(); i++) {
            Imovel imovelAtual = lista.get(i);
            System.out.printf("[%d] %s - %s - %s - R$ %.2f\n", i, imovelAtual.getEndereco(), imovelAtual.getNumero(), imovelAtual.getStatusDescricao(), imovelAtual.getValorBaseAluguel());
        }
    }

    public void listarTodosAlugados(){
        System.out.println("\n--- Imóveis Alugados ---");
        boolean encontrou = false;
        for (Imovel imovelAtual : imobiliariaRepository.buscarTodos()) {
            if (imovelAtual.estaAlugado()) {
                System.out.printf("%s - %s - %s - R$ %.2f\n", imovelAtual.getEndereco(), imovelAtual.getNumero(), imovelAtual.getStatusDescricao(), imovelAtual.getValorBaseAluguel());
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum imóvel alugado no momento.");
        }
    }

    public void alterarStatusAlugado(int id){
        Imovel imovel = imobiliariaRepository.buscarPorId(id);

        if(imovel !=null){
            imovel.setAlugado(!imovel.estaAlugado());
            System.out.println("-- Atualização de Status --");
            System.out.println(imovel.getStatusDescricao());
        }else{
            System.out.println("ERRO: Imóvel com ID " + id + " não encontrado.");
        }

    }

    public void calcularAluguel(int id, int meses){
            Imovel imovel = imobiliariaRepository.buscarPorId(id);
            if(imovel!=null){
                Integer total = imovel.calcularAluguel(meses);
                System.out.printf("Valor total do aluguel: R$ %.2f\n", total / 100.0);
            }else{
                System.out.println("Índice inválido!");
            }
    }

    public Proprietario cadastrarProprietario(String nome, String telefone, String cpf) {
        Proprietario proprietario = new Proprietario();
        proprietario.setNome(nome);
        proprietario.setTelefone(telefone);
        proprietario.setCPF(cpf);
        return proprietario;
    }

    public String contatarProprietario(int id) {
        Imovel imovel = imobiliariaRepository.buscarPorId(id);

        if (imovel == null) {
            return null;
        }

        return imovel.contatoProprietario();
    }

}


