package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl implements IDao{
    public double getData(){
        System.out.println("version base de données");
        double temp=24;
        return temp;
    }
}
