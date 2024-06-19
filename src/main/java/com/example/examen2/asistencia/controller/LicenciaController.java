package com.example.examen2.asistencia.controller;

import com.example.examen2.asistencia.model.LicenciaDTO;
import com.example.examen2.asistencia.service.LicenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licencias/")
public class LicenciaController {

    @Autowired
    private LicenciaService licenciaService;

    @GetMapping
    public List<LicenciaDTO> getAllLicencias() {
        return licenciaService.findAll();
    }

    @GetMapping("/{id}")
    public LicenciaDTO getLicenciaById(@PathVariable Long id) {
        return licenciaService.findById(id);
    }

    @PostMapping("/createOrUpdate")
    public LicenciaDTO createOrUpdateLicencia(@RequestPart("licencia") LicenciaDTO licenciaDTO) {
        return licenciaService.createOrUpdateLicencia(licenciaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLicencia(@PathVariable Long id) {
        licenciaService.deleteLicencia(id);
    }
}
