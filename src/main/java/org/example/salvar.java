//import org.example.Model.Apartamento;
//import org.example.Model.Casa;
//import org.example.Model.Imovel;
//import org.example.Model.Proprietario;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//private static final List<Imovel> listaImoveis = new ArrayList<>();
//private static final Scanner scanner = new Scanner(System.in);
//
//public static void main(String[] args) {
//    boolean rodando = true;
//
//    while (rodando) {
//        System.out.println("\n=== MENU CORRETORA ===");
//        System.out.println("1 - Cadastrar Casa");
//        System.out.println("2 - Cadastrar Apartamento");
//        System.out.println("3 - Deletar Imóvel");
//        System.out.println("4 - Alugar/Disponibilizar Imóvel");
//        System.out.println("5 - Calcular Aluguel");
//        System.out.println("6 - Mostrar todos os imóveis");
//        System.out.println("7 - Mostrar apenas imóveis alugados");
//        System.out.println("0 - Sair");
//
//        int opcao = lerInteiro("Escolha uma opção: ");
//
//        switch (opcao) {
//            case 1 -> cadastrarCasa();
//            case 2 -> cadastrarApartamento();
//            case 3 -> deletarImovel();
//            case 4 -> alterarStatusAluguel();
//            case 5 -> calcularAluguel();
//            case 6 -> mostrarTodosImoveis();
//            case 7 -> mostrarImoveisAlugados();
//            case 0 -> rodando = false;
//            default -> System.out.println("Opção inválida!");
//        }
//    }
//
//    System.out.println("Sistema finalizado.");
//    scanner.close();
//}
//
//private static void cadastrarCasa() {
//    String endereco = lerStringNaoVazia("Endereço: ");
//    String numero = lerStringNaoVazia("Número: ");
//    BigDecimal valor = lerBigDecimal("Valor base do aluguel: ");
//    Proprietario proprietario = criarProprietario();
//
//    Casa casa = new Casa(endereco, numero, false, proprietario, valor);
//    listaImoveis.add(casa);
//    System.out.println("Casa cadastrada com sucesso!");
//}
//
//private static void cadastrarApartamento() {
//    String endereco = lerStringNaoVazia("Endereço: ");
//    String numero = lerStringNaoVazia("Número: ");
//    int numInterno = lerInteiro("Número interno do apartamento: ");
//    BigDecimal valor = lerBigDecimal("Valor base do aluguel: ");
//    Proprietario proprietario = criarProprietario();
//
//    Apartamento apto = new Apartamento(endereco, numero, false, proprietario, valor, numInterno);
//    listaImoveis.add(apto);
//    System.out.println("Apartamento cadastrado com sucesso!");
//}
//
//private static Proprietario criarProprietario() {
//    String nome = lerStringNaoVazia("Nome do proprietário: ");
//    String telefone = lerStringNaoVazia("Telefone: ");
//    String cpf = lerStringNaoVazia("CPF: ");
//
//    Proprietario proprietario = new Proprietario();
//    proprietario.setNome(nome);
//    proprietario.setTelefone(telefone);
//    proprietario.setCPF(cpf);
//    return proprietario;
//}
//
//private static void deletarImovel() {
//    mostrarTodosImoveis();
//    if (listaImoveis.isEmpty()){
//        System.out.println("Nenhum imóvel para deletar.");
//        return;
//    }
//    int i = lerInteiro("Informe o índice do imóvel a deletar: ");
//    if (i >= 0 && i < listaImoveis.size()) {
//        listaImoveis.remove(i);
//        System.out.println("Imóvel deletado com sucesso!");
//    } else {
//        System.out.println("Índice inválido!");
//    }
//}
//
//private static void alterarStatusAluguel() {
//    mostrarTodosImoveis();
//    if (listaImoveis.isEmpty()){
//        System.out.println("Nenhum imóvel para alterar.");
//        return;
//    }
//    int i = lerInteiro("Informe o índice do imóvel: ");
//    if (i >= 0 && i < listaImoveis.size()) {
//        Imovel imovel = listaImoveis.get(i);
//        imovel.setAlugado(!imovel.estaAlugado());
//        System.out.println("Status atualizado: " + imovel.getStatusDescricao());
//    } else {
//        System.out.println("Índice inválido!");
//    }
//}
//
//private static void calcularAluguel() {
//    mostrarTodosImoveis();
//    if (listaImoveis.isEmpty()){
//        System.out.println("Nenhum imóvel para calcular.");
//        return;
//    }
//    int i = lerInteiro("Informe o índice do imóvel: ");
//    if (i >= 0 && i < listaImoveis.size()) {
//        Imovel imovel = listaImoveis.get(i);
//        int meses = lerInteiro("Informe o número de meses: ");
//        Integer total = imovel.calcularAluguel(meses);
//        System.out.printf("Valor total do aluguel: R$ %.2f\n", total / 100.0);
//    } else {
//        System.out.println("Índice inválido!");
//    }
//}
//
//private static void mostrarTodosImoveis() {
//    System.out.println("\n--- Lista de Imóveis ---");
//    if (listaImoveis.isEmpty()) {
//        System.out.println("Nenhum imóvel cadastrado.");
//        return;
//    }
//    for (int i = 0; i < listaImoveis.size(); i++) {
//        Imovel imovelAtual = listaImoveis.get(i);
//        System.out.printf("[%d] %s - %s - %s\n", i, imovelAtual.getEndereco(), imovelAtual.getNumero(), imovelAtual.getStatusDescricao());
//    }
//}
//
//private static void mostrarImoveisAlugados() {
//    System.out.println("\n--- Imóveis Alugados ---");
//    boolean encontrou = false;
//    for (Imovel imovelAtual : listaImoveis) {
//        if (imovelAtual.estaAlugado()) {
//            System.out.printf("%s - %s - %s\n", imovelAtual.getEndereco(), imovelAtual.getNumero(), imovelAtual.getStatusDescricao());
//            encontrou = true;
//        }
//    }
//    if (!encontrou) {
//        System.out.println("Nenhum imóvel alugado no momento.");
//    }
//}
//
////-------------------------------------------------------------------------
//
//private static String lerStringNaoVazia(String mensagem) {
//    String entrada;
//    while (true) {
//        System.out.print(mensagem);
//        entrada = scanner.nextLine().trim();
//        if (!entrada.isEmpty()) {
//            return entrada;
//        } else {
//            System.out.println("Este campo não pode ser vazio.");
//        }
//    }
//}
//
//private static int lerInteiro(String mensagem) {
//    while (true) {
//        try {
//            String entrada = lerStringNaoVazia(mensagem);
//            return Integer.parseInt(entrada);
//        } catch (NumberFormatException e) {
//            System.out.println("Entrada inválida. Digite um número inteiro válido.");
//        }
//    }
//}
//
//private static BigDecimal lerBigDecimal(String mensagem) {
//    while (true) {
//        try {
//            String entrada = lerStringNaoVazia(mensagem).replace(",", ".");
//            return new BigDecimal(entrada);
//        } catch (NumberFormatException e) {
//            System.out.println("Entrada inválida. Digite um valor numérico ex: 1500.50.");
//        }
//    }
//}