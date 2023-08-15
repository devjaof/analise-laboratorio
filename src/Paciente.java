import java.time.LocalDate;
import java.time.Period;

public class Paciente {
  private String nome;
  private String tipoSanguineo;
  private int anoNascimento;

  public Paciente(String nome, String tipoSanguineo, int anoNascimento) {
    this.nome = nome;
    this.tipoSanguineo = tipoSanguineo;
    this.anoNascimento = anoNascimento;
  }

  public int getIdade() {
    LocalDate dataAtual = LocalDate.now();
    LocalDate dataNascimento = LocalDate.of(anoNascimento, 1, 1);
    Period periodo = Period.between(dataNascimento, dataAtual);
    return periodo.getYears();
  }

  public String getNome() {
    return this.nome;
  }

  public String getTipoSanguineo() {
    return this.tipoSanguineo;
  }
}
