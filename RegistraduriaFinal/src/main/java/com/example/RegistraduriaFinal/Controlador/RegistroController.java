package com.example.RegistraduriaFinal.Controlador;
import com.example.RegistraduriaFinal.Dto.PersonaDto;
import com.example.RegistraduriaFinal.Entidad.Persona;
import com.example.RegistraduriaFinal.Servicio.RegistroService;
import com.example.RegistraduriaFinal.Utilidad.ArchivoUtilidad;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Log4j2
public class RegistroController {
  //  private RegistroService registroService;
  //  private ArchivoUtilidad archivoUtilidad;
    private static final Logger logger = LogManager.getLogger(RegistroController.class);
    @Autowired
    RegistroService reService;

    public void registrarPersona(PersonaDto personaDto) {
        reService.registrarPersona(personaDto);
    }

    public List<PersonaDto> obtenerPersona(){
        logger.info("Verificando ");
        return reService.obtenerPersona();
    }
}
