package Reizigers;

import Reizigers.DAO.ReizigerDAO;
import Reizigers.DAO.ReizigerDAOHibernate;
import Reizigers.Domein.Reiziger;
import Reizigers.Util.HibernateUtil;

import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        SessionFactory factory = HibernateUtil.getSessionFactory();
        ReizigerDAOHibernate reizigerDAO = new ReizigerDAOHibernate(factory);

        try {

            testReizigerDAO(reizigerDAO);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void testReizigerDAO(ReizigerDAO rdao) {
        System.out.println("\n---------- Test ReizigerDAO -------------");


        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        List<Reiziger> reizigers = rdao.findAll();
        if (reizigers.isEmpty()) {
            System.out.println("Geen reizigers gevonden.");
        } else {
            reizigers.forEach(System.out::println);
        }


        String geboortedatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77L, "S", null, "Boers", Date.valueOf(geboortedatum));
        System.out.print("\n[Test] ReizigerDAO.save() - Voeg Sietske Boers toe: ");
        boolean saved = rdao.save(sietske);
        if (saved) {
            System.out.println("Gelukt!");
        } else {
            System.out.println("Mislukt! Reiziger bestaat mogelijk al.");
        }


        System.out.println("\n[Test] ReizigerDAO.findAll() geeft de volgende reizigers na save:");
        reizigers = rdao.findAll();
        reizigers.forEach(System.out::println);


        System.out.println("\n[Test] ReizigerDAO.update() - Wijzig achternaam van Sietske Boers naar Jansen:");
        Reiziger toUpdate = rdao.findById(77L);
        if (toUpdate != null) {
            toUpdate.setAchternaam("Jansen");
            boolean updated = rdao.update(toUpdate);
            System.out.println(updated ? "Update gelukt!" : "Update mislukt!");
        } else {
            System.out.println("Reiziger met ID 77 niet gevonden.");
        }


        System.out.println("\n[Test] ReizigerDAO.findById(77L):");
        Reiziger updatedReiziger = rdao.findById(77L);
        System.out.println(updatedReiziger != null ? updatedReiziger : "Geen reiziger gevonden met ID 77.");

        System.out.println("\n[Test] ReizigerDAO.delete() - Verwijder Sietske Jansen:");
        boolean deleted = rdao.delete(toUpdate);
        System.out.println(deleted ? "Verwijdering gelukt!" : "Verwijdering mislukt!");


        System.out.println("\n[Test] ReizigerDAO.findAll() geeft de volgende reizigers na delete:");
        reizigers = rdao.findAll();
        if (reizigers.isEmpty()) {
            System.out.println("Geen reizigers gevonden.");
        } else {
            reizigers.forEach(System.out::println);
        }

        System.out.println("\n---------- Test ReizigerDAO Voltooid -------------");
    }
}



