package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class Pres {
    public static void main(String[] args){
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao);//constructeur
        //metier.setdao(dao); Setters
        System.out.println(metier.calcul());
    }
}
