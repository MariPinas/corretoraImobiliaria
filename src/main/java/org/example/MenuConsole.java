package org.example;
import org.example.Model.Apartamento;
import org.example.Model.Casa;
import org.example.Model.Proprietario;
import org.example.Service.ImobiliariaService;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuConsole {
    private final ImobiliariaService imobiliariaService;
    private final Scanner scanner = new Scanner(System.in);

    public MenuConsole(ImobiliariaService imobiliariaService) {
        this.imobiliariaService = imobiliariaService;
    }

    public void menu(){
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n=== MENU CORRETORA ===");
            System.out.println("1 - Cadastrar Casa");
            System.out.println("2 - Cadastrar Apartamento");
            System.out.println("3 - Deletar Imóvel");
            System.out.println("4 - Alugar/Disponibilizar Imóvel");
            System.out.println("5 - Calcular Aluguel");
            System.out.println("6 - Mostrar todos os imóveis");
            System.out.println("7 - Mostrar apenas imóveis alugados");
            System.out.println("8 - Contatar proprietário");
            System.out.println("0 - Sair");

            int opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarCasa();
                case 2 -> cadastrarApartamento();
                case 3 -> deletarImovel();
                case 4 -> alterarStatusAluguel();
                case 5 -> calcularAluguel();
                case 6 -> mostrarTodosImoveis();
                case 7 -> mostrarImoveisAlugados();
                case 8 -> contatarProprietario();
                case 0 -> rodando = false;
                default -> System.out.println("Opção inválida!");
            }
        }

        System.out.println("Sistema finalizado.");
        scanner.close();
    }

    private void cadastrarCasa() {
        String endereco = lerStringNaoVazia("Endereço: ");
        String numero = lerStringNaoVazia("Número: ");
        BigDecimal valor = lerBigDecimal("Valor base do aluguel: ");
        Proprietario proprietario = cadastrarProprietario();

        Casa casa = new Casa(endereco, numero, false, proprietario, valor);
        imobiliariaService.cadastrarImovel(casa);
        System.out.println("Casa cadastrada com sucesso!");
    }

    private void cadastrarApartamento(){
        String endereco = lerStringNaoVazia("Endereço: ");
        String numero = lerStringNaoVazia("Número: ");
        int numInterno = lerInteiro("Número interno do apartamento: ");
        BigDecimal valor = lerBigDecimal("Valor base do aluguel: ");
        Proprietario proprietario = cadastrarProprietario();

        Apartamento apto = new Apartamento(endereco, numero, false, proprietario, valor, numInterno);
        imobiliariaService.cadastrarImovel(apto);
        System.out.println("Apartamento cadastrado com sucesso!");
    }

    private Proprietario cadastrarProprietario(){
        String nome = lerStringNaoVazia("Nome do proprietário: ");
        String telefone = lerStringNaoVazia("Telefone: ");
        String cpf = lerStringNaoVazia("CPF: ");
        Proprietario proprietario = imobiliariaService.cadastrarProprietario(nome,telefone,cpf);;
        return proprietario;
    }

    private void deletarImovel(){
        mostrarTodosImoveis();
        int i = lerInteiro("Informe o índice do imóvel a deletar: ");
        boolean sucesso = imobiliariaService.deletarImovel(i);
        if (sucesso) {
            System.out.println("Imóvel deletado com sucesso!");
        } else {
            System.out.println("Índice inválido ou Imóvel não pode ser deletado!");
        }
    }

    private void mostrarTodosImoveis() {
        imobiliariaService.listarTodos();
    }

    private void alterarStatusAluguel(){
        mostrarTodosImoveis();
        int id = lerInteiro("Informe o índice do imóvel: ");
        imobiliariaService.alterarStatusAlugado(id);
    }

    private void calcularAluguel(){
        mostrarTodosImoveis();
        int id = lerInteiro("Informe o índice do imóvel: ");
        int meses = lerInteiro("Informe o número de meses: ");
        imobiliariaService.calcularAluguel(id, meses);

    }

    private void mostrarImoveisAlugados(){

        imobiliariaService.listarTodosAlugados();
    }

    private void contatarProprietario(){
        mostrarTodosImoveis();
        int id = lerInteiro("Informe o índice do imóvel alugado cujo proprietário deseja contatar: ");
        String telefone = imobiliariaService.contatarProprietario(id);

        if (telefone != null) {
            System.out.println("Contato do Proprietário:");
            System.out.println("Telefone: " + telefone);
        } else {
            System.out.println("Erro: Imóvel não encontrado ou não está alugado.");
        }
    }

    //------------------------------------------------------------

    public String lerStringNaoVazia(String mensagem) {
        String entrada;
        while (true) {
            System.out.print(mensagem);
            entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            } else {
                System.out.println("Este campo não pode ser vazio.");
            }
        }
    }

    public int lerInteiro(String mensagem) {
        while (true) {
            try {
                String entrada = lerStringNaoVazia(mensagem);
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro válido.");
            }
        }
    }

    public BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            try {
                String entrada = lerStringNaoVazia(mensagem).replace(",", ".");
                return new BigDecimal(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um valor numérico ex: 1500.50.");
            }
        }
    }
}
