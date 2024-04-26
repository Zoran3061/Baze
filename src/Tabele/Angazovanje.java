package Tabele;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Filip
 */
public class Angazovanje {

    private int id;
    private int apoteka_id;
    private String jmbg_farmaceut;
    private int broj_meseci;
    private int broj_dana;

    public Angazovanje() {
    }

    public Angazovanje(int id, int apoteka_id, String jmbg_farmaceut, int broj_meseci, int broj_dana) {
        this.id = id;
        this.apoteka_id = apoteka_id;
        this.jmbg_farmaceut = jmbg_farmaceut;
        this.broj_meseci = broj_meseci;
        this.broj_dana = broj_dana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApoteka_id() {
        return apoteka_id;
    }

    public void setApoteka_id(int apoteka_id) {
        this.apoteka_id = apoteka_id;
    }

    public String getJmbg_farmaceut() {
        return jmbg_farmaceut;
    }

    public void setJmbg_farmaceut(String jmbg_farmaceut) {
        this.jmbg_farmaceut = jmbg_farmaceut;
    }

    public int getBroj_meseci() {
        return broj_meseci;
    }

    public void setBroj_meseci(int broj_meseci) {
        this.broj_meseci = broj_meseci;
    }

    public int getBroj_dana() {
        return broj_dana;
    }

    public void setBroj_dana(int broj_dana) {
        this.broj_dana = broj_dana;
    }

    @Override
    public String toString() {
        return "Angazovanje{" + "id=" + id + ", apoteka_id=" + apoteka_id + ", jmbg_farmaceut=" + jmbg_farmaceut + ", broj_meseci=" + broj_meseci + ", broj_dana=" + broj_dana + '}';
    }

}
