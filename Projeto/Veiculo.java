
public class Veiculo {
    
    protected String marca;
    protected String modelo;
    private int quantidade;

    public Veiculo(String marca, String modelo, int quantidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    

    // novo metodo criado
    public boolean isVendido() {
        return false;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

  

    //  ESTA É UMA CLASSE PROVISORIA

    

}
