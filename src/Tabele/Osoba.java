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
public abstract class Osoba {

    private String jmbg;
    private String ime;
    private String prezime;
    private String adresa;

    public Osoba(String jmbg, String ime, String prezime, String adresa) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
    }

    public Osoba() {
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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "Osoba{" + "jmbg=" + jmbg + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + '}';
    }

}
