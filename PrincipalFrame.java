/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Exepciones.AlumnoExistenteException;
import Interfaces.AlumnoListener;
import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import objects.Alumno;

/**
 *
 * @author akbal
 */
public class PrincipalFrame extends JFrame {
    
    private EncabezadoPanel pnlEncabezado;
    private BusquedaPanel pnlBusqueda;
    private WorkPanel pnlWork;
    
    private Controlador controlador;
    
    private AlumnoDialog dlgAlumno;
    
    public PrincipalFrame(){
    super("Control Escolar");
    super.setLayout(new BorderLayout());
    super.setSize(800,300);
    super.setLocationRelativeTo(null);
    
    dlgAlumno = new AlumnoDialog(this);
    dlgAlumno.setListener(new AlumnoListener() {
        @Override
        public void aceptarBotonclick(Alumno alumno) {
            try {
               controlador.addAlumno(alumno); 
               dlgAlumno.setVisible(false);
            } catch (AlumnoExistenteException ex) {
                JOptionPane.showMessageDialog(PrincipalFrame.this, "La matricula ya ha sido insertada anteriormente", 
                        "matricula invalida", JOptionPane.ERROR_MESSAGE);
            }
  //To change body of generated methods, choose Tools | Templates.
        }
    });
    
    controlador = new Controlador();
    
    pnlEncabezado = new EncabezadoPanel();
    
    pnlWork = new WorkPanel(controlador);
    
    pnlBusqueda = new BusquedaPanel();
    
    super.setJMenuBar(createMenu());
    
    super.add(pnlEncabezado,BorderLayout.NORTH);
    super.add(pnlBusqueda,BorderLayout.SOUTH);
    super.add(pnlWork,BorderLayout.CENTER);
    
    super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    super.setVisible(true);
    }
    
    private JMenuBar createMenu(){
    JMenuBar mbMain = new JMenuBar();
    
    
    JMenu mmArchivo = new JMenu("Archivo");
    JMenuItem miNuevo = new JMenuItem("Nuevo Alumno");
    miNuevo.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dlgAlumno.setVisible(true); //To change body of generated methods, choose Tools | Templates.
        }
    });
    JMenuItem miSalir = new JMenuItem("Salir");
    miSalir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0); //To change body of generated methods, choose Tools | Templates.
        }
    });
    mmArchivo.add(miNuevo);
    mmArchivo.addSeparator();
    mmArchivo.add(miSalir);
    
    JMenu mmAyuda = new JMenu("Ayuda");
    JMenuItem miAcerca = new JMenuItem("Acerca de...");
    mmAyuda.add(miAcerca);
    
    
    mbMain.add(mmArchivo);
    mbMain.add(mmAyuda);
    
    return mbMain;
    }
    
}
