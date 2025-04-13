package com.yasminarantes.consulta_credito.controller;

import com.yasminarantes.consulta_credito.dto.CreditoDTO;
import com.yasminarantes.consulta_credito.service.CreditoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditos")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Créditos", description = "Operações relacionadas a créditos")
public class CreditoController {

    @Autowired
    private CreditoService service;

    @Operation(
            summary = "Obtém todos os créditos associados a um número de NFS-e",
            description = "Esse endpoint retorna uma lista de créditos baseados no número da NFS-e",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de créditos obtida com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreditoDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Número da NFS-e inválido ou nulo"),
                    @ApiResponse(responseCode = "404", description = "Nenhum crédito encontrado para a NFS-e fornecida")
            }
    )
    @GetMapping("/{numeroNfse}")
    public ResponseEntity<List<CreditoDTO>> obterCreditosPorNfse(@PathVariable String numeroNfse) {
        List<CreditoDTO> creditos = service.obterCreditosPorNfse(numeroNfse);
        return ResponseEntity.ok(creditos);
    }

    @Operation(
            summary = "Obtém um crédito pelo número do crédito",
            description = "Esse endpoint retorna os detalhes de um crédito específico baseado no número do crédito fornecido",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Crédito encontrado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreditoDTO.class))
                    ),
                    @ApiResponse(responseCode = "400", description = "Número do crédito inválido ou nulo"),
                    @ApiResponse(responseCode = "404", description = "Crédito não encontrado")
            }
    )
    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<CreditoDTO> obterCreditoPorNumero(@PathVariable String numeroCredito) {
        CreditoDTO credito = service.obterCreditoPorNumero(numeroCredito);
        return ResponseEntity.ok(credito);
    }
}
