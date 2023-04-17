
public class Main {
    public static void main(String[] args) {
        double[] lados = {3.0, 4.0, 6.0};
        Triangulo triangulo = new Triangulo(lados);
        triangulo.exibirLados();
        System.out.printf("Perímetro: " + triangulo.calcularPerimetro());
    }
}