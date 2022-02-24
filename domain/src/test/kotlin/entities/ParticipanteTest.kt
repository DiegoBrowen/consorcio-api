package entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

internal class ParticipanteTest {
    @Test
    fun `GIVEN um nome, data de recebimendo e parcelas WHEN criar um novo participante THEN criar um participante, com as parcelas e valores corretos`() {
        val parcelas = listOf(
            Parcela(1, 200f),
            Parcela(2, 205f)
        )
        val partipante = Participante(
            "Joao", LocalDate.of(2022, 3, 1), 1000f,
            parcelas
        )
        assertEquals("Joao", partipante.nome)
        assertEquals(LocalDate.of(2022,3,1), partipante.dataContemplacao)
        assertEquals(2, partipante.parcelas.count())
        assertEquals(1000f, partipante.valorAReceber)
    }
}