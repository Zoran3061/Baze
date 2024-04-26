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
public class Apoteka {

    private int id;
    private String ime;
    private String adresa;
    private String br_telefona;

    public Apoteka() {
    }

    public Apoteka(int id, String ime, String adresa, String br_telefona) {
        this.id = id;
        this.ime = ime;
        this.adresa = adresa;
        this.br_telefona = br_telefona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBr_telefona() {
        return br_telefona;
    }

    public void setBr_telefona(String br_telefona) {
        this.br_telefona = br_telefona;
    }

    @Override
    public String toString() {
        return "Apoteka{" + "id=" + id + ", ime=" + ime + ", adresa=" + adresa + ", br_telefona=" + br_telefona + '}';
    }

}
