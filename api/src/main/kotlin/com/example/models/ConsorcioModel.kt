package com.example.models

import java.time.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class ConsorcioModel(val nome: String,
                          val quantidadeDeParticipantes: Int,
                          val valorParcelaInicial: Float,
                          val valorIncrementalPorParcelas: Float,
                          val dataInicio: String
) {
}