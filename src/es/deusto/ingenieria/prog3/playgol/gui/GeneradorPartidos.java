package es.deusto.ingenieria.prog3.playgol.gui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GeneradorPartidos {
	
	public static List<String[]> generar(List<String> equipos) {
		
		List<String[]> partidos = new ArrayList<>();
		
		if (equipos == null || equipos.size() < 2) {
			return partidos;
		}
		
		List<String> lista = new ArrayList<>(equipos);
		
		//mezclar equipos
		Collections.shuffle(lista);
		
		//generar partidos sin repetir
		for (int i = 0; i < lista.size(); i++) {
			
			for (int j = i + 1; j < lista.size(); j++) {
				
				String local = lista.get(i);
				String visitante = lista.get(j);
				
				partidos.add(new String[] {
						local, 
						visitante
				});
			}
		}
		return partidos;
	}

}
