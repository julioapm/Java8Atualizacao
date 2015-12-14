package exemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

// Interface para filtrar uma pessoa
// (é denominada interface FUNCIONAL, pois possui apenas um método)
interface VerificaPessoa {
	boolean testar(Pessoa p);
}

public class App {

	// Abordagem 1: escrever um método que filtra a lista com base
	// em determinado critério
	public static void exibePessoasMaisIdosasQue(List<Pessoa> lista, int idade) {
		for (Pessoa p : lista) {
			if (p.getIdade() >= idade) {
				System.out.println(p);
			}
		}
	}

	// Abordagem 2: escrever métodos de busca mais genéricos
	public static void exibePessoasFaixaEtaria(List<Pessoa> lista, int min, int max) {
		for (Pessoa p : lista) {
			if (min <= p.getIdade() && p.getIdade() <= max) {
				System.out.println(p);
			}
		}
	}

	// Abordagem 3: especificar o critério de busca através de uma
	// interface e uma implementação dedicada (padrão Strategy!)
	public static void exibePessoas(List<Pessoa> lista, VerificaPessoa testador) {
		for (Pessoa p : lista) {
			if (testador.testar(p)) {
				System.out.println(p);
			}
		}
	}
	
	// Abordagem 6: usando a interface funcional Predicate<T> ao invés de VerificaPessoa
	public static void exibePessoasPredicate(List<Pessoa> lista, Predicate<Pessoa> testador) {
		for (Pessoa p : lista) {
			if (testador.test(p)) {
				System.out.println(p);
			}
		}
	}
	
	// Abordagem 7: usando uma interface funcional Consumer para realizar ações diferentes sobre objetos Pessoa
	public static void processaPessoas(List<Pessoa> lista, Predicate<Pessoa> testador,
			Consumer<Pessoa> consumidor) {
		for(Pessoa p: lista) {
			if(testador.test(p)) {
				consumidor.accept(p);
			}
		}
	}
	
	// Usando uma interface funcional Function para extrair parte da informação
	public static void processaPessoasFunction(List<Pessoa> lista, Predicate<Pessoa> testador,
			Function<Pessoa, String> mapeador, Consumer<String> consumidor) {
		for (Pessoa p : lista) {
	        if (testador.test(p)) {
	            String dados = mapeador.apply(p);
	            consumidor.accept(dados);
	        }
	    }
	}
	
	// Abordagem 8: criando um método genérico que faz a mesma coisa
	public static <X, Y> void processaElementos(Iterable<X> origem, Predicate<X> testador,
		    Function <X, Y> mapeador, Consumer<Y> consumidor) {
		    for (X p : origem) {
		        if (testador.test(p)) {
		            Y dados = mapeador.apply(p);
		            consumidor.accept(dados);
		        }
		    }
		}

