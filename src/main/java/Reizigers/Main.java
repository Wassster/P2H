package Reizigers;

import Reizigers.DAO.ReizigerDAO;
import Reizigers.DAO.ReizigerDAOHibernate;
import Reizigers.Domein.Reiziger;
import Reizigers.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {


        SessionFactory factory = HibernateUtil.getSessionFactory();

        ReizigerDAOHibernate rdao = new ReizigerDAOHibernate(factory);

        testReizigerDAO(rdao);


        factory.close();
    }

    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");


        List<Reiziger> reizigers = null;
        reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();


        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");


        System.out.println("[Test] Update reiziger 77 (Sietske Boers) achternaam naar 'Jansen'");
        sietske.setAchternaam("Jansen");
        rdao.update(sietske);
        Reiziger updatedReiziger = null;
        updatedReiziger = rdao.findById(77);
        System.out.println("Geüpdatete reiziger: " + updatedReiziger);
        System.out.println();


    }}


