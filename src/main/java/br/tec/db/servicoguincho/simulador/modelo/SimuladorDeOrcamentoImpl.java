package br.tec.db.servicoguincho.simulador.modelo;


import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;
import br.tec.db.servicoguincho.simulador.interfaces.Guincho;
import br.tec.db.servicoguincho.simulador.interfaces.SimuladorDeOrcamento;
import br.tec.db.servicoguincho.simulador.interfaces.Trajeto;
import br.tec.db.servicoguincho.simulador.interfaces.Veiculo;

public class SimuladorDeOrcamentoImpl implements SimuladorDeOrcamento {
    @Override
    public double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto) {
        Guincho guincho = escolherGuincho(veiculo);
        return guincho.calcularCustoDeslocamento(trajeto);
    }
    private Guincho escolherGuincho(Veiculo veiculo) {
        boolean eLeve = veiculo.getTipo() == TipoVeiculo.CARRO || veiculo.getTipo() == TipoVeiculo.MINIVAN;
        boolean ePesado = veiculo.getTipo() == TipoVeiculo.ONIBUS || veiculo.getTipo() == TipoVeiculo.CAMINHAO;
        if (veiculo.getEstado() == EstadoConservacao.QUEBRADO) {
            return new GuinchoCorrenteEGancho();
        } else if (eLeve) {
            return new GuinchoPlataforma();
        } else if (ePesado) {
            return new GuinchoReboqueIntegrado();
        }
        throw new IllegalArgumentException("Não foi possível determinar o tipo de guincho.");
    }
}