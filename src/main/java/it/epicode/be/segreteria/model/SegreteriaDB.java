package it.epicode.be.segreteria.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SegreteriaDB {

	private Map<String, Studente> listaStudenti = new HashMap<String, Studente>();
	private Map<String, CorsoLaurea> listaCorsi = new HashMap<String, CorsoLaurea>();


	public boolean aggiungiStudente(Studente s) {
        if (!listaStudenti.containsValue(s)) {
            listaStudenti.put(s.getMatricola(), s);
        } else {
            return false;
        }

        return true;
    }

	public boolean aggiungiCorso(CorsoLaurea corso) {
        if (!listaCorsi.containsValue(corso)) {
            listaCorsi.put(corso.getCodiceCorso(), corso);
        } else {
            return false;
        }

        return true;
    }

	public boolean cancellaStudente(String matricolaS) {
        if (listaStudenti.containsKey(matricolaS)) {
            listaStudenti.remove(matricolaS);
        } else {
            return false;
        }

        return true;
    }

	public boolean cancellaCorso(String codiceCorso) {
        if (listaCorsi.containsKey(codiceCorso)) {
            listaCorsi.remove(codiceCorso);
        } else {
            return false;
        }

        return true;
    }

	public Collection<Studente> getAllStudenti(){
		return listaStudenti.values();
	}

	public Collection<CorsoLaurea> getAllCorsi(){
		return listaCorsi.values();
	}
}
