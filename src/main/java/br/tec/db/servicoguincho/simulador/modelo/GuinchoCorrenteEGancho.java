package br.tec.db.servicoguincho.simulador.modelo;


import br.tec.db.servicoguincho.simulador.interfaces.Guincho;
import br.tec.db.servicoguincho.simulador.interfaces.Trajeto;

public class GuinchoCorrenteEGancho implements Guincho {
    @Override
    public double calcularCustoDeslocamento(Trajeto trajeto) {
        return trajeto.getDistanciaEmKM() * 2.0;
    }
}