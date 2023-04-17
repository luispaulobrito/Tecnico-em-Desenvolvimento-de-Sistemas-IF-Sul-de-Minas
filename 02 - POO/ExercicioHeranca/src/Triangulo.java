public class Triangulo {
    private double lados[] = new double[3];

    public Triangulo(double[] lados) {
        this.lados = lados;
    }

    public double[] getLados() {
        return lados;
    }

    public void setLados(double[] lados) {
        this.lados = lados;
    }

    public double calcularPerimetro(){
        double perimetro = lados[0]+lados[1]+lados[2];
        return perimetro;
    }

    public void exibirLados(){
        System.out.println("Lado A: " + lados[0]);
        System.out.println("Lado B: " + lados[1]);
        System.out.println("Lado C: " + lados[2]);
    }
}
