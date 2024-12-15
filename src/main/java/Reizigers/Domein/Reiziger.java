package Reizigers.Domein;

import jakarta.persistence.*;
import java.sql.Date;

    @Entity
    @Table(name="Reiziger")
    public class Reiziger {

        @Id
        @Column(name= "reiziger_id")
        private int id;

        @Column(name = "voorletters", nullable = false)
        private String voorletter;

        @Column(name = "tussenvoegsel", nullable = true)
        private String tussenvoegsel;

        @Column(name = "achternaam", nullable = false)
        private String achternaam;

        @Column(name = "geboortedatum")
        private Date geboorteDatum;


        public Reiziger(int id, String voorletter, String tussenvoegsel, String achternaam, Date geboorteDatum) {
            this.id = id;
            this.voorletter = voorletter;
            this.tussenvoegsel = tussenvoegsel;
            this.achternaam = achternaam;
            this.geboorteDatum = geboorteDatum;
        }

        public Reiziger() {}

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

        @Override
        public String toString() {
            return "Heer/mevrouw " + voorletter + "." + achternaam +
                    " geboren op " + geboorteDatum +
                    (tussenvoegsel != null ? " met als tussenvoegsel " + tussenvoegsel : "") +
                    ". Id: " + id;
        }

    }

