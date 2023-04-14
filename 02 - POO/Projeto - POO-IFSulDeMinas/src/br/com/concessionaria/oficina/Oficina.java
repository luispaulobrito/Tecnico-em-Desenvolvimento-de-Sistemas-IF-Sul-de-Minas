package br.com.concessionaria.oficina;

import br.com.concessionaria.estrutura.Peca;
import br.com.concessionaria.funcionarios.Mecanico;
import br.com.concessionaria.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Oficina {
    private String nomeOficina;
    private List<Mecanico> listaMecanicos = new ArrayList<>();
    private List<Peca> listaPecas = new ArrayList<>();
    private List<Veiculo> listaVeiculos = new ArrayList<>();
    private int pecasNecessarias;

    public Oficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public String getNomeOficina() {
        return nomeOficina;
    }

    public void setNomeOficina(String nomeOficina) {
        this.nomeOficina = nomeOficina;
    }

    public List<Mecanico> getListaMecanicos() {
        return listaMecanicos;
    }

    public void setListaMecanicos(List<Mecanico> listaMecanicos) {
        this.listaMecanicos = listaMecanicos;
    }

    public List<Peca> getListaPecas() {
        return listaPecas;
    }

    public void setListaPecas(List<Peca> listaPecas) {
        this.listaPecas = listaPecas;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public int getPecasNecessarias() {
        return pecasNecessarias;
    }

    public void setPecasNecessarias(int pecasNecessarias) {
        this.pecasNecessarias = pecasNecessarias;
    }

    public void adicionarMecanico(Mecanico mecanico) {
        listaMecanicos.add(mecanico);
    }

    public void removerMecanico(Mecanico mecanico) {
        listaMecanicos.remove(mecanico);
    }

    public void adicionarPeca(Peca peca) {
        listaPecas.add(peca);
    }

    public void removerPeca(Peca peca) {
        listaPecas.remove(peca);
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
        int numPecas = (int) (Math.random() * 3) + 1;
        for (int i = 0; i < numPecas; i++) {
            listaPecas.add(new Peca("Peça " + (listaPecas.size() + 1), 10.0F, "19/03/2023"));
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        listaVeiculos.remove(veiculo);
    }

    public int verificarPecasRevisao() {
        int totalPecasNecessarias = 0;
        for (Veiculo veiculo : listaVeiculos) {
            int numPecas = (int) (Math.random() * 3) + 1;
            totalPecasNecessarias += numPecas;
        }
        System.out.println("Serão necessárias " + totalPecasNecessarias + " peças para as revisões.");
        pecasNecessarias = totalPecasNecessarias;
        return totalPecasNecessarias;
    }
    public boolean realizarRevisaoVeiculos() {
        if (listaVeiculos.isEmpty()) {
            System.out.println("Não há carros a serem revisados.");
            return false;
        }

        if (pecasNecessarias > listaPecas.size()) {
            System.out.println("Não há peças suficientes para realizar as revisões.");
            return false;
        }

        int numMecanicosNecessarios = (int) Math.ceil(listaVeiculos.size() / listaMecanicos.get(0).getCarrosSimultaneos());
        if (numMecanicosNecessarios > listaMecanicos.size()) {
            System.out.println("Não há mecânicos suficientes para realizar as revisões.");
            return false;
        }

        System.out.println("As revisões foram realizadas com sucesso!");
        System.out.println("Placas dos carros:");
        for (Veiculo veiculo : listaVeiculos) {
            System.out.println(veiculo.getPlaca());
        }

        System.out.println("Valor total das revisões: R$" + (listaVeiculos.size() * 100.0));
        // Remover as peças utilizadas
        for (int i = 0; i < pecasNecessarias; i++) {
            listaPecas.remove(0);
        }

        // Remover os carros revisados
        listaVeiculos.clear();

        return true;
    }

}