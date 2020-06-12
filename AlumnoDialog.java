/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.AlumnoListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import objects.Alumno;
import objects.Carrera;
import objects.Fecha;

/**
 *
 * @author akbal
 */
public class AlumnoDialog extends JDialog{
    
    String [] career = {"Sistemas","Derecho","Arquitectura","Psiologia"};
    
    private JPanel pnlWork;
    private JPanel pnlBotones;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    private JLabel lblmatricula;
    private JLabel lblnombre;
    private JLabel lblpaterno;
    private JLabel lblmaterno;
    private JLabel lblFnacimiento;
    private JLabel lblcarrera;
    
    private JTextField txtmatricula;
    private JTextField txtnombre;
    private JTextField txtpaterno;
    private JTextField txtmaterno;
    private JTextField txtdia;
    private JTextField txtmes;
    private JTextField txtanio;
    private JComboBox cmbCarrera;
    
    private AlumnoListener listener;
    
    public AlumnoDialog(JFrame owner){
    super(owner,"Datos del Alumno", true);
    super.setSize(400, 300);
    super.setLayout(new BorderLayout());
    super.setLocationRelativeTo(owner);
    
    lblmatricula= new JLabel("Matricula");
    lblnombre= new JLabel("Nombre");
    lblpaterno= new JLabel("A. Paterno");
    lblmaterno= new JLabel("A. Materno");
    lblFnacimiento= new JLabel("Fecha de Nacimiento");
    lblcarrera= new JLabel("Carrera");
    
    txtmatricula=new JTextField();
    txtnombre=new JTextField();
    txtpaterno=new JTextField();
    txtmaterno=new JTextField();
    txtdia=new JTextField();
    txtmes=new JTextField();
    txtanio=new JTextField();
    cmbCarrera=new JComboBox(career);
    
    btnAceptar = new JButton("Aceptar");
    btnAceptar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Integer dia = Integer.valueOf(txtdia.getText());
            Integer mes = Integer.valueOf(txtmes.getText());
            Integer anio = Integer.valueOf(txtanio.getText());
            Alumno alumno; //To change body of generated methods, choose Tools | Templates.
            alumno = new Alumno(txtmatricula.getText(),txtnombre.getText(), txtpaterno.getText()
                    , txtmaterno.getText(),new Fecha(dia,mes,anio), selectCarrera());
            listener.aceptarBotonclick(alumno);
            txtmatricula.setText("");
            txtnombre.setText("");
            txtpaterno.setText("");
            txtmaterno.setText("");
            txtdia.setText("");
            txtmes.setText("");
            txtanio.setText("");
        }
        
    });
    btnCancelar = new JButton("Cancelar");
    btnCancelar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AlumnoDialog.this.setVisible(false); //To change body of generated methods, choose Tools | Templates.
        }
    });
    
    pnlWork = new JPanel();
    pnlWork.setLayout(null);
    pnlWork.add(lblmatricula);
    lblmatricula.setBounds(10, 0, 100, 30);
    pnlWork.add(lblnombre);
    lblnombre.setBounds(10, 30, 100, 30);
    pnlWork.add(lblpaterno);
    lblpaterno.setBounds(10, 60, 100, 30);
    pnlWork.add(lblmaterno);
    lblmaterno.setBounds(10, 90, 100, 30);
    pnlWork.add(lblFnacimiento);
    lblFnacimiento.setBounds(10, 120, 120, 30);
    pnlWork.add(lblcarrera);
    lblcarrera.setBounds(10, 150, 100, 30);
    pnlWork.add(txtmatricula);
    txtmatricula.setBounds(80, 8, 120, 20);
    pnlWork.add(txtnombre);
    txtnombre.setBounds(80, 38, 120, 20);
    pnlWork.add(txtpaterno);
    txtpaterno.setBounds(80, 68, 120, 20);
    pnlWork.add(txtmaterno);
    txtmaterno.setBounds(80, 98, 120, 20);
    pnlWork.add(txtdia);
    txtdia.setBounds(140, 128, 30, 20);
    pnlWork.add(txtmes);
    txtmes.setBounds(180, 128, 30, 20);
    pnlWork.add(txtanio);
    txtanio.setBounds(220, 128, 50, 20);
    pnlWork.add(cmbCarrera);
    cmbCarrera.setBounds(80, 158, 100, 20);
    
    pnlBotones = new JPanel();
    pnlBotones.setLayout(new FlowLayout(FlowLayout.RIGHT));
    pnlBotones.setBackground(Color.RED);
    pnlBotones.add(btnAceptar);
    pnlBotones.add(btnCancelar);
    
    super.add(pnlBotones, BorderLayout.SOUTH);
    super.add(pnlWork, BorderLayout.CENTER);
    
    super.setVisible(false);
    }
    
    public void setListener(AlumnoListener listener){
    this.listener = listener;
    }
    
    public Carrera selectCarrera(){
    switch (cmbCarrera.getSelectedIndex()) {
                case 0:
                    return Carrera.SISTEMAS;
                case 1:
                    return Carrera.DERECHO;
                case 2:
                    return Carrera.ARQUITECTURA;
                case 3:
                    return Carrera.PSICOLOGIA;
                default:
                    throw new AssertionError();
            }
    }
}
