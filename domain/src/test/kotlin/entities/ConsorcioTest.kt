package entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

internal class ConsorcioTest {

    lateinit var participantes: List<Participante>

    @BeforeEach
    fun initialize() {
        participantes = listOf(Participante("entities.Participante 1"),
            Participante("entities.Participante 2"),
            Participante("entities.Participante 3"),
            Participante("entities.Participante 4"),
            Participante("entities.Participante 5"))
    }

    @Test
    fun `Given um nome, periodo, valor inicial e valor incremental WHEN for pedido para criar um consorcio THEN deve ser criado um consorcio com a quantidade definidas com parcelas por participante`() {
        val consorcio = Consorcio("entities.Consorcio 22/23", participantes, 200f, 5f, Date(2022, 3, 1))

        assertEquals("entities.Consorcio 22/23", consorcio.nome)
        assertEquals(200f, consorcio.valorInicial)
        assertEquals(5f, consorcio.valorIncrementalPorParcelas)
        assertEquals(Date(2022, 3, 1), consorcio.dataInicio)

    }
}