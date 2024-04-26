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
public class Dobavljac {

    private int id;
    private String ime;
    private String br_telefona;

    public Dobavljac() {
    }

    public Dobavljac(int id, String ime, String br_telefona) {
        this.id = id;
        this.ime = ime;
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

    public String getBr_telefona() {
        return br_telefona;
    }

    public void setBr_telefona(String br_telefona) {
        this.br_telefona = br_telefona;
    }

    @Override
    public String toString() {
        return "Dobavljac{" + "id=" + id + ", ime=" + ime + ", br_telefona=" + br_telefona + '}';
    }

}
