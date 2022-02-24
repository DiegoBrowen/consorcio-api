package entities

import java.time.LocalDate
import java.util.*

class Consorcio(
    val nome: String,
    val quantidadeDeParticipantes: Int,
    val valorParcelaInicial: Float,
    val valorIncrementalPorParcelas: Float,
    val dataInicio: LocalDate,
) {
    var parcelas: MutableList<Parcela> = mutableListOf()
        private set

    var participantes: MutableList<Participante> = mutableListOf()
        private set

    init {
        var valorParcela = valorParcelaInicial
        for (numerParcela in 1..quantidadeDeParticipantes) {
            val parcela = Parcela(numerParcela, valorParcela)
            parcelas.add(parcela)
            valorParcela += valorIncrementalPorParcelas
        }
    }


    fun adicionarParticipante(nomeParticipante: String) {
        val dataContemplacao = obterDataDeContemplacao()
        val valorAReceber = obterValorAReceber()
        val participante = Participante(nomeParticipante, dataContemplacao, valorAReceber, parcelas)

        participantes.add(participante)
    }

    private fun obterDataDeContemplacao(): LocalDate {
        val quantidadeDeMeses = participantes.count().toLong()
        return dataInicio.plusMonths(quantidadeDeMeses)
    }

    private fun obterValorAReceber(): Float {
        val quantidadeParticipante = participantes.count()
        return quantidadeDeParticipantes.times(parcelas[quantidadeParticipante].valor)
    }
}