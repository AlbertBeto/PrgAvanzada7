package Stream;

import java.util.ArrayList;
import java.util.List;

public class Dept {

    private String nombre;
    private List<Emp> emps;

    public Dept(String nombre) {
        this.nombre = nombre;
        this.emps = new ArrayList<>();
    }


    public void addEmps(Emp emp){
        this.emps.add(emp);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }



    //class
}
