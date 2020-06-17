package com.example.demo.service;

import com.example.demo.entity.Vehiculo;

import java.util.List;

public interface VehiculoService {


    Vehiculo findByID(String placa);

    void insert(Vehiculo vehiculo);

    void update(Vehiculo vehiculo, String placa);

    void delete(String placa);

    List<Vehiculo> findAll();
}
