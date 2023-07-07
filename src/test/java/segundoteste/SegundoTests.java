package segundoteste;

import segundoteste.candidatos.Candidato;
import segundoteste.errors.CandidatoDuplicado;
import segundoteste.errors.CandidatoNaoEncontrado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SegundoTests {
    private Segundo segundo;

    @Test
    void contextLoads() {
    }

    @BeforeEach
    public void setup() {
        segundo = new Segundo();
    }

    @Test
    public void testIniciarProcesso() throws CandidatoDuplicado {
        int codCandidato = segundo.iniciarProcesso("John");
        assertNotNull(codCandidato);
        assertThrows(CandidatoDuplicado.class, () -> segundo.iniciarProcesso("John"));
    }
//
//    @Test
//    public void testMarcarEntrevista() throws CandidatoNaoEncontrado, CandidatoDuplicado {
//        int codCandidato = segundo.iniciarProcesso("John");
//        segundo.marcarEntrevista(codCandidato);
//        assertEquals("Qualificados", segundo.verificarStatusCandidato(codCandidato));
//        assertThrows(CandidatoNaoEncontrado.class, () -> segundo.marcarEntrevista(999));
//    }
//
//    @Test
//    public void testAprovarCandidato() throws CandidatoNaoEncontrado, CandidatoDuplicado {
//        int codCandidato = segundo.iniciarProcesso("John");
//        segundo.marcarEntrevista(codCandidato);
//        segundo.aprovarCandidato(codCandidato);
//        assertEquals("Aprovados", segundo.verificarStatusCandidato(codCandidato));
//    }
//
//    @Test
//    public void testDesqualificarCandidato() throws CandidatoNaoEncontrado, CandidatoDuplicado {
//        int codCandidato = segundo.iniciarProcesso("John");
//        segundo.marcarEntrevista(codCandidato);
//        segundo.desqualificarCandidato(codCandidato);
//        assertThrows(CandidatoNaoEncontrado.class, () -> segundo.verificarStatusCandidato(codCandidato));
//    }
//
//    @Test
//    public void testEncontrarCandidateEmFases() throws CandidatoDuplicado, CandidatoNaoEncontrado {
//        int codCandidato = segundo.iniciarProcesso("John");
//        Candidato candidato = segundo.encontrarCandidateEmFases(codCandidato);
//        assertNotNull(candidato);
//        assertEquals("John", candidato.getNome());
//        assertThrows(CandidatoNaoEncontrado.class, () -> segundo.encontrarCandidateEmFases(999));
//    }
//
//    @Test
//    public void testVerificarStatusCandidato() throws CandidatoDuplicado, CandidatoNaoEncontrado {
//        int codCandidato = segundo.iniciarProcesso("John");
//        assertEquals("Recebidos", segundo.verificarStatusCandidato(codCandidato));
//        assertThrows(CandidatoNaoEncontrado.class, () -> segundo.verificarStatusCandidato(999));
//    }
//
//    @Test
//    public void testObterAprovados() throws CandidatoDuplicado, CandidatoNaoEncontrado {
//        int codCandidato1 = segundo.iniciarProcesso("John");
//        int codCandidato2 = segundo.iniciarProcesso("Jane");
//        segundo.marcarEntrevista(codCandidato1);
//        segundo.marcarEntrevista(codCandidato2);
//        segundo.aprovarCandidato(codCandidato1);
//        segundo.aprovarCandidato(codCandidato2);
//        List<String> aprovados = segundo.obterAprovados();
//        assertEquals(2, aprovados.size());
//        assertTrue(aprovados.contains("John"));
//        assertTrue(aprovados.contains("Jane"));
//    }
}