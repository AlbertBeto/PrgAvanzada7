package Genericos;

import java.util.ArrayList;
import java.util.List;

public class Calculadora<T extends Number> {

    T a1;
    T a2;

    ArrayList<T> listado;


    public Calculadora() {
       listado = new ArrayList<>();
    }

    public void colocador(ArrayList colocator, T b1, T b2){
        colocator.clear();
        colocator.add(b1);
        colocator.add(b2);
    }

    public T suma(T num1, T num2){
        colocador(listado,num1,num2);
        T suma=listado.get(0)+listado.get(1);
        return ;
    }



    //class
}
