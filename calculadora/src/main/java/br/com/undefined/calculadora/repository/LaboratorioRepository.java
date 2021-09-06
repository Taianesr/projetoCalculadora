package br.com.undefined.calculadora.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.undefined.calculadora.model.Laboratorio;

public interface LaboratorioRepository extends JpaRepository<Laboratorio, BigInteger> {

}
