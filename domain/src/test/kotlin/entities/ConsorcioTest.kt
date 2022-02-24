package entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.util.*

internal class ConsorcioTest {

    @Test
    fun `Given um nome, periodo, valor inicial e valor incremental WHEN for pedido para criar um consorcio THEN deve ser criado um consorcio com a quantidade definidas com parcelas por participante`() {
        val consorcio = Consorcio("Consorcio 22/23", 10, 200f, 5f, LocalDate.of(2022, 3, 1))

        assertEquals("Consorcio 22/23", consorcio.nome)
        assertEquals(200f, consorcio.valorParcelaInicial)
        assertEquals(5f, consorcio.valorIncrementalPorParcelas)
        assertEquals(LocalDate.of(2022, 3, 1), consorcio.dataInicio)
        assertEquals(10, consorcio.quantidadeDeParticipantes)

        assertTrue(consorcio.parcelas.any { x -> x.numero == 1 && x.valor == 200f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 2 && x.valor == 205f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 3 && x.valor == 210f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 4 && x.valor == 215f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 5 && x.valor == 220f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 6 && x.valor == 225f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 7 && x.valor == 230f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 8 && x.valor == 235f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 9 && x.valor == 240f })
        assertTrue(consorcio.parcelas.any { x -> x.numero == 10 && x.valor == 245f })
    }

    @Test
    fun `GIVEN um consorcio WHEN adicionar participantes THEN insere participates, com a data de recebimento e suas parcelas e valores a receber`() {
        val consorcio = Consorcio("Consorcio 22/23", 10, 200f, 5f, LocalDate.of(2022, 3, 1))

        consorcio.adicionarParticipante("Participante 1")
        consorcio.adicionarParticipante("Participante 2")
        consorcio.adicionarParticipante("Participante 3")

        assertTrue(consorcio.participantes.any { x ->
            x.nome == "Participante 1" && x.dataContemplacao == LocalDate.of(2022, 3, 1) && x.valorAReceber == 2000f
        })

        assertTrue(consorcio.participantes.any { x ->
            x.nome == "Participante 2" && x.dataContemplacao == LocalDate.of(2022, 4, 1) && x.valorAReceber == 2050f
        })

        assertTrue(consorcio.participantes.any { x ->
            x.nome == "Participante 3" && x.dataContemplacao == LocalDate.of(2022, 5, 1) && x.valorAReceber == 2100f
        })


    }
}