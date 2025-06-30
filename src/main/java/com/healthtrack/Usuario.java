package com.healthtrack;

public class Usuario {
    private String nombre;
    private double peso;

    public Usuario(String nombre, double pesoInicial) {
        this.nombre = nombre;
        this.peso = pesoInicial;
    }

    // Método necesario para PruebaFuncionalSinUI
    public void setPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }

    // Método necesario para UsuarioTest
    public void actualizarPeso(double nuevoPeso) {
        this.peso = nuevoPeso;
    }

    public double getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }
}
