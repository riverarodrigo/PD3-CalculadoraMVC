package com.calculadora.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalculadoraView extends JFrame {
    private final JTextField campoNumero1;
    private final JTextField campoNumero2;
    private final JLabel etiquetaOperacion;
    private final JLabel etiquetaResultado;

    private final JButton botonSuma;
    private final JButton botonResta;
    private final JButton botonMultiplicacion;
    private final JButton botonResultado;
    private final JButton botonLimpiar;

    private String operacionSeleccionada = "";

    public CalculadoraView() {
        setTitle("Calculadora - MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 520);
        setMinimumSize(new Dimension(540, 480));
        setLocationRelativeTo(null);

        campoNumero1 = crearCampoNumero();
        campoNumero2 = crearCampoNumero();
        etiquetaOperacion = new JLabel("Operación: ninguna");
        etiquetaResultado = new JLabel("Resultado: —");

        botonSuma = crearBoton("SUMA  (+)");
        botonResta = crearBoton("RESTA  (−)");
        botonMultiplicacion = crearBoton("MULTIPLICACIÓN  (×)");
        botonResultado = crearBoton("CALCULAR RESULTADO");
        botonLimpiar = crearBoton("LIMPIAR");

        construirInterfaz();
    }

    private JTextField crearCampoNumero() {
        JTextField campo = new JTextField();
        campo.setFont(new Font("SansSerif", Font.PLAIN, 24));
        campo.setHorizontalAlignment(SwingConstants.CENTER);
        campo.setPreferredSize(new Dimension(200, 52));
        return campo;
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.BOLD, 17));
        boton.setPreferredSize(new Dimension(150, 58));
        boton.setFocusPainted(false);
        return boton;
    }

    private void construirInterfaz() {
        JPanel principal = new JPanel(new BorderLayout(18, 22));
        principal.setBorder(new EmptyBorder(28, 35, 28, 35));

        JLabel titulo = new JLabel("CALCULADORA", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 30));
        principal.add(titulo, BorderLayout.NORTH);

        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));

        JLabel etiquetaNumero1 = crearEtiqueta("Primer número");
        JLabel etiquetaNumero2 = crearEtiqueta("Segundo número");
        centro.add(etiquetaNumero1);
        centro.add(Box.createVerticalStrut(7));
        centro.add(campoNumero1);
        centro.add(Box.createVerticalStrut(18));
        centro.add(etiquetaNumero2);
        centro.add(Box.createVerticalStrut(7));
        centro.add(campoNumero2);
        centro.add(Box.createVerticalStrut(22));

        JPanel operaciones = new JPanel(new GridLayout(1, 3, 10, 0));
        operaciones.add(botonSuma);
        operaciones.add(botonResta);
        operaciones.add(botonMultiplicacion);
        centro.add(operaciones);
        centro.add(Box.createVerticalStrut(18));

        etiquetaOperacion.setFont(new Font("SansSerif", Font.PLAIN, 17));
        centro.add(etiquetaOperacion);
        principal.add(centro, BorderLayout.CENTER);

        JPanel inferior = new JPanel();
        inferior.setLayout(new BoxLayout(inferior, BoxLayout.Y_AXIS));

        etiquetaResultado.setFont(new Font("SansSerif", Font.BOLD, 25));
        etiquetaResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
        inferior.add(etiquetaResultado);
        inferior.add(Box.createVerticalStrut(16));

        JPanel acciones = new JPanel(new GridLayout(1, 2, 12, 0));
        acciones.add(botonResultado);
        acciones.add(botonLimpiar);
        inferior.add(acciones);

        principal.add(inferior, BorderLayout.SOUTH);
        setContentPane(principal);
    }

    private JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("SansSerif", Font.BOLD, 18));
        return etiqueta;
    }

    public double obtenerNumero1() {
        return Double.parseDouble(campoNumero1.getText().trim());
    }

    public double obtenerNumero2() {
        return Double.parseDouble(campoNumero2.getText().trim());
    }

    public String obtenerOperacion() {
        return operacionSeleccionada;
    }

    public void seleccionarOperacion(String operacion) {
        operacionSeleccionada = operacion;
        etiquetaOperacion.setText("Operación seleccionada: " + operacion);
    }

    public void mostrarResultado(double resultado) {
        etiquetaResultado.setText("Resultado: " + resultado);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void limpiar() {
        campoNumero1.setText("");
        campoNumero2.setText("");
        operacionSeleccionada = "";
        etiquetaOperacion.setText("Operación: ninguna");
        etiquetaResultado.setText("Resultado: —");
        campoNumero1.requestFocus();
    }

    public JButton getBotonSuma() { return botonSuma; }
    public JButton getBotonResta() { return botonResta; }
    public JButton getBotonMultiplicacion() { return botonMultiplicacion; }
    public JButton getBotonResultado() { return botonResultado; }
    public JButton getBotonLimpiar() { return botonLimpiar; }
}
