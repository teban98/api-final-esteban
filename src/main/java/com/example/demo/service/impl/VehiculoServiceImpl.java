package com.example.demo.service.impl;

import com.example.demo.entity.Vehiculo;
import com.example.demo.exeption.NoexisteEsxception;
import com.example.demo.repository.VehiculoRepository;
import com.example.demo.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;
    private static final String VEHICULO_NO_EXISTE="El vehículo consultado no existe.";
    @Override
    public Vehiculo findByID(String placa) {
        Vehiculo vehiculo = vehiculoRepository.findById(placa).orElse(null);
        vehiculoExiste(vehiculo);
        return vehiculo;
    }

    private void vehiculoExiste(Vehiculo vehiculo) {
    if (vehiculo==null){
        throw  new NoexisteEsxception(VEHICULO_NO_EXISTE);
    }
    }

    @Override
    public void insert(Vehiculo vehiculo) {

        vehiculoRepository.save(vehiculo);

    }

    @Override
    public void update(Vehiculo vehiculo, String placa) {

        Vehiculo  vehiculoConsultado =findByID(placa);
        vehiculoConsultado.setColor(vehiculo.getColor());
        vehiculoConsultado.setMarca(vehiculo.getMarca());
        vehiculoConsultado.setModelo(vehiculo.getModelo());
        vehiculoRepository.save(vehiculoConsultado);
    }

    @Override
    public void delete(String placa) {
        Vehiculo vehiculo = findByID(placa);
        vehiculoRepository.delete(vehiculo);

    }

    @Override
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }
}