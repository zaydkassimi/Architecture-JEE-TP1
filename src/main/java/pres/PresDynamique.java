package pres;

import dao.IDao;
import metier.IMetier;
import metier.MetierImpl;

import java.io.File;
import java.util.Scanner;

public class PresDynamique {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("src/main/resources/config.txt"));
        String daoClassName = scanner.nextLine();

        IDao dao = (IDao) Class.forName(daoClassName).getConstructor().newInstance();

        MetierImpl metier = new MetierImpl(dao);
        metier.setDao(dao);

        System.out.println("Res = " + metier.calcul());
    }
}