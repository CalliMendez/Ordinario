/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Exepciones.AlumnoExistenteException;
import Exepciones.AlumnoInexistenteException;
import java.util.ArrayList;
import objects.Alumno;

/**
 *
 * @author akbal
 */
public class Controlador {
    private ArrayList<Alumno> alumnos;
    
    public Controlador(){
    alumnos = new ArrayList<>();
    }
    
    public void addAlumno(Alumno alumno) throws AlumnoExistenteException{
    if(alumnos.contains(alumno)){
    throw new AlumnoExistenteException(); 
    }
    alumnos.add(alumno);
    }
    
    public ArrayList<Alumno> getAlumno(){
    return alumnos;
    }
    
    public Alumno getAlumno(String matricula) throws AlumnoInexistenteException{
    int index = alumnos.indexOf(new Alumno(matricula));
    
    if(index<0){
    throw new AlumnoInexistenteException();
    }
    return alumnos.get(index);
    }
    
    public Alumno getAlumno(int index){
    return alumnos.get(index);
    }
    
    public int getAlumnosCount(){
    return alumnos.size();
    }
    
}
