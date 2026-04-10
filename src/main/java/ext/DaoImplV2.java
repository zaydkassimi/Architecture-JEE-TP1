    package ext;

    import dao.IDao;
    import org.springframework.stereotype.Component;

    @Component("dao2")
    public class DaoImplV2 implements IDao {
        @Override
        public double getData(){
            System.out.println("version base de données");
            double temp=77;
            return temp;
        }
    }
