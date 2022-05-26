package lk.ijse.pos.dao;

public class Test {
    public static void main(String[] args) {
   /*     DAOFactory daoFactory = new DAOFactory();
        DAOFactory daoFactor2 = new DAOFactory();
        DAOFactory daoFactor3 = new DAOFactory();
        DAOFactory daoFactor4 = new DAOFactory();*/

        DAOFactory daoFactory = DAOFactory.getDaoFactory();
        DAOFactory daoFactory2 = DAOFactory.getDaoFactory();

        System.out.println(daoFactory);
        System.out.println(daoFactory2);
    }
}
