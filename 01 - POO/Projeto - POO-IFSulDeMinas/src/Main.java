import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.oficina.Oficina;
import br.com.concessionaria.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Declarar 3 objetos diferentes da classe Veiculo.
        Veiculo veiculo1 = new Veiculo("ABC-1234", 1992, 3515165, "ABC-1234", "branco", 20000);
        Veiculo veiculo2 = new Veiculo("DEF-5678", 2012, 6512656, "DEF-5678", "verde", 15000);
        Veiculo veiculo3 = new Veiculo("GHI-9101", 2016, 5166513, "GHI-9101", "azul", 500);

        // Declarar 10 objetos diferentes da classe Peca.
        Peca peca1 = new Peca("Óleo", 50.0f, "10/01/2023");
        Peca peca2 = new Peca("Filtro de óleo", 30.0f, "10/01/2023");
        Peca peca3 = new Peca("Filtro de ar", 20.0f, "10/01/2023");
        Peca peca4 = new Peca("Vela de ignição", 40.0f, "10/01/2023");
        Peca peca5 = new Peca("Correia dentada", 80.0f, "10/01/2023");
        Peca peca6 = new Peca("Bateria", 150.0f, "10/01/2023");
        Peca peca7 = new Peca("Pastilha de freio", 60.0f, "10/01/2023");
        Peca peca8 = new Peca("Disco de freio", 80.0f, "10/01/2023");
        Peca peca9 = new Peca("Amortecedor", 200.0f, "10/01/2023");
        Peca peca10 = new Peca("Embreagem", 300.0f, "10/01/2023");

        // Declarar 3 objetos diferentes da classe Mecanico.
        Mecanico mecanico1 = new Mecanico("João", 5, 2);
        Mecanico mecanico2 = new Mecanico("Maria", 7, 1);
        Mecanico mecanico3 = new Mecanico("Pedro", 3, 3);

        // Declarar 1 objeto da classe Oficina.
        Oficina oficina = new Oficina("Minha Oficina");

        // Adicione no objeto Oficina: veículos, motoristas e peças
        oficina.adicionarVeiculo(veiculo1);
        oficina.adicionarVeiculo(veiculo2);
        oficina.adicionarVeiculo(veiculo3);

        oficina.adicionarPeca(peca1);
        oficina.adicionarPeca(peca2);
        oficina.adicionarPeca(peca3);
        oficina.adicionarPeca(peca4);
        oficina.adicionarPeca(peca5);
        oficina.adicionarPeca(peca6);
        oficina.adicionarPeca(peca7);
        oficina.adicionarPeca(peca8);
        oficina.adicionarPeca(peca9);
        oficina.adicionarPeca(peca10);

        oficina.adicionarMecanico(mecanico1);
        oficina.adicionarMecanico(mecanico2);
        oficina.adicionarMecanico(mecanico3);

        List<Veiculo> veiculosParaRevisao = new ArrayList<>();
        for (Veiculo veiculo : oficina.getListaVeiculos()) {
            if (veiculo.getKmRodados() >= 10000) {
                veiculosParaRevisao.add(veiculo);
            }
        }

        if (veiculosParaRevisao.isEmpty()) {
            System.out.println("Não há carros a serem revisados.");
        } else {
            boolean revisoesRealizadas = oficina.realizarRevisaoVeiculos();
            if (revisoesRealizadas) {
                System.out.println("Todas as revisões foram realizadas com sucesso!");
            } else {
                System.out.println("Não foi possível realizar todas as revisões por falta de mecânicos.");
            }
        }

    }
}