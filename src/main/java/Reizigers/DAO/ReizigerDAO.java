package Reizigers.DAO;

import Reizigers.Domein.Reiziger;

import java.util.List;

public interface ReizigerDAO {

    boolean save(Reiziger reiziger);

    Reiziger findById(int id);

    List<Reiziger> findAll();

    boolean update(Reiziger reiziger);

    boolean delete(Reiziger reiziger);
}
