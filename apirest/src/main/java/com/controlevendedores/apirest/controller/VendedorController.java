package com.controlevendedores.apirest.controller;

import com.controlevendedores.apirest.domain.Vendedor;
import com.controlevendedores.apirest.dto.VendedorDTO;
import com.controlevendedores.apirest.exception.RegistroNaoEncontradoException;
import com.controlevendedores.apirest.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    private final  VendedorService vendedorService;

    @Autowired
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody VendedorDTO dto){
        vendedorService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity listar(){
        List<VendedorDTO> vendedores = vendedorService.listaVendedores();
        return ResponseEntity.ok(vendedores);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity buscaVendedor(@PathVariable("id") Long id){
        VendedorDTO vendedorDTO = vendedorService.buscaVendedorById(id);
        return ResponseEntity.ok(vendedorDTO);

    }
}
