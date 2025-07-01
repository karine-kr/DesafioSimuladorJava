package br.tec.db.servicoguincho.simulador.modelo;


import br.tec.db.servicoguincho.simulador.interfaces.Trajeto;

public class TrajetoEntreBairros implements Trajeto {
    private final String origem;
    private final String destino;
    public TrajetoEntreBairros(String origem, String destino) {
        this.origem = origem.toUpperCase();
        this.destino = destino.toUpperCase();
    }
    @Override
    public Integer getDistanciaEmKM() {
        if (origem.equals(destino)) return 5;
        if ((origem.equals("A") && destino.equals("B")) || (origem.equals("B") && destino.equals("A"))) return 8;
        if ((origem.equals("C") && destino.equals("A")) || (origem.equals("A") && destino.equals("C"))) return 10;
        if ((origem.equals("C") && destino.equals("B")) || (origem.equals("B") && destino.equals("C"))) return 15;
        throw new IllegalArgumentException("Trajeto inválido entre bairros: " + origem + " e " + destino);
    }
}