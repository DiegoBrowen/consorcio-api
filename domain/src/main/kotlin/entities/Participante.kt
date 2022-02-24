package entities

import java.time.LocalDate
import java.util.*

class Participante(val nome: String, val dataContemplacao: LocalDate, val valorAReceber: Float, val parcelas: List<Parcela>) {
}