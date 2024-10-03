package Reizigers.Domein;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="Reiziger")
public class Reiziger {

    @Id
    @Column(name= "reiziger_id")
    public int id;

    @Column(name = "voorletter")
    public String voorletter;

    @Column(name = "tussenvoegsel")
    public String tussenvoegsel;

    @Column(name = "achternaam")
    public String achternaam;

    @Column(name = "geboortedatum")
    public Date geboorteDatum;

    public Reiziger(int id, String voorletter,String tussenvoegsel, String achternaam, Date geboorteDatum) {
        this.id = id;
        this.voorletter = voorletter;
        this.achternaam = achternaam;
        this.geboorteDatum = geboorteDatum;
    }

    public Reiziger() {

    }

    public int getId() {
        return id;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Date getGeboorteDatum() {
        return geboorteDatum;
    }

    public String getVoorletter() {
        return voorletter;
    }

    public void setGeboorteDatum(Date geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVoorletter(String voorletter) {
        this.voorletter = voorletter;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String toString() {
        return "Heer/mevrouw" + voorletter +"."+achternaam+ " geboren op" + geboorteDatum + " met als tusselvoegsel" +tussenvoegsel+ ". Id: " + id;

    }
}
