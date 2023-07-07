package segundoteste.candidatos;

import segundoteste.fases.EnumFase;

public abstract class AbsCandidato {
    private String faseAtual;
    private int codCandidato;
    private String nome;

    public String getFaseAtual() {
        return faseAtual;
    }

    public void setFaseAtual(String faseAtual) {
        this.faseAtual = faseAtual;
    }

    public int getCodCandidato() {
        return codCandidato;
    }

    public void setCodCandidato(int codCandidato) {
        this.codCandidato = codCandidato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}