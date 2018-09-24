import entidades.Produto;

public class Main {

    public static void main (String[] args)
    {
        Produto produto = new Produto("Cereal", 20.0, 25);
        Produto produto2 = new Produto("Coca-Cola", 5.0, 7.50);

        System.out.println(produto.toString());
        System.out.println(produto2.toString());
    }
}
