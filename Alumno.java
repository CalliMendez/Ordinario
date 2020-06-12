/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author akbal
 */
public class Alumno {
    private String matricula;
    private String nombre;
    private String paterno;
    private String materno;
    private Fecha fechanacimiento;
    private Carrera carrera;
    
    public Alumno(String matricula){
    this.matricula=matricula;
    }

    public Alumno(String matricula, String nombre, String paterno, String materno, Fecha fechanacimiento, Carrera carrera) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.fechanacimiento = fechanacimiento;
        this.carrera = carrera;
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Alumno){
        Alumno alumno = (Alumno)obj;
        return this.matricula.compareTo(alumno.getMaticula()) == 0;
        }
        
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public String getMaticula() {
        return matricula;
    }

    public void setMaticula(String maticula) {
        this.matricula = maticula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public Fecha getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Fecha fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    
}
