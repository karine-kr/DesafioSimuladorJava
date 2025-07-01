package br.tec.db.servicoguincho.simulador.modelo;

import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;
import br.tec.db.servicoguincho.simulador.interfaces.Veiculo;

public class VeiculoImpl implements Veiculo {
    private final TipoVeiculo tipo;
    private final EstadoConservacao estado;
    public VeiculoImpl(TipoVeiculo tipo, EstadoConservacao estado) {
        this.tipo = tipo;
        this.estado = estado;
    }
    @Override
    public TipoVeiculo getTipo() {
        return tipo;
    }
    @Override
    public EstadoConservacao getEstado() {
        return estado;
    }
}