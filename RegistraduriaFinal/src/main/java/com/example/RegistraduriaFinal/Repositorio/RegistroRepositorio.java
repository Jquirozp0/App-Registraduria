package com.example.RegistraduriaFinal.Repositorio;
import com.example.RegistraduriaFinal.Entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RegistroRepositorio extends JpaRepository<Persona, Long>,JpaSpecificationExecutor<Persona>{
}
