import org.example.Aluno;
import org.example.Bolsa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {

    @Test
    public void deveNotificarUmAluno() {
        Bolsa bolsa = new Bolsa("Graduação", 1000.0F, 1);
        Aluno aluno = new Aluno("João");
        aluno.candidatar(bolsa);
        bolsa.lançarResultado();
        assertEquals("João, candidatura atualizada para: Bolsa{curso='Graduação', valor=1000.0, quantidade=1}", aluno.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarAlunos() {
        Bolsa bolsa = new Bolsa("Pós-Graduação", 1500.0F, 2);
        Aluno aluno1 = new Aluno("Pedro");
        Aluno aluno2 = new Aluno("Maria");
        aluno1.candidatar(bolsa);
        aluno2.candidatar(bolsa);
        bolsa.lançarResultado();
        assertEquals("Pedro, candidatura atualizada para: Bolsa{curso='Pós-Graduação', valor=1500.0, quantidade=2}", aluno1.getUltimaNotificacao());
        assertEquals("Maria, candidatura atualizada para: Bolsa{curso='Pós-Graduação', valor=1500.0, quantidade=2}", aluno2.getUltimaNotificacao());
    }

    @Test
    public void nãoDeveNotificarUmAluno() {
        Bolsa bolsa = new Bolsa("Graduação", 1000.0F, 1);
        Aluno aluno = new Aluno("João");
        bolsa.lançarResultado();
        assertNull(aluno.getUltimaNotificação());
    }

    @Test
    public void deveNotificarAlunosGraduação() {
        Bolsa bolsa1 = new Bolsa("Graduação", 1000.0F, 1);
        Bolsa bolsa2 = new Bolsa("Pós-Graduação", 1500.0F, 2);
        Aluno aluno1 = new Aluno("João");
        Aluno aluno2 = new Aluno("Pedro");
        aluno1.candidatar(bolsa1);
        aluno2.candidatar(bolsa2);
        bolsa1.lançarResultado();
        assertEquals("João, candidatura atualizada para: Bolsa{curso='Graduação', valor=1000.0, quantidade=1}", aluno1.getUltimaNotificacao());
        assertNull(aluno2.getUltimaNotificação());
    }
}
