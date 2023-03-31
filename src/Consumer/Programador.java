package Consumer;

import java.time.LocalDate;

public class Programador {

    private String nombre;
    private int salario;
private LocalDate fechaInicio;

    public Programador(String nombre) {
        this.nombre = nombre;
    }

    public Programador(String nombre, int salario, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }


    //class
}
