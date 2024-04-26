package Tabele;

import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Milos PC
 */
public class Recept {

    private int id;
    private String jmbg_pacijent;
    private int sifra_lek;
    private String jmbg_doktor;
    private Date datum;
    private int kolicina_lekova;

    public Recept() {
    }

    public Recept(int id, String jmbg_pacijent, int sifra_lek, String jmbg_doktor, Date datum, int kolicina_lekova) {
        this.id = id;
        this.jmbg_pacijent = jmbg_pacijent;
        this.sifra_lek = sifra_lek;
        this.jmbg_doktor = jmbg_doktor;
        this.datum = datum;
        this.kolicina_lekova = kolicina_lekova;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJmbg_pacijent() {
        return jmbg_pacijent;
    }

    public void setJmbg_pacijent(String jmbg_pacijent) {
        this.jmbg_pacijent = jmbg_pacijent;
    }

    public int getSifra_lek() {
        return sifra_lek;
    }

    public void setSifra_lek(int sifra_lek) {
        this.sifra_lek = sifra_lek;
    }

    public String getJmbg_doktor() {
        return jmbg_doktor;
    }

    public void setJmbg_doktor(String jmbg_doktor) {
        this.jmbg_doktor = jmbg_doktor;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getKolicina_lekova() {
        return kolicina_lekova;
    }

    public void setKolicina_lekova(int kolicina_lekova) {
        this.kolicina_lekova = kolicina_lekova;
    }

    @Override
    public String toString() {
        return "Recept{" + "id=" + id + ", jmbg_pacijent=" + jmbg_pacijent + ", sifra_lek=" + sifra_lek + ", jmbg_doktor=" + jmbg_doktor + ", datum=" + datum + ", kolicina_lekova=" + kolicina_lekova + '}';
    }

}
