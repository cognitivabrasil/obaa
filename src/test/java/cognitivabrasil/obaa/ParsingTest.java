/*
 * Classe de testes para melhoramento dos metadados dos usuários.
 */
package cognitivabrasil.obaa;

import cognitivabrasil.obaa.Educational.TypicalAgeRange;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 *
 * @author luiz
 */
public class ParsingTest {

    @Test    
    public void tipicalAgeRangeParseTest() {
        
        TypicalAgeRange tar = new TypicalAgeRange();

        tar.setTypicalAgeRange("18");
        assertThat(tar.getTypicalAgeRange(), equalTo("18-18"));

        tar.setTypicalAgeRange("24-");
        assertThat(tar.getTypicalAgeRange(), equalTo("24-100"));

        tar.setTypicalAgeRange("12+");
        assertThat(tar.getTypicalAgeRange(), equalTo("12-100"));

        tar.setTypicalAgeRange("8 - 14 anos");
        assertThat(tar.getTypicalAgeRange(), equalTo("8-14"));

        tar.setTypicalAgeRange("apenas adultos");
        assertThat(tar.getTypicalAgeRange(), equalTo("18-100"));

        tar.setTypicalAgeRange("pessoas acima de 23 anos");
        assertThat(tar.getTypicalAgeRange(), equalTo("23-100"));

        tar.setTypicalAgeRange("menores de 15");
        assertThat(tar.getTypicalAgeRange(), equalTo("0-15"));

        tar.setTypicalAgeRange("alunos do ensino médio");
        assertThat(tar.getTypicalAgeRange(), equalTo("15-18"));

        tar.setTypicalAgeRange("primeiro ano do ensino médio");
        assertThat(tar.getTypicalAgeRange(), equalTo("15-18"));

    }
    
    @Test
    public void tipicalAgeRangeParseFromFileTest() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("./src/test/resources/typicalAgeRanges.txt"));
        int count = 0;

        Map results = new HashMap<String, String>();
        try {
            String line = br.readLine();

            while (line != null) {
                TypicalAgeRange tar = new TypicalAgeRange();
                tar.setTypicalAgeRange(line);

                if (!tar.getTypicalAgeRange().matches("\\d+-\\d+")) {
                    count++;
                } else {
                    results.put(line, tar.getTypicalAgeRange());
                }

                line = br.readLine();

            }
            System.out.println("Total parsing errors: " + count);

            assertThat(results.get("18-U").toString(), equalTo("18-100"));
            assertThat(results.get("UNIVERSITÁRIO").toString(), equalTo("18-100"));
            assertThat(results.get("Inicial 17 anos").toString(), equalTo("17-100"));
            assertThat(results.get("Ensino médio").toString(), equalTo("15-18"));
            assertThat(results.get("1 ano ensino médio").toString(), equalTo("15-16"));
            assertThat(results.get("aluno do ensino médio").toString(), equalTo("15-18"));
            assertThat(results.get("18 - 50").toString(), equalTo("18-50"));
            assertThat(results.get("A partir de 14 anos.").toString(), equalTo("14-100"));
            assertThat(results.get("17-").toString(), equalTo("17-100"));
            assertThat(results.get("Diverso").toString(), equalTo("0-100"));
            assertThat(results.get("estudante universitário").toString(), equalTo("18-100"));
            assertThat(results.get("Variada. Compreende os alunos da graduacão.").toString(), equalTo("18-100"));
            assertThat(results.get("Educação Superior").toString(), equalTo("18-100"));
            assertThat(results.get("Ensino Fundamental").toString(), equalTo("6-15"));
            assertThat(results.get("Alfabetizado (mínimo)").toString(), equalTo("7-100"));
            assertThat(results.get("todas as idades").toString(), equalTo("0-100"));
            assertThat(results.get("a partir de 3 anos.").toString(), equalTo("3-100"));
            assertThat(results.get("Foi construído para a faixa etária de 4 a 7 anos, mas pode ser usado por pessoas de outras idades.").toString(), equalTo("4-7"));
            assertThat(results.get("15").toString(), equalTo("15-15"));
            assertThat(results.get("20-75 anos").toString(), equalTo("20-75"));
            assertThat(results.get("10 anos à 80 anos").toString(), equalTo("10-80"));
            assertThat(results.get(">13 anos").toString(), equalTo("13-100"));
            assertThat(results.get("Alunos de informática de cursos técnicos").toString(), equalTo("15-18"));
            assertThat(results.get("Independe de faixa etária").toString(), equalTo("0-100"));
            assertThat(results.get("20+").toString(), equalTo("20-100"));
            assertThat(results.get("9 - 10 anos").toString(), equalTo("9-10"));

            //erros conhecidos 'a', 'y' e 'sdfsf'
            assertThat(count, equalTo(3));

        } finally {
            br.close();
        }
    }

}
