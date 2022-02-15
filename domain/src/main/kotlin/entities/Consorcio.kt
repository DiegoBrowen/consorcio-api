package entities

import java.util.*

class Consorcio(
    val nome: String,
    participantes: List<Participante>,
    val valorInicial: Float,
    val valorIncrementalPorParcelas: Float,
    val dataInicio: Date,
) {
}