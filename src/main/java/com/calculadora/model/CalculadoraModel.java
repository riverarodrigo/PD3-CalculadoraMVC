package com.calculadora.model;

public class CalculadoraModel {

    public double calcular(double numero1, double numero2, String operacion) {
        switch (operacion) {
            case "Suma":
                return numero1 + numero2;
            case "Resta":
                return numero1 - numero2;
            case "Multiplicación":
                return numero1 * numero2;
            default:
                throw new IllegalArgumentException("Selecciona una operación.");
        }
    }
}
