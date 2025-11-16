package com.pim.jrgs2526.pf03;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @ParametizedTest
    @ValueSource(ints = { 5, 6, 7 ,8, 10 })
    public void testCalcularAprobado(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(1, resultado);
    }

    @ParametizedTest
    @ValueSource(ints = { 1, 2 ,3, 4 })
    public void testCalcularSuspenso(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(-1, resultado);
    }

    @ParametizedTest
    @ValueSource(ints = { -10, -5, -1, 11, 12, 15})
    public void testCalcularError(int nota) {
        App main = new App();
        try {
            int resultado = main.calcularNota(nota);
        }
        catch (IllegalArgumentException e) {
            Assertions.assertEquals("Error al calcular la nota", e.getMessage());
            return;
        }
        Assertions.fail();
    }
}
