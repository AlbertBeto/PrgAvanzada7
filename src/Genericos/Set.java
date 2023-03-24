package Genericos;

public class Set <T>{
    private static final int TAM = 10;
    private T[] array = (T[]) new Object[TAM];

    public boolean insert(T element){
        int pase=0;
        for (Object o: array) {
            if (o.equals(null)){
                o=element;
                pase=1;
                return true;
            }
        }
        if (pase==0){return false;}
        else{return true;}
        }

public boolean delete(T element){
    int pase=0;
    for (Object o: array) {
        if (o.equals(element)){
            o=null;
            pase=1;
                    }
    }
    if (pase==0){return false;}
    else{return true;}
}

    public T find(T element){

        for (Object o: array) {
            if (o.equals(element)){
                return ;
            }
        }

    }




//class
}
