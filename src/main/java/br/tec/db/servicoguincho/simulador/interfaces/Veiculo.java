package br.tec.db.servicoguincho.simulador.interfaces;
import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;

public interface Veiculo {
    TipoVeiculo getTipo();
    EstadoConservacao getEstado();
}
