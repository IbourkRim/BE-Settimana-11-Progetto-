package it.epicode.be.segreteria.util;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.segreteria.model.CorsoLaurea;
import it.epicode.be.segreteria.model.SegreteriaDB;
import it.epicode.be.segreteria.model.Studente;

@Component
public class SegreteriaDBLoader implements CommandLineRunner{

	@Autowired
	ApplicationContext ctx;
	
	
	@Override
	public void run(String... args) throws Exception {
		SegreteriaDB segreteriadb = ctx.getBean(SegreteriaDB.class);
		valorizzaDb(segreteriadb);
		
	}

	
	public void valorizzaDb(SegreteriaDB segreteriadb) {
		
		CorsoLaurea c1 = CorsoLaurea.builder().codiceCorso("364NMU").nome("scienze").indirizzo("scienze umane").numeroEsami(20).build();
		CorsoLaurea c2 = CorsoLaurea.builder().codiceCorso("658TPE").nome("chimica").indirizzo("chimica e biotecnologie sanitarie").numeroEsami(15).build();
		CorsoLaurea c3 = CorsoLaurea.builder().codiceCorso("546GHC").nome("arte").indirizzo("arte moderna").numeroEsami(25).build();

		Studente s1 = Studente.builder().matricola("BBCC1").nome("Lady").cognome("Gaga").dataNascita(LocalDate.parse("2000-01-25")).email("gaga@gmail.com").indirizzo("Via Casilina, 11").citta("Milano").corsoLaurea(c1).build();
		Studente s2 = Studente.builder().matricola("BBCC2").nome("Brad").cognome("Pitt").dataNascita(LocalDate.parse("2001-07-30")).email("pitt@gmail.com").indirizzo("Via Appia,15").citta("Bergamo").corsoLaurea(c2).build();
		Studente s3 = Studente.builder().matricola("BBCC3").nome("Leonardo").cognome("DiCaprio").dataNascita(LocalDate.parse("2003-09-19")).email("leo@gmail.com").indirizzo("Via Terracina, 20").citta("Venezia").corsoLaurea(c3).build();

		segreteriadb.aggiungiStudente(s1);
		segreteriadb.aggiungiStudente(s2);
		segreteriadb.aggiungiStudente(s3);
		segreteriadb.aggiungiCorso(c1);
		segreteriadb.aggiungiCorso(c2);
		segreteriadb.aggiungiCorso(c3);
		

	}


}
