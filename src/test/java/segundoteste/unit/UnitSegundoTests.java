package segundoteste.unit;

import org.junit.jupiter.api.Nested;
import segundoteste.Segundo;
import segundoteste.candidatos.Candidato;
import segundoteste.errors.CandidatoDuplicado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import segundoteste.errors.CandidatoNaoEncontrado;
import segundoteste.errors.NomeInvalido;

import static org.junit.jupiter.api.Assertions.*;

class UnitSegundoTests {
    @Test
    void contextLoads() {
    }

    @Nested
    class testIniciarProcesso {
        @Test
        public void succesfullyCreates() {
            Segundo segundo = new Segundo();
            int codCandidato = segundo.iniciarProcesso("John");

            Candidato candidato = segundo.encontrarCandidateEmFases(codCandidato);
            assertEquals(candidato.getFaseAtual(), "Recebidos");
        }

        @Test
        public void throwsErrorOnRepeatedCandidate() throws CandidatoDuplicado {
            Segundo segundo = new Segundo();
            int codCandidato = segundo.iniciarProcesso("John");

            assertNotNull(codCandidato);
            assertThrows(CandidatoDuplicado.class, () -> segundo.iniciarProcesso("John"));
        }

        @Test
        public void throwsErrorOnEmptyCandidateName() {
            Segundo segundo = new Segundo();
            assertThrows(NomeInvalido.class, () -> segundo.iniciarProcesso(""));
        }

        @Test
        public void throwsErrorOnCandidateNameWithInvalidCharacters() {
            Segundo segundo = new Segundo();
            assertThrows(NomeInvalido.class, () -> segundo.iniciarProcesso("John@123"));
        }

        @Test
        public void throwsErrorOnCandidateNameExceedingMaxLength() {
            Segundo segundo = new Segundo();
            assertThrows(NomeInvalido.class, () -> segundo.iniciarProcesso(
                    "JohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohnJohn"
            ));
        }
    }

    @Nested
    class testMarcarEntrevista {
        @Test
        public void successfullyMovesCandidate() throws CandidatoDuplicado, NomeInvalido, CandidatoNaoEncontrado {
            Segundo segundo = new Segundo();
            int codCandidato = segundo.iniciarProcesso("John");

            Candidato candidato = segundo.encontrarCandidateEmFases(codCandidato);
            assertEquals(candidato.getFaseAtual(), "Recebidos");

            segundo.marcarEntrevista(codCandidato);
            Candidato candidatoEntrevista = segundo.encontrarCandidateEmFases(codCandidato);
            assertEquals("Qualificados", candidatoEntrevista.getFaseAtual());
        }

        @Test
        public void throwsErrorOnNonExistentCandidate() {
            Segundo segundo = new Segundo();
            assertThrows(CandidatoNaoEncontrado.class, () -> segundo.marcarEntrevista(999));
        }
    }


    @Nested
    class testAprovarCandidato {
        @Test
        public void successfullyMovesCandidate() throws CandidatoDuplicado, NomeInvalido, CandidatoNaoEncontrado {
            Segundo segundo = new Segundo();
            int codCandidato = segundo.iniciarProcesso("John");

            Candidato candidato = segundo.encontrarCandidateEmFases(codCandidato);
            assertEquals(candidato.getFaseAtual(), "Recebidos");

            segundo.marcarEntrevista(codCandidato);
            Candidato candidatoEntrevista = segundo.encontrarCandidateEmFases(codCandidato);
            assertEquals(candidatoEntrevista.getFaseAtual(), "Qualificados");

            segundo.aprovarCandidato(codCandidato);
            Candidato candidatoAprovado = segundo.encontrarCandidateEmFases(codCandidato);
            assertEquals(candidatoAprovado.getFaseAtual(), "Aprovados");
        }

        @Test
        public void throwsErrorOnNonExistentCandidate() {
            Segundo segundo = new Segundo();
            assertThrows(CandidatoNaoEncontrado.class, () -> segundo.aprovarCandidato(999));
        }
    }


//    @Test
//    public void testMarcarEntrevista() throws CandidatoNaoEncontrado, CandidatoDuplicado {
//        Segundo segundo = new Segundo();
//
//        int codCandidato = segundo.iniciarProcesso("John");
//
//        segundo.marcarEntrevista(codCandidato);
//
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
