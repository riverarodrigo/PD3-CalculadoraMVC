package com.calculadora.controller;

import com.calculadora.model.CalculadoraModel;
import com.calculadora.view.CalculadoraView;

public class CalculadoraController {
    private final CalculadoraModel modelo;
    private final CalculadoraView vista;

    public CalculadoraController(CalculadoraModel modelo, CalculadoraView vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.getBotonSuma().addActionListener(e -> vista.seleccionarOperacion("Suma"));
        vista.getBotonResta().addActionListener(e -> vista.seleccionarOperacion("Resta"));
        vista.getBotonMultiplicacion().addActionListener(
                e -> vista.seleccionarOperacion("Multiplicación"));
        vista.getBotonResultado().addActionListener(e -> calcularResultado());
        vista.getBotonLimpiar().addActionListener(e -> vista.limpiar());
    }

    private void calcularResultado() {
        try {
            double numero1 = vista.obtenerNumero1();
            double numero2 = vista.obtenerNumero2();
            String operacion = vista.obtenerOperacion();

            double resultado = modelo.calcular(numero1, numero2, operacion);
            vista.mostrarResultado(resultado);
        } catch (NumberFormatException e) {
            vista.mostrarError("Ingresa números válidos en los dos campos.");
        } catch (IllegalArgumentException e) {
            vista.mostrarError(e.getMessage());
        }
    }
}
