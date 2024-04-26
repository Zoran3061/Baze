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
public class Farmaceut extends Osoba {

    private String strucnaSprema;

    public Farmaceut(String jmbg, String ime, String prezime, String adresa, String strucnaSprema) {
        super(jmbg, ime, prezime, adresa);
        this.strucnaSprema = strucnaSprema;
    }

    public Farmaceut() {

    }

    public String getStrucnaSprema() {
        return strucnaSprema;
    }

    public void setStrucnaSprema(String strucnaSprema) {
        this.strucnaSprema = strucnaSprema;
    }

    @Override
    public String toString() {
        return "Farmaceut{" + "jmbg=" + super.getJmbg() + ", ime=" + super.getIme() + ", prezime=" + super.getPrezime() + ", adresa=" + super.getAdresa() + ",strucna sprema=" + strucnaSprema + '}';
    }

}
