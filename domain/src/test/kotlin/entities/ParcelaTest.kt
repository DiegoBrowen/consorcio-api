package entities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestTemplate

internal class ParcelaTest {
    @Test
    fun `GIVEN um numero e o valor WHEN pedido para criar uma parcela THEN deve ser criada um parcela`() {
        val parcela = Parcela(1, 200f)

        assertEquals(1, parcela.numero)
        assertEquals(200f, parcela.valor)
    }
}