
public class Veiculo {
    
    protected String marca;
    protected String modelo;
    private int anoDeFabricacao;
    private String cor;
    private String estadoDoVeiculo;
    private int quantidade;
    

    public Veiculo(String marca, String modelo,int anoDeFabricacao,String cor,String estadoDoVeiculo, int quantidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoDeFabricacao = anoDeFabricacao;
        this.cor = cor;
        this.estadoDoVeiculo = estadoDoVeiculo;
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
    
    public int getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(int anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEstadoDoVeiculo() {
        return estadoDoVeiculo;
    }

    public void setEstadoDoVeiculo(String estadoDoVeiculo) {
        this.estadoDoVeiculo = estadoDoVeiculo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //  NOVO METODO CRIADO 
    public boolean isVendido() {
        return false;
    }

  

    //  ESTA É UMA CLASSE PROVISORIA

    

}
