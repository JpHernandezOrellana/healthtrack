package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

    @Test
    public void testActualizarPeso() {
        Usuario usuario = new Usuario("Juan", 70.0);
        usuario.actualizarPeso(75.0);

        assertEquals(75.0, usuario.getPeso(), 0.001);

        System.out.println("[✅] Prueba unitaria: testActualizarPeso pasó correctamente con valor 75.0");
    }

    @Test
    public void testSimulacionActualizacionPeso() {
        Usuario usuario = new Usuario("Ana", 60.0);
        usuario.actualizarPeso(62.5);

        assertEquals(62.5, usuario.getPeso(), 0.001);

        System.out.println("[✅] Prueba unitaria: testSimulacionActualizacionPeso pasó correctamente con valor 62.5");
    }
}
