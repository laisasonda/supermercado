/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Laisa
 */
public class Supermercado {
    private Integer codigo;
    private String nomefantasia;
    private String razaosocial;
    private LocalDate fundacao;
    private Integer nrfuncionarios;
    private Double valorbolsa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getRazaosocial() {
        return razaosocial;
    }

    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    public LocalDate getFundacao() {
        return fundacao;
    }

    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao;
    }

    public Integer getNrfuncionarios() {
        return nrfuncionarios;
    }

    public void setNrfuncionarios(Integer nrfuncionarios) {
        this.nrfuncionarios = nrfuncionarios;
    }

    public Double getValorbolsa() {
        return valorbolsa;
    }

    public void setValorbolsa(Double valorbolsa) {
        this.valorbolsa = valorbolsa;
    }

   

    @Override
    public String toString() {
        return "Supermercado{" + "nomefantasia=" + nomefantasia + '}';
    }
    
    
    
}
