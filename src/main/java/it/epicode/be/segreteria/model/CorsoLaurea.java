package it.epicode.be.segreteria.model;




import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorsoLaurea {

	private String codiceCorso;
	private String nome;
	private String indirizzo;
	
	@Size(min = 10)
	private int numeroEsami;
}
