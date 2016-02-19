import java.util.ArrayList;

public class testKort {
    public static void main(String[] args) {
        
        ArrayList<Kort> reg = new ArrayList<Kort>();
        
        Kort k1 = new Ansatt("Ole Olsen", 1234, 400, 3);
        Kort k2 = new Gjest("Marit Olsen", 9999);
        reg.add(k1);
        reg.add(k2);
        for (int i=0; i<reg.size(); i++) {
            Kort kort = (Kort)reg.get(i);
            System.out.print(kort);
            System.out.println("\nTest av kort med kode 1234" + (kort.sjekkPIN(1234) ?  " gyldig" :  " ugyldig" ) );
            System.out.println("\nTest av kort med kode 9999" + (kort.sjekkPIN(9999) ?  " gyldig" :  " ugyldig" ) );
        }
        Kort k3 = ((Ansatt)k1).Cloneable();
        Kort k4 = ((Gjest)k2).Cloneable();
        reg.add(k3);
        reg.add(k4);
        System.out.println(k1);
        System.out.println(k3);
        System.out.println(k1.compareTo(k2));
        System.out.println(k4.compareTo(k3));
        System.out.println(k1.compareTo(k3));
    }
}