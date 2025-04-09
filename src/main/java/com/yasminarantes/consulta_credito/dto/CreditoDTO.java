package com.yasminarantes.consulta_credito.dto;

import com.yasminarantes.consulta_credito.model.Credito;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditoDTO {
    private String numeroCredito;
    private String numeroNfse;
    private LocalDate dataConstituicao;
    private BigDecimal valorIssqn;
    private String tipoCredito;
    private String simplesNacional;
    private BigDecimal aliquota;
    private BigDecimal valorFaturado;
    private BigDecimal valorDeducao;
    private BigDecimal baseCalculo;

    public CreditoDTO(Credito credito){
        this.numeroCredito = credito.getNumeroCredito();
        this.numeroNfse = credito.getNumeroNfse();
        this.dataConstituicao = credito.getDataConstituicao();
        this.valorIssqn = credito.getValorIssqn();
        this.tipoCredito = credito.getTipoCredito();
        this.simplesNacional = credito.isSimplesNacional() ? "Sim":"Não";
        this.aliquota = credito.getAliquota();
        this.valorFaturado = credito.getValorFaturado();
        this.valorDeducao = credito.getValorDeducao();
        this.baseCalculo = credito.getBaseCalculo();
    }
}
