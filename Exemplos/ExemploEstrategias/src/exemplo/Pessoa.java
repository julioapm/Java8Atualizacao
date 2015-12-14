package exemplo;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;

public class Pessoa {

	public enum Genero {
		MASC, FEM
	}
	
	private String nome;
	private LocalDate aniversario;
	private Genero genero;
	private String email;
	
	public Pessoa(String nome, LocalDate aniversario, Genero genero,
			String email) {
		this.nome = nome;
		this.aniversario = aniversario;
		this.genero = genero;
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LocalDate getAniversario() {
		return aniversario;
	}
	
	public int getIdade() {
        return aniversario
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }
	
	public Genero getGenero() {
		return genero;
	}
	
	public String getEmail() {
		return email;
	}
	
	public static int comparaPorIdade(Pessoa a, Pessoa b) {
        return a.aniversario.compareTo(b.aniversario);
    }
	
	@Override
	public String toString() {
		return nome+" ("+genero+") "+
				aniversario+" ["+getIdade()+" anos] - "+email;
	}
}
