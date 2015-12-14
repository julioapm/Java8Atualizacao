package exemplo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Julio
 */
public class Exemplo {
    public static void main(String[] args) {
        List<Estudante> estudantes = new ArrayList<>();
        double maiorNota = 0.0;
        for (Estudante estudante : estudantes) {
            if (estudante.getAnoGraduacao() == 2015) {
                if (estudante.getNota() > maiorNota) {
                    maiorNota = estudante.getNota();
                }
            }
        }
    }
}
