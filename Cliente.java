import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa{
    private double renda;

    public Cliente(String nomeCompleto, String cpf, int idade, String endereco, String email,
        double renda) {
        super(nomeCompleto, cpf, idade, endereco, email);
        this.renda = renda;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }


    private static List<Cliente> clientes = new ArrayList<>();


    public static void criarCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();
        System.out.print("Email do Cliente: ");
        String email = scanner.nextLine();
        System.out.print("Idade do Cliente: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Endereço do Cliente: ");
        String endereco = scanner.nextLine();
        System.out.print("Renda do Cliente: ");
        double renda = scanner.nextDouble();
        scanner.nextLine(); // Consumir a quebra de linha

        Cliente cliente = new Cliente(nome, cpf, idade, endereco, email, renda);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

        // scanner.close();
    }
    

    public static List<Cliente> listarCliente(){
        return clientes;
    }

    public static void consultarCliente(){
        Scanner ent = new Scanner(System.in);
        System.out.println(" Digite o CPF do Cliente para a consulta: ");
        String cpf = ent.nextLine();
        boolean encontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println(cliente);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente nao encontrado! ");
        }
        // ent.close();
    }

    public static void atualizarCliente(){
        Scanner ent = new Scanner(System.in);
        System.out.println("digite o CPF do cliente que deseja atualizar: ");
        String cpf = ent.nextLine();
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println(" Novo Email: ");
                String email = ent.nextLine();
                System.out.println(" Nova Idade: ");
                int idade = ent.nextInt();
                ent.nextLine();
                System.out.println(" Novo Endereco: ");
                String endereco = ent.nextLine();
                System.out.println(" Nova Renda: ");
                double renda = ent.nextDouble();
                ent.nextLine();


                cliente.setEmail(email);
                cliente.setIdade(idade);
                cliente.setEndereco(endereco);
                cliente.setRenda(renda);

                System.out.println(" Cliente atualizado com sucesso");
                encontrado = true;

                
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Cliente não encontrado");
        }
        // ent.close();
    }

    public static void excluirCliente(){
        Scanner ent = new Scanner(System.in);
        System.out.println(" Insira o CPF do cliente para ser removido: ");
        String cpf = ent.nextLine();
        boolean removido = clientes.removeIf(cliente -> cliente.getCpf().equals(cpf));

        if (removido) {
            System.out.println("Cliente Removido com sucesso! ");
        } else {
            System.out.println("Cliente nao encontrado! ");
        }
        // ent.close();
    }

    public static void lerCliente() {
        Scanner ent = new Scanner(System.in);
        System.out.print("Digite o CPF do cliente que deseja ler: ");
        String cpf = ent.nextLine();
        boolean encontrado = false;

        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("\nInformações do Cliente:");
                System.out.println(cliente);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Cliente não encontrado.");
        }

        // ent.close();
    }

    //Metodo para Realizar pagamento

    public static void realizarPagamento(Cliente cliente, double valor){
        if (cliente == null){
            System.out.println("Cliente não encontrado!");
            return;
        }

        if(valor <= 0){
            System.out.println(" Valor invalido!");
            return;
        }

        System.out.println("O pagamento foi de R$" + valor);
    }

    //Metodo para a solicitação do veiculo
    public static void SolicitarVeiculo(Cliente cliente, Veiculo veiculo){
        if (cliente == null || veiculo == null) {
            System.out.println("Cliente  ou veiculo nao encontrados");
            return;
        }

        System.out.println("Solicitacao aceita!");
        System.out.println("Veiculo " + veiculo.getMarca() + veiculo.getModelo());
    }

     public static void salvarDados(String nomeArquivo){
        try {
            FileWriter fileWriter = new FileWriter(nomeArquivo);
            PrintWriter prinWriter = new PrintWriter(fileWriter);

            for (Cliente cliente : clientes) {
                prinWriter.println(" Nome Completo: " + cliente.getNomeCompleto() + "\nCPF: " + cliente.getCpf() + "\nIdade: " + cliente.getIdade() + "\nEndereco: " + cliente.getEndereco() + "\nEmail: " + cliente.getEmail() + "\nRenda:" + cliente.renda);
            }
            prinWriter.close();

        } catch (IOException e) {
            System.out.println(" Ocorreu um Erro no Arquivo..." + nomeArquivo + "\n");
            e.printStackTrace();
        }

    }

    public static void lerDados(String nomeArquivo){
        try {
            FileReader fileReader = new FileReader(nomeArquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            

            String linha;

            while ((linha = bufferedReader.readLine()) != null) {
               String[] dados = linha.split(";"); 

               if (dados.length >= 6) {
                   String nomeCompleto = dados[0].trim();
                   String cpf = dados[1].trim();
                   int idade = Integer.parseInt(dados[2].trim());
                   String endereco = dados[3].trim();
                   String email = dados[4].trim();
                   double renda = Double.parseDouble(dados[5].trim());

                   Cliente novoCliente = new Cliente(nomeCompleto, cpf, idade, endereco, email, renda);

                   System.out.println("Nome Completo: " + novoCliente.getNomeCompleto());
                   System.out.println("CPF: " + novoCliente.getCpf());
                   System.out.println("Idade: " + novoCliente.getIdade());
                   System.out.println("Endereco: " + novoCliente.getEndereco());
                   System.out.println("Email: " + novoCliente.getEmail());
                   System.out.println("Renda: " + novoCliente.getRenda());
                   System.out.println();
                   clientes.add(novoCliente);
                }
            }
            bufferedReader.close();


        } catch (IOException e) {
            System.out.println(" Ocorreu um erro ao carregar os dados!" + nomeArquivo + "\n" );
            e.printStackTrace();
        } catch (NumberFormatException e){
            System.out.println(" Erro na conversao dos valores numericos! ");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "O Cliente " + super.toString() + " Renda: " + renda;
    }


}