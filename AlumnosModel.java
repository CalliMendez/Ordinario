/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.Controlador;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import objects.Alumno;

/**
 *
 * @author akbal
 */
public class AlumnosModel extends AbstractTableModel{
    
    private Controlador oControler;
    
    public AlumnosModel(Controlador controlador){
    oControler = controlador;
    }

    @Override
    public int getRowCount() {
        return oControler.getAlumnosCount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 6; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno a = oControler.getAlumno(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getMaticula();
            case 1:
                return a.getNombre();
            case 2:
                return a.getPaterno();
            case 3:
                return a.getMaterno();
            case 4:
                return a.getFechanacimiento();
            case 5:
                return a.getCarrera();
            default:
                throw new AssertionError();
        }
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Matricula";
            case 1:
                return "Nombre";
            case 2:
                return "A. Paterno";
            case 3:
                return "A. Materno";
            case 4:
                return "Fecha Nacimiento";
            case 5:
                return "Carrera";
            default:
                throw new AssertionError();
        }
 //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
