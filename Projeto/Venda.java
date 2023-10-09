import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;

// CASO APRESENTE ALGUM ERRO VERIFICAR O NOME DO ATRIBUTO "QUANTIDADE"

public class Venda{
    private String status;
    private LocalDate data;
    private double valor;
    private Veiculo veiculo;
    private Cliente cliente;
    private Vendedor vendedor;

    public Venda(String status, LocalDate data, double valor, Veiculo veiculo, Cliente cliente, Vendedor vendedor) {
        this.status = status;
        this.data = data;
        this.valor = valor;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    private static List<Venda> vendas = new ArrayList<>();
    private static List<Veiculo> veiculos = new ArrayList<>();
    private static List<Vendedor> vendedores = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();


    public static void criarVenda(){
        Scanner scanner = new Scanner(System.in);
 
        System.out.println(" Nome Completo do Cliente: ");
        String nomeCompleto = scanner.nextLine();
        System.out.println(" CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.println(" Idade do Cliente: ");
        int idade = scanner.nextInt();
        System.out.println(" Endereco do Cliente: ");
        String endereco = scanner.nextLine();
        System.out.println(" Email do Cliente: ");
        String email = scanner.nextLine();
        System.out.println(" Renda do Cliente: ");
        double renda = scanner.nextDouble();
        scanner.nextLine();

        //Vendedor
        System.out.println(" Nome do Vendedor: ");
        String nomeCompleto2 = scanner.nextLine();
        System.out.println(" CPF do Vendedor: ");
        String cpf2 = scanner.nextLine();
        System.out.println(" Idade do Vendedor: ");
        int idade2 = scanner.nextInt();
        System.out.println(" Endereco do Vendedor: ");
        String endereco2 = scanner.nextLine();
        System.out.println(" Email do Vendedor: ");
        String email2 = scanner.nextLine();
        System.out.println(" Comissão: ");
        double comissao = scanner.nextDouble();
        System.out.println(" Salario: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();
        
        //veiculo
        System.out.println(" Marca do Veiculo: ");
        String marca = scanner.nextLine();
        System.out.println(" Modelo do Veiculo: ");
        String modelo = scanner.nextLine();
        System.out.println(" Ano de fabricacao: ");
        int anoDeFabricacao = scanner.nextInt();
        System.out.println(" Cor do Veiculo: ");
        String cor = scanner.nextLine();
        System.out.println(" Estado do Veiculo: ");
        String estadoDoVeiculo = scanner.nextLine();
        System.out.println(" quantidade de Veiculos: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
 
        //Venda
        System.out.println("Status da Venda: ");
        String status = scanner.nextLine();
        System.out.println(" Data da Venda (AAAA-MM-DD): ");
        String stringData = scanner.nextLine();
        LocalDate data = LocalDate.parse(stringData);
        System.out.println(" Valor da Venda: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Cliente clienteAdicionado = new Cliente(nomeCompleto, cpf, idade, endereco, email, renda);
        Vendedor vendedorAdicionado = new Vendedor(nomeCompleto2, cpf2, idade2, endereco2, email2, comissao);
        Veiculo veiculoAdicionado = new Veiculo(marca, modelo, anoDeFabricacao, cor, estadoDoVeiculo, quantidade);
        Venda venda = new Venda(status, data, valor, veiculoAdicionado, clienteAdicionado, vendedorAdicionado);

        vendas.add(venda);
        System.out.println(" Venda cadastrada com sucesso! ");
        // scanner.close();
        
    }

    public static Venda consultarVenda(List <Venda> vendas, LocalDate data){
        for (Venda venda : vendas) {
            System.out.println(" Venda encontrada: ");
            if (venda.getData().equals(data)){
                return venda;
            }
        }
        System.out.println("Venda nao encontrada!");
        return null;
    }

    //atualizar vendas
    public static boolean atualizarVenda(List <Venda> vendas, LocalDate data, Venda novaVenda){
        Venda vendaExistente = consultarVenda(vendas, data);
        if (vendaExistente != null) {
            int index = vendas.indexOf(vendaExistente);
            vendas.set(index, novaVenda);
            return true;
        }
        return false;

    }

    //deletar venda
    public static boolean deletarVenda(List <Venda> vendas, LocalDate data){
        Venda vendaExistente = consultarVenda(vendas, data);
        if (vendaExistente != null) {
            vendas.remove(vendaExistente);
            System.out.println(" Venda Deletada do  Sistema! ");
            return true;
        }
        System.out.println(" Venda nao encontrada! ");
        return false;
    }

    //Ler vendas
    public static Venda lerVenda(){
        Scanner ent = new Scanner(System.in);

        System.out.print("Status da Venda: ");
        String status = ent.nextLine();
        System.out.print("Data da Venda (AAAA-MM-DD): ");
        String stringData = ent.nextLine();
        LocalDate data = LocalDate.parse(stringData);
        System.out.println("Valor da Venda: ");
        double valor = ent.nextDouble();

        //listar os veiculos disponiveis
        System.out.println("Veiculos Disponiveis: ");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (!veiculo.isVendido()) {
                System.out.println("O veiculo " + i + ". " + veiculo.getMarca() + veiculo.getModelo() + veiculo.getAnoDeFabricacao() + veiculo.getCor() + veiculo.getEstadoDoVeiculo() + veiculo.getQuantidade());  
            }    
        }

        System.out.println(" Selecione o veiculo (Digite um numero): ");
        int veiculoIndex = ent.nextInt();
        ent.nextLine();
        Veiculo veiculoSelecionado = veiculos.get(veiculoIndex);

        //Listagem dos Clientes
        System.out.println("Clientes no Sistema: ");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            System.out.println("O Cliente: " + i + ". " + cliente.getNomeCompleto());

        }

        System.out.println("Selecione um Cliente ( Digite o numero ): ");
        int  clienteIndex = ent.nextInt();
        ent.nextLine();
        Cliente clienteEscolhido = clientes.get(clienteIndex);


        System.out.println("Vendedores disponiveis: ");
        for (int i = 0; i < vendedores.size(); i++) {
            Vendedor vendedor = vendedores.get(i);
            System.out.println("O vendedor: " + i + " . " + vendedor.getNomeCompleto());   
        }

        System.out.println("Selecione um Vendedor ( Digite o numero ): ");
        int vendedorIndex = ent.nextInt();
        ent.nextLine();
        Vendedor vendedorEscolhido = vendedores.get(vendedorIndex);

        // ent.close();

        return new Venda(status, data, valor, veiculoSelecionado, clienteEscolhido, vendedorEscolhido);
    }

    //Criar uma Solicitação de venda
    public static Venda criarSolicitacao(List <Cliente> clientes, List <Veiculo> veiculos, Cliente cliente, Vendedor vendedor){
        Scanner ent = new Scanner(System.in);

        System.out.println("Solicitacao de Veiculo: ");
        System.out.print("Data da Solicitacao (AAAA-MM-DD): ");
        String dataString = ent.nextLine();
        LocalDate data = LocalDate.parse(dataString);

        //listar veiculos disponiveis para solicitação
        System.out.println("Veiculos disponiveis para a solicitacao: ");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo veiculo = veiculos.get(i);
            if (!veiculo.isVendido()) {
                System.out.println("O veiculo: " + i + ". " + veiculo.getMarca() + veiculo.getModelo() + veiculo.getQuantidade());
            }
        }

        System.out.println(" Selecione o veiculo (Digite um numero): ");
        int veiculoIndex = ent.nextInt();
        ent.nextLine();
        Veiculo veiculoSelecionado = veiculos.get(veiculoIndex);

        System.out.println("Solicitacao Criada!!");
        String status = "Pendente";

        // ent.close();

        return new Venda(status, data, 0, veiculoSelecionado, cliente, vendedor);
    }

    //Listar Solicitação Pendente
    public static void listarSolicitacoesPententes(List <Venda> vendas){
        System.out.println("Solicitacoes Pendentes: ");
        for (Venda venda : vendas) {
            if ("Pendente".equalsIgnoreCase(venda.status)) {
                System.out.println(" DATA: " + venda.getData());
                System.out.println(" CLIENTE: " + venda.getCliente().getNomeCompleto());
                System.out.println(" VEICULO: " + venda.getVeiculo().getMarca() + " " + venda.getVeiculo().getModelo() + " " + " " + venda.getVeiculo().getAnoDeFabricacao() + " " + venda.getVeiculo().getCor() + " " + venda.getVeiculo().getEstadoDoVeiculo() + " " + venda.getVeiculo().getQuantidade());
                System.out.println("-------------------------");
            } 
        }
    }

    public static void listarRegistroDeVendas(List <Venda> vendas){
        System.out.println("Registro de Vendas: ");
        for (Venda venda : vendas) {
            System.out.println(" STATUS: " + venda.getStatus());
            System.out.println(" DATA: " + venda.getData());
            System.out.println(" VALOR: " + venda.getValor());
            System.out.println(" CLIENTE: " + venda.getCliente().getNomeCompleto());
            System.out.println(" VEICULO: " + venda.getVeiculo().getMarca() + " " + venda.getVeiculo().getModelo() + " " + " " + venda.getVeiculo().getAnoDeFabricacao() + " " + venda.getVeiculo().getCor() + " " + venda.getVeiculo().getEstadoDoVeiculo() + " " + venda.getVeiculo().getQuantidade());
            System.out.println(" VENDEDOR: " + venda.getVendedor().getNomeCompleto());
            System.out.println("-------------------------"); 
        }
    }

    public static void excluirSolicitacao(List <Venda> vendas){
        Scanner ent = new Scanner(System.in);

        System.out.println("Digite a data da Solicitacao para ser excluida (DD-MM-AAAA): ");
        String dataString = ent.nextLine();
        LocalDate data = LocalDate.parse(dataString);

        Venda solicitacaoParaExcluir = null;

        for (Venda venda : vendas) {
            if ("Pendente".equalsIgnoreCase(venda.getStatus()) && venda.getData().equals(data)) {
                solicitacaoParaExcluir = venda;
                break;
            }
        }

        if (solicitacaoParaExcluir != null) {
            vendas.remove(solicitacaoParaExcluir);
            System.out.println(" Solicitacao Excluida!!");
        }else{
            System.out.println(" A solicitacao nao esta pendente ou nao existe!");
        }

        // ent.close();
    }

    public static void salvarDados(String nomeArquivo){
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            for (Venda venda : vendas) {
                printWriter.println(" Status da Venda: " + venda.getStatus() + " Data da Venda: " + venda.getData() + " Valor da Venda: " + venda.getValor() + " Veiculo: " + venda.getVeiculo() + " Vendedor: " + venda.getVendedor() + " Cliente: " + venda.getCliente());
                
            }
            printWriter.close();

        } catch (Exception e) {
            System.out.println(" Ocorreu um Erro no Arquivo..." + nomeArquivo + "\n");
            e.printStackTrace();
        }
    }

    public static void lerDados(String nomeArquivo){
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedrReader = new BufferedReader(fileReader);

            String linha;

            while((linha = bufferedrReader.readLine())!= null){
                String[] dados = linha.split(";");

                if (dados.length >= 17) {
                    String nomeCompleto = dados[0].trim();
                    String cpf = dados[1].trim();
                    int idade =Integer.parseInt(dados[2].trim());
                    String endereco = dados[3].trim();
                    String email = dados[4].trim();
                    double renda = Double.parseDouble(dados[5].trim());
                    double comissao = Double.parseDouble(dados[6].trim());
                    double salario = Double.parseDouble(dados[7].trim());
                    String marca = dados[8].trim();
                    String modelo = dados[9].trim();
                    int anoDeFabricacao = Integer.parseInt(dados[10].trim());
                    String cor = dados[11].trim();
                    String estadoDoVeiculo = dados[12].trim();
                    int quant = Integer.parseInt(dados[13].trim());
                    String status = dados[14].trim();
                    LocalDate data = LocalDate.parse(dados[15].trim());
                    double valor = Double.parseDouble(dados[16].trim());

                    Cliente novoCliente = new Cliente(nomeCompleto, cpf, idade, endereco, email, renda);
                    Vendedor novoVendedor = new Vendedor(nomeCompleto, cpf, idade, endereco, email, comissao);
                    Veiculo novoVeiculo = new Veiculo(marca, modelo, anoDeFabricacao, cor, estadoDoVeiculo, quant);
                    Venda novaVenda = new Venda(status, data, valor, novoVeiculo, novoCliente, novoVendedor);
                    System.out.println("Nome Completo do Cliente: " + novoCliente.getNomeCompleto());
                    System.out.println("CPF do Cliente:: " + novoCliente.getCpf());
                    System.out.println("Idade do Cliente:: " + novoCliente.getIdade());
                    System.out.println("Endereco do Cliente:: " + novoCliente.getEndereco());
                    System.out.println("Email do Cliente:: " + novoCliente.getEmail());
                    System.out.println("Renda do Cliente:: " + novoCliente.getRenda());

                    //Vendedor 
                    System.out.println("Nome Completo do Vendedor: " + novoVendedor.getNomeCompleto());
                    System.out.println("CPF do Vendedor: " + novoVendedor.getCpf());
                    System.out.println("Idade do Vendedor: " + novoVendedor.getIdade());
                    System.out.println("Endereco do Vendedor: " + novoVendedor.getEndereco());
                    System.out.println("Email do Vendedor: " + novoVendedor.getEmail());
                    System.out.println("Comissao do Vendedor: " + novoVendedor.getComissao());
                    System.out.println(" Salario do Vendedor: " + novoVendedor.getSalario());

                    //veiculo
                    System.out.println(" Marca: " + novoVeiculo.getMarca());
                    System.out.println(" Modelo: " + novoVeiculo.getModelo());
                    System.out.println(" Ano de Fabricação: " + novoVeiculo.getAnoDeFabricacao());
                    System.out.println(" Cor do Veiculo" + novoVeiculo.getCor());
                    System.out.println(" Estado do Veiculo: " + novoVeiculo.getEstadoDoVeiculo());
                    System.out.println(" Quantidade de veiculos: " + novoVeiculo.getQuantidade());

                    //Venda
                    System.out.println(" Status da Venda: " + novaVenda.getStatus());
                    System.out.println(" Data da Venda: " + novaVenda.getData());
                    System.out.println(" Valor da Venda: " + novaVenda.getValor());
                    vendas.add(novaVenda);
                }
            }
            bufferedrReader.close();


        } catch (IOException e) {
            System.out.println(" Ocorreu um erro ao carregar os dados! " + nomeArquivo + "\n" );
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println(" Erro na conversao dos valores numericos! ");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Venda Status Da Venda: " + status + " Data da Venda: " + data + " Valor da Venda: " + valor + " Veiculo: " + veiculo + " Cliente: " + cliente + " Vendedor: " + vendedor ;
    }

}