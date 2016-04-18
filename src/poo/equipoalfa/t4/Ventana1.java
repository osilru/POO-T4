/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.equipoalfa.t4;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;

/**
 *
 * @author jesus_ignacio_159, osilru
 */
public class Ventana1 extends JFrame implements ActionListener {

    //Declaramos las propiedades
    private JButton btnAceptar, btnCancelar;
    private JTextField txtNombre, txtEmail, txtTelefono;
    private JFormattedTextField txtIDTarjeta;

    //Constructor
    public Ventana1() {
        super("Alta de Cliente");
        setSize(400, 230);  //Establecemos las dimensiones del formulario (ancho x alto)
        setLocation(440, 100); //Establecemos la ubicación en pantalla (x,y)
        setResizable(false); //Para que no se pueda modificar el tamaño de la ventana

        //Paso 2. Vamos a crear una etiqueta
        JLabel lblNombre = new JLabel("Nombre: ");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblTelefono = new JLabel("Teléfono:");
        JLabel lblIDTarjeta = new JLabel("No. Tarjeta:");

        //Paso 3. Vamos a crear un campo de texto
        txtNombre = new JTextField();
        txtEmail = new JTextField();
        txtTelefono = new JTextField();
        //JFormattedTextField que limita el que solo se pueda escribir hast aun número de 20 dígito
        txtIDTarjeta = new JFormattedTextField(createFormatter("####################"));

        //Paso 4. Vamos a crear un botón.
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        //Paso 5. Vamos a crear el contenedor.
        JPanel pnlContenido = new JPanel(null); //Gestor nulo, util al usar setBounds

        //Paso 6. Ubicamos los elementos en el contenedor
        lblNombre.setBounds(10, 30, 60, 10); //x,y, ancho y alto
        txtNombre.setBounds(80, 25, 290, 25);
        lblEmail.setBounds(10, 60, 60, 10);
        txtEmail.setBounds(80, 55, 290, 25);
        lblTelefono.setBounds(10, 90, 60, 10);
        txtTelefono.setBounds(80, 85, 290, 25);
        lblIDTarjeta.setBounds(10, 120, 80, 15);
        txtIDTarjeta.setBounds(80, 115, 290, 25);
        btnAceptar.setBounds(100, 150, 90, 25);
        btnCancelar.setBounds(200, 150, 90, 25);

        //Paso 7. Agreguemos los componentes al contenedor
        pnlContenido.add(lblNombre);
        pnlContenido.add(txtNombre);
        pnlContenido.add(lblEmail);
        pnlContenido.add(txtEmail);
        pnlContenido.add(lblTelefono);
        pnlContenido.add(txtTelefono);
        pnlContenido.add(lblIDTarjeta);
        pnlContenido.add(txtIDTarjeta);
        pnlContenido.add(btnAceptar);
        pnlContenido.add(btnCancelar);

        //Paso 8. Asociamos el contenedor a la ventana
        setContentPane(pnlContenido);

        //Paso 9. Escucha de eventos.
        btnAceptar.addActionListener(this);
        btnCancelar.addActionListener(this);

        //Paso 10. Hacemos visible la ventana
        setVisible(true);
    }

    private void salir() {
        dispose();
    }
    
    // Código para verificar que se agrege un MaskFormatter correcto
    private MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.err.println("formatter is bad: " + exc.getMessage());
            System.exit(-1);
        }
        return formatter;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            String nombreDeCliente = txtNombre.getText();
            String email = txtEmail.getText();
            String telefono = txtTelefono.getText();
            String IDTarjeta = txtIDTarjeta.getText();
            
            if (Cliente.agregarCliente(nombreDeCliente, email, telefono, IDTarjeta)){
                JOptionPane.showMessageDialog(null, "Se ha agregado con éxito", "", -1);
                salir();
            } else{
                JOptionPane.showMessageDialog(null, "No se ha podido agregar", "Advertencia", 0);                
            }            
        } else {
            salir();
        }
    }
}