package com.example.RegistraduriaFinal.Servicio;

import com.example.RegistraduriaFinal.Dto.PersonaDto;
import com.example.RegistraduriaFinal.Entidad.Persona;
import com.example.RegistraduriaFinal.Repositorio.RegistroRepositorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;
import java.util.Scanner;


//@Data
//@AllArgsConstructor
@Service
public class RegistroService implements Serializable {
    private ModelMapper modelMapper;
    @Autowired
    RegistroRepositorio registroRepositorio;

    public void registrarPersona(PersonaDto personaDto) {
        registroRepositorio.save(modelMapper.map(personaDto, Persona.class));
    }
    public List<PersonaDto> obtenerPersona() {
        TypeToken<List<PersonaDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(registroRepositorio.findAll(), typeToken.getType());

    }
}



