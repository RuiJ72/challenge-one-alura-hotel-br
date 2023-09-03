package modelo;

import java.sql.Date;
import java.util.Objects;

public class Hospede {
    private int id;
    private String nome;
    private String sobrenome;
    private Date dataNascimento;
    private String nacionalidade;
    private String telefone;
    private int reservaId;

    public Hospede() {
    }

    public Hospede(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, int reservaId) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.telefone = telefone;
        this.reservaId = reservaId;
    }

    /**
     * Getters and Setters
     * @return
     */

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getSobrenome() {

        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {

        this.sobrenome = sobrenome;
    }

    public Date getDataNascimento() {

        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {

        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {

        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }

    public int getReservaId() {

        return reservaId;
    }

    public void setReservaId(int reservaId) {

        this.reservaId = reservaId;
    }

    @Override
    public String toString() {
        return "Hospede{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospede hospede = (Hospede) o;
        return id == hospede.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}

