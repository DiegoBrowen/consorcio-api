package entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ParticipanteTest {
    @Test
    fun `GIVEN um nome WHEN criar um novo participante THEN criar um participante`() {
        val partipante = Participante("Joao")

        assertEquals("Joao", partipante.nome)
    }
}