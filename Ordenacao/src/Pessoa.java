import java.util.Date;

public class Pessoa {

    private final long cpf;
    private Date dataNascimento;
    private String nome;

    public Pessoa(String nome, Date dataNascimento, long cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public long getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("%s (CPF: %d)", this.nome, this.cpf);
    }
}
