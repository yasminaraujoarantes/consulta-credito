package com.yasminarantes.consulta_credito.controller;

import com.yasminarantes.consulta_credito.dto.CreditoDTO;
import com.yasminarantes.consulta_credito.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService service;

    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoDTO>> obterCreditosPorNfse(@PathVariable String numeroNfse) {
        List<CreditoDTO> creditos = service.obterCreditosPorNfse(numeroNfse);
        return ResponseEntity.ok(creditos);
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoDTO> obterCreditoPorNumero(@PathVariable String numeroCredito) {
        CreditoDTO credito = service.obterCreditoPorNumero(numeroCredito);

        if (credito != null) {
            return ResponseEntity.ok(credito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
