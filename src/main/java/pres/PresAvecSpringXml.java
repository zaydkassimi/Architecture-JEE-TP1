package pres;

import metier.IMetier;
import metier.MetierImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresAvecSpringXml {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        IMetier metier = (MetierImpl) context.getBean("metier");
        System.out.println(metier.calcul());
    }
}
