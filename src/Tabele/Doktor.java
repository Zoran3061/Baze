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
public class Doktor {

    private String jmbg;
    private String ime;
    private String adresa;
    private int starost;

    public Doktor() {
    }

    public Doktor(String jmbg, String ime, String adresa, int starost) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.adresa = adresa;
        this.starost = starost;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    @Override
    public String toString() {
        return "Doktor{" + "jmbg=" + jmbg + ", ime=" + ime + ", adresa=" + adresa + ", starost=" + starost + '}';
    }

}
