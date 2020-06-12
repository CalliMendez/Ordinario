/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author akbal
 */
public class WorkPanel extends JPanel {
    private JTable tblalumnos;
    private AlumnosModel model;
    
    public WorkPanel(Controlador controlador){
    super.setBackground(Color.CYAN);
    super.setLayout(new BorderLayout());
    
    model = new AlumnosModel(controlador);
    tblalumnos = new JTable(model);
    
    super.add(new JScrollPane(tblalumnos), BorderLayout.CENTER);
    }
}
