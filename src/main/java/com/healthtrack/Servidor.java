package com.healthtrack;

import static spark.Spark.*;
import com.healthtrack.Usuario;

public class Servidor {
    public static void main(String[] args) {
        port(4567);

        get("/", (req, res) -> {
            res.type("text/html");
            return "<!DOCTYPE html>" +
                   "<html><head><meta charset='UTF-8'><title>Actualizar Peso</title></head>" +
                   "<body>" +
                   "<h2>Formulario de Actualización de Peso</h2>" +
                   "<form method='post' action='/actualizar'>" +
                   "Nombre: <input type='text' name='nombre' required/><br/>" +
                   "Peso: <input type='number' name='peso' step='0.1' required/><br/>" +
                   "<input type='submit' value='Actualizar'/>" +
                   "</form>" +
                   "</body></html>";
        });

        post("/actualizar", (req, res) -> {
            res.type("text/plain");
            try {
                String nombre = req.queryParams("nombre");
                double peso = Double.parseDouble(req.queryParams("peso"));

                Usuario usuario = new Usuario(nombre, peso);
                usuario.actualizarPeso(peso);

                return "Nuevo peso actualizado para " + usuario.getNombre() + ": " + usuario.getPeso() + " kg";
            } catch (Exception e) {
                res.status(400);
                return "Error: asegúrate de que el peso es un número válido.";
            }
        });

        awaitInitialization();
        System.out.println("✅ Spark iniciado en http://localhost:4567");
    }
}
