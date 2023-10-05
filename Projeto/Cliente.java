import java.util.List;
import java.util.Scanner;
public class Cliente extends Pessoa{
	    private double comprovanteDeRenda;

	    public Cliente(String nomeCompleto, String cpf, int idade, String endereco, String email,
	        double comprovanteDeRenda) {
	        super(nomeCompleto, cpf, idade, endereco, email);
	        this.comprovanteDeRenda = comprovanteDeRenda;
	    }

	    public double getComprovanteDeRenda() {
	        return comprovanteDeRenda;
	    }

	    public void setComprovanteDeRenda(double comprovanteDeRenda) {
	        this.comprovanteDeRenda = comprovanteDeRenda;
	    }


	    //metodo para criar um cliente
	    public static void criarCliente(List<Cliente> clientes, Cliente cliente){
	        clientes.add(cliente);
	    }

	    //Metodo para consultar um cliente pelo CPF
	    public static Cliente consultarCLiente(List<Cliente> clientes, String cpf){
	        for (Cliente cliente : clientes) {
	            if (cliente.getCpf().equals(cpf)) {
	                return cliente;
	            }
	        }
	        System.out.println("Cliente nao encontrado!");
	        return null;
	    }

	    @Override
	    public String toString() {
	    	return  super.toString()+ "Cliente [comprovanteDeRenda=" + comprovanteDeRenda + "]";
	    }
	    
}
