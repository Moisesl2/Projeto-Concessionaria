public class TesteVendedor {
    public static void main(String[] args) {
         
        Vendedor v = new Vendedor("Paulo", "1234", 34, "Rua av", "ann@gmail.com", 10);

        v.lerVendedor();
        System.out.println(v);
    }
}
