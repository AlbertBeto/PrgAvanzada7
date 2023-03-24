package Genericos;

import java.util.ArrayList;

public class Liga <T extends Equipo> implements Comparable<Liga> {

    private String nombre;

    private ArrayList<T> equipos;

    public Liga(String nombre) {
        this.nombre = nombre;
        equipos = new ArrayList();
    }


    public boolean addEquipo (T t){

        if (equipos.contains(t)){
            //Hay que quitar el castin
            System.out.println("El equipo ya existe "+((Equipo)t).getNombre()+" ya existe.");
            return false;
        }else{
            equipos.add(t);
            System.out.println("Se ha añadido el equipo "+((Equipo)t).getNombre());
            return true;
        }
    }

public void printEquipos(Liga<T> t){
        //t.equipos.sort(Equipo.ranking());
    for (Equipo e  : t.equipos  ) {
        System.out.println(e.getNombre());
    }
    }


    //  No funciona el ordenamiento por ranking. He perdido demasiado tiempo con esto.
    @Override
    public int compareTo(Liga o) {
        return 0;
    }

    //class
}
