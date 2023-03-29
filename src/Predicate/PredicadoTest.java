package Predicate;

import java.util.function.Predicate;

public class PredicadoTest implements Predicate {
    @Override
    public boolean test(Object o) {
        if (o.equals("vive")) {
            System.out.println("It's alive!!!!!!");
        }
        return false;
    }
    public static void main(String[] args) {
        String estado="vive";
        Predicate<String> comoEsta = x -> x.equals("vive");
        System.out.println(comoEsta.test(estado));
    }
//class
}