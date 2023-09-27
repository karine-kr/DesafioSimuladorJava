## Desafio de OOP para um Simulador de Orçamento de Guincho

Você está encarregado de desenvolver um sistema de simulação para um serviço de guincho que atende diversos tipos de veículos em uma cidade fictícia com 4 bairros. Cada bairro é uma localização fixa na cidade.

Os três tipos de guinchos disponíveis são:

1. Caminhão de corrente e gancho: Mais barato e utilizado para veículos quebrados. Taxa de deslocamento: R$ 2,00 por quilômetro.
2. Caminhão de reboque integrado: Utilizado para veículos mais pesados, como ônibus. Taxa de deslocamento: R$ 10,00 por quilômetro.
3. Caminhão guincho de plataforma: Utilizado para veículos leves. Taxa de deslocamento: R$ 5,00 por quilômetro.

Os tipos de veículos a serem considerados são:

- Carro
- MiniVan
- Ônibus
- Caminhão

Cada veículo pode estar em um dos seguintes estados de conservação:

- Novo
- Quebrado

### Bairros Fictícios

A cidade fictícia possui 4 bairros:

- Centro
- Bairro A
- Bairro B
- Bairro C

### Tabela de Deslocamento (Deslocamento em quilômetros por trajeto)

Há uma tabela de deslocamento em quilômetros entre os bairros fictícios:

- C para A (e vice-versa): 10 km
- C para B (e vice-versa): 15 km
- C para C (e vice-versa): 5 km
- A para B (e vice-versa): 8 km

O calculo deve levar em conta que o guincho se desloca inicialmente do centro e deve retornar ao centro ao final do serviço. Se o ponto de partida for no centro, deve ser considerado o deslocamento C para C para buscar o veiculo.

### Estrutura do código
Este repositório já possui uma estrutura inicial que você deve seguir. Segue abaixo a descrição rápida de cada um dos elementos da estrutura.

```java
// Enum para tipos de veículos
enum TipoVeiculo {
    CARRO, MINIVAN, ONIBUS, CAMINHAO
}

// Enum para estados de conservação
enum EstadoConservacao {
    NOVO, QUEBRADO
}

// Interface para trajetos entre bairros
interface Trajeto {
    Integer getDistanciaEmKM();
}

// Interface para tipos de guincho
interface Guincho {
    double calcularCustoDeslocamento(Trajeto trajeto);
}

// Interface para tipos de veículos
interface Veiculo {
    TipoVeiculo getTipo();
    EstadoConservacao getEstado();
}

// Interface para calcular o custo total do orcamento
interface SimuladorDeOrcamento {
    double calcularCustoTotal(Veiculo veiculo, Trajeto trajeto);
}
```

### Cenários de teste
Abaixo deixamos algumas sugestões de cenários de teste para ajudar a validar a implementação.

#### Cenário 1: Guincho de Corrente e Gancho para Carro Novo do Centro para Bairro A e Retorno ao Centro

Tipo de Veículo: Carro
Estado de Conservação: Novo
Origem: Centro
Destino: Bairro A
Valor Esperado de Custo: R$ 125,00 ((5km + 10km + 10km) * R$ 5,00)

#### Cenário 2: Guincho de Plataforma para Ônibus Danificado do Bairro B para Bairro C e Retorno ao Centro

Tipo de Veículo: Ônibus
Estado de Conservação: Quebrado
Origem: Bairro B
Destino: Bairro C
Valor Esperado de Custo: R$ 350,00 ((15km + 15km + 5km) * R$ 10,00)


#### Cenário 3: Guincho de Reboque Integrado para Caminhão Quebrado do Bairro A para Centro e Retorno ao Centro

Tipo de Veículo: Caminhão
Estado de Conservação: Quebrado
Origem: Bairro A
Destino: Centro
Valor Esperado de Custo: R$ 250,00 ((10km + 10km + 5km) * R$ 10,00)


#### Cenário 4: Guincho de Reboque Integrado para Ônibus Novo do Centro para Centro (dentro do mesmo bairro)

Tipo de Veículo: Ônibus
Estado de Conservação: Novo
Origem: Centro
Destino: Centro
Valor Esperado de Custo: R$ 150,00 ((5km + 5km + 5km) * R$ 10,00)


#### Cenário 5: Guincho de Plataforma para Caminhão Semi Novo do Bairro B para Bairro B (dentro do mesmo bairro)

Tipo de Veículo: Caminhão
Estado de Conservação: Novo
Origem: Bairro B
Destino: Bairro B
Valor Esperado de Custo: R$ 350,00 ((15km + 5km + 15km) * R$ 10,00)


#### Cenário 6: Guincho de Corrente e Gancho para Carro Danificado do Centro para Bairro B e Retorno ao Centro

Tipo de Veículo: Carro
Estado de Conservação: Quebrado
Origem: Centro
Destino: Bairro B
Valor Esperado de Custo: R$ 50,00 ((5km + 10km + 10km) * R$ 2,00)
