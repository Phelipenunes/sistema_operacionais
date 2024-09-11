package controller;

import model.Atleta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    private static final List<Atleta> rankingFinal = new ArrayList<>();

    public static synchronized void adicionarAtletaAoRanking(Atleta atleta) {
        rankingFinal.add(atleta);
    }

    public static void exibirRankingFinal() {
        rankingFinal.sort(Comparator.comparingInt(Atleta::getPontuacaoFinal).reversed());

        System.out.println("\n--- Ranking Final ---");
        for (int i = 0; i < rankingFinal.size(); i++) {
            Atleta atleta = rankingFinal.get(i);
            System.out.println((i + 1) + "º lugar: " + atleta.getNome() + " - Pontuação final: " + atleta.getPontuacaoFinal());
        }
    }
}
