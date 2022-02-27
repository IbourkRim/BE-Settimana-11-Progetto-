package it.epicode.be.segreteria.model;



import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Studente {


	private String matricola;
	private String nome;
	private String cognome;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	private String email;
	private String indirizzo;
	private String citta;
	private CorsoLaurea corsoLaurea;
}
