package exemplo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

/**
 *
 * @author Julio
 */
public class Exemplo2 {

    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>();
        double maiorNota
                = estudantes.stream().filter(new Predicate<Estudante>() {
                    @Override
                    public boolean test(Estudante estudante) {
                        return estudante.getAnoGraduacao() == 2015;
                    }
                }).mapToDouble(new ToDoubleFunction<Estudante>() {
                    @Override
                    public double applyAsDouble(Estudante estudante) {
                        return estudante.getNota();
                    }
                }).max().getAsDouble();
    }
}
