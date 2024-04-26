package Tabele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Milos PC
 */
public class Pacijent {

    private String jmbg;
    private String jmbg_doktor;
    private String ime;
    private String adresa;
    private int starost_pacijent;

    public Pacijent() {
    }

    public Pacijent(String jmbg, String jmbg_doktor, String ime, String adresa, int starost_pacijent) {
        this.jmbg = jmbg;
        this.jmbg_doktor = jmbg_doktor;
        this.ime = ime;
        this.adresa = adresa;
        this.starost_pacijent = starost_pacijent;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg_doktor() {
        return jmbg_doktor;
    }

    public void setJmbg_doktor(String jmbg_doktor) {
        this.jmbg_doktor = jmbg_doktor;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getStarost_pacijent() {
        return starost_pacijent;
    }

    public void setStarost_pacijent(int starost_pacijent) {
        this.starost_pacijent = starost_pacijent;
    }

    @Override
    public String toString() {
        return "Pacijent{" + "jmbg=" + jmbg + ", jmbg_doktor=" + jmbg_doktor + ", ime=" + ime + ", adresa=" + adresa + ", starost_pacijent=" + starost_pacijent + '}';
    }

}
