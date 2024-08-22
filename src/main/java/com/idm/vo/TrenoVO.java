package com.idm.vo;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import com.idm.abstractClasses.AbstractVagone;
import com.idm.entity.Factory;
import com.idm.entity.Utente;
import com.idm.entity.Prenotazione;

public class TrenoVO {

    private Integer id;
    private Utente utente;
    private double prezzo;
    private double peso;
    private double lunghezza;
    private String sigla;
    private Factory compagnia;
    private double mediaVoti;
    private double capacitaMassima;
    private int numeroPosti;
    private List<AbstractVagone> vagoni;
    private Set<Prenotazione> prenotazioni = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Factory getCompagnia() {
        return compagnia;
    }

    public void setCompagnia(Factory compagnia) {
        this.compagnia = compagnia;
    }

    public double getMediaVoti() {
        return mediaVoti;
    }

    public void setMediaVoti(double mediaVoti) {
        this.mediaVoti = mediaVoti;
    }

    public double getCapacitaMassima() {
        return capacitaMassima;
    }

    public void setCapacitaMassima(double capacitaMassima) {
        this.capacitaMassima = capacitaMassima;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public List<AbstractVagone> getVagoni() {
        return vagoni;
    }

    public void setVagoni(List<AbstractVagone> vagoni) {
        this.vagoni = vagoni;
    }

    public Set<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "TrenoVO [id=" + id + ", compagnia=" + compagnia + ", vagoni=" + vagoni + "]";
    }
}
