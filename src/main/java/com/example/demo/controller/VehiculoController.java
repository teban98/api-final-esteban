package com.example.demo.controller;

import com.example.demo.entity.Vehiculo;
import com.example.demo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/control-vehiculo")

public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping ("/{placa}/vehiculo")
    public Vehiculo findByID(@PathVariable String placa){
        return vehiculoService.findByID(placa);
    }

    @PostMapping("/vehiculo")
    public void insertar(@RequestBody Vehiculo vehiculo){
        vehiculoService.insert(vehiculo);
    }

    @PutMapping("/{placa}/vehiculo")
    public void actualizar(@RequestBody Vehiculo vehiculo,@PathVariable String placa){
        vehiculoService.update(vehiculo,placa);
    }

    @DeleteMapping("/{placa}/vehiculo")
    public void eliminar(@PathVariable String placa){

        vehiculoService.delete(placa);
    }
    @GetMapping("/vehiculos")
    public List<Vehiculo> listar(){
        return vehiculoService.findAll();
    }
}
