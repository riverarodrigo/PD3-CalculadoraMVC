package com.calculadora;

import com.calculadora.controller.CalculadoraController;
import com.calculadora.model.CalculadoraModel;
import com.calculadora.view.CalculadoraView;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraModel modelo = new CalculadoraModel();
            CalculadoraView vista = new CalculadoraView();
            new CalculadoraController(modelo, vista);
            vista.setVisible(true);
        });
    }
}
