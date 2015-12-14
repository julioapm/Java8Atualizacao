package exemplo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio
 */
public class Exemplo3 {

    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>();
        double maiorNota = estudantes.stream()
                .filter(e -> e.getAnoGraduacao() == 2015)
                .mapToDouble(Estudante::getNota)
                .max().getAsDouble();
    }
}
