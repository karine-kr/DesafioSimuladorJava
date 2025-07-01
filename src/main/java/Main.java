import br.tec.db.servicoguincho.simulador.cargas.EstadoConservacao;
import br.tec.db.servicoguincho.simulador.cargas.TipoVeiculo;
import br.tec.db.servicoguincho.simulador.interfaces.SimuladorDeOrcamento;
import br.tec.db.servicoguincho.simulador.interfaces.Trajeto;
import br.tec.db.servicoguincho.simulador.interfaces.Veiculo;
import br.tec.db.servicoguincho.simulador.modelo.SimuladorDeOrcamentoImpl;
import br.tec.db.servicoguincho.simulador.modelo.TrajetoEntreBairros;
import br.tec.db.servicoguincho.simulador.modelo.VeiculoImpl;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new VeiculoImpl(TipoVeiculo.ONIBUS, EstadoConservacao.QUEBRADO);
        Trajeto trajeto = new TrajetoEntreBairros("C", "C");
        SimuladorDeOrcamento simulador = new SimuladorDeOrcamentoImpl();
        double custo = simulador.calcularCustoTotal(veiculo, trajeto);
        System.out.printf("Custo total do guincho: R$ %.2f%n", custo);
    }
}