	public static void main(String[] args) {
		List<Pessoa> lista = new ArrayList<>();
		lista.add(new Pessoa("Fred", LocalDate.of(1990, 6, 20), Pessoa.Genero.MASC, "fred@example.com"));
		lista.add(new Pessoa("Jane", LocalDate.of(1990, 7, 15), Pessoa.Genero.FEM, "jane@example.com"));
		lista.add(new Pessoa("George", LocalDate.of(1991, 8, 13), Pessoa.Genero.MASC, "george@example.com"));
		lista.add(new Pessoa("Bob", LocalDate.of(2000, 9, 12), Pessoa.Genero.MASC, "bob@example.com"));
		lista.add(new Pessoa("Lucy", LocalDate.of(2006, 10, 12), Pessoa.Genero.FEM, "lucy@example.com"));
		lista.add(new Pessoa("Carl", LocalDate.of(1970, 11, 9), Pessoa.Genero.MASC, "carl@example.com"));
		
		int op = 1;   // 1 a 9
		
		switch(op) {
		case 1:
	
		// Abordagem 1
		System.out.println("Pessoas com mais de 25 anos:");
		exibePessoasMaisIdosasQue(lista, 25);
		break;

		case 2:
		// Abordagem 2
		System.out.println();
		System.out.println("Pessoas com idade entre 15 e 25 anos:");
		exibePessoasFaixaEtaria(lista, 15, 25);
		break;

		case 3:
		// Abordagem 3
		System.out.println();
		System.out.println("Pessoas aptas para serviço militar (usando classe externa):");
		exibePessoas(lista, new PessoaAptaServicoMilitar());
		break;
		
		case 4:
		// Abordagem 4: igual à 3, mas usando uma classe interna anônima
		System.out.println();
		System.out.println("Pessoas aptas para serviço militar (usando classe interna):");
		exibePessoas(lista, new VerificaPessoa() {

			@Override
			public boolean testar(Pessoa p) {
				return p.getGenero() == Pessoa.Genero.MASC && p.getIdade() >= 18 && p.getIdade() <= 25;
			}			
		});
		break;
		
		case 5:
		// Abordagem 5: explorando o fato que a VerificaPessoa é uma interface funcional, podemos
		// substituir a classe interna por uma expressão lambda!
		System.out.println();
		System.out.println("Pessoas aptas para serviço militar (usando expressão lambda):");
		exibePessoas(lista, (Pessoa p) -> p.getGenero()==Pessoa.Genero.MASC
				                       && p.getIdade() >=18
				                       && p.getIdade()<=25);
		break;
		
		case 6:
		// Abordagem 6: usando a interface funcional Predicate<T> ao invés de VerificaPessoa
		System.out.println();
		System.out.println("Pessoas aptas para serviço militar (usando expressão lambda e interface Predicate):");
		exibePessoasPredicate(lista, (Pessoa p) -> p.getGenero()==Pessoa.Genero.MASC
				                       && p.getIdade() >=18
				                       && p.getIdade()<=25);
		break;
		
		case 7:
		// Abordagem 7: usando mais de uma interface funcional para realizar ações diferentes sobre objetos Pessoa
		System.out.println();
		System.out.println("Pessoas aptas para serviço militar (usando Predicate e Consumer):");
		processaPessoas(lista, p -> p.getGenero()==Pessoa.Genero.MASC
				                &&  p.getIdade() >= 18
				                &&  p.getIdade() <= 25, p -> System.out.println(p));
	
		System.out.println();
		System.out.println("Pessoas aptas para serviço militar (usando Predicate e Consumer como ref. método):");
		// ...ou usando referência de método
		processaPessoas(lista, p -> p.getGenero()==Pessoa.Genero.MASC
				                &&  p.getIdade() >= 18
				                &&  p.getIdade() <= 25, System.out::println);
	
		System.out.println();
		System.out.println("E-mail das pessoas aptas para serviço militar (usando Function):");
		// Usando Function para recuperar o email das pessoas aptas para serviço militar
		processaPessoasFunction(lista,
			    p -> p.getGenero() == Pessoa.Genero.MASC
			        && p.getIdade() >= 18
			        && p.getIdade() <= 25,
			    p -> p.getEmail(),
			    email -> System.out.println(email)
			);
		break;

		case 8:
		System.out.println();
		System.out.println("E-mail das pessoas aptas para serviço militar (usando genéricos):");
		// Abordagem 8: usando um método genérico que faz a mesma coisa
		processaElementos(lista,
			    p -> p.getGenero() == Pessoa.Genero.MASC
			        && p.getIdade() >= 18
			        && p.getIdade() <= 25,
			    p -> p.getEmail(),
			    email -> System.out.println(email)
			);
		break;
		
		case 9:
		System.out.println();
		System.out.println("E-mail das pessoas aptas para serviço militar (usando operações de agregação):");
		// Abordagem 9: usando operações de agregação que aceitam expressões lambda como parâmetros
		lista
			.stream()
			.filter(p -> p.getGenero() == Pessoa.Genero.MASC
			     	&&   p.getIdade() >= 18
			     	&&   p.getIdade() <= 25)
			.map(p -> p.getEmail())
			.forEach(email -> System.out.println(email));
		
		System.out.println();
		System.out.println("Lista geral usando forEach():");
		lista.stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Lista das mulheres usando filter() e forEach():");
		// Exemplo de pipeline: fonte de dados, sequência de operações intermediárias e uma operação terminal
		lista.stream().filter(p -> p.getGenero() == Pessoa.Genero.FEM).forEach(System.out::println);
		
		System.out.println();
		System.out.print("Média de idade dos homens usando filter(), map() e average(): ");
		// Mais um exemplo de pipeline
		System.out.print(
		lista
		    .stream()
		    .filter(p -> p.getGenero() == Pessoa.Genero.MASC)
		    .mapToInt(p -> p.getIdade())
		    .average()
		    .getAsDouble());
		break;
		
		} // switch
	}

}

class PessoaAptaServicoMilitar implements VerificaPessoa {
	public boolean testar(Pessoa p) {
		return p.getGenero() == Pessoa.Genero.MASC && p.getIdade() >= 18 && p.getIdade() <= 25;
	}
}