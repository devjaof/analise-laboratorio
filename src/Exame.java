enum RiscoColesterol {
  BAIXO,
  MEDIO,
  ALTO
}

public class Exame {
  public Paciente paciente;

  public Exame(Paciente paciente) {
    this.paciente = paciente;
  }

  public void classificarResultado() {
  }

  public void mostrarResultado() {
    System.out.println("Nome do paciente: " + paciente.getNome());
    System.out.println("Tipo sanguíneo: " + paciente.getTipoSanguineo());
    System.out.println("Idade: " + paciente.getIdade() + " anos");
  }
}

class ExameGlicemia extends Exame {
  private double quantidadeGlicose;

  public ExameGlicemia(Paciente paciente, double quantidadeGlicose) {
    super(paciente);
    this.quantidadeGlicose = quantidadeGlicose;
  }

  public void classificarResultado() {
    if (quantidadeGlicose < 100) {
      System.out.println("Resultado: Normoglicemia");
    } else if (quantidadeGlicose >= 100 && quantidadeGlicose < 126) {
      System.out.println("Resultado: Pré-diabetes");
    } else {
      System.out.println("Resultado: Diabetes estabelecido");
    }
  }

  @Override
  public void mostrarResultado() {
    System.out.println("Quantidade de glicose: " + quantidadeGlicose + " mg/dL");
    classificarResultado();
  }
}

class ExameColesterol extends Exame {
  private double quantidadeLDL;
  private double quantidadeHDL;
  private RiscoColesterol risco;

  public ExameColesterol(Paciente paciente, double quantidadeLDL, double quantidadeHDL, RiscoColesterol risco) {
    super(paciente);
    this.quantidadeLDL = quantidadeLDL;
    this.quantidadeHDL = quantidadeHDL;
    this.risco = risco;
  }

  @Override
  public void classificarResultado() {
    int idade = this.paciente.getIdade();

    boolean hdlBom = (idade <= 19 && this.quantidadeHDL >= 45) || (idade >= 20 && this.quantidadeHDL >= 40);
    boolean ldlBom = (this.risco == RiscoColesterol.BAIXO && this.quantidadeLDL < 100)
        || (this.risco == RiscoColesterol.MEDIO && this.quantidadeLDL < 70)
        || (this.risco == RiscoColesterol.ALTO && this.quantidadeLDL < 50);

    if (hdlBom) {
      System.out.println("Resultado: HDL - BOM");
    } else {
      System.out.println("Resultado: HDL - RUIM");
    }

    if (ldlBom) {
      System.out.println("Resultado: LDL - BOM");
    } else {
      System.out.println("Resultado: LDL - RUIM");
    }
  }

  @Override
  public void mostrarResultado() {
    System.out.println("Exame de Colesterol: ");
    System.out.println("Quantidade de HDL: " + quantidadeHDL);
    System.out.println("Quantidade de LDL: " + quantidadeLDL);
    System.out.println("Risco de Colesterol do paciente: " + risco);
    System.out.println("------------------------------------------");

    classificarResultado();
  }
}

class ExameTriglicerideos extends Exame {
  private double quantidadeTriglicerideos;

  public ExameTriglicerideos(Paciente paciente, double quantidadeTriglicerideos) {
    super(paciente);
    this.quantidadeTriglicerideos = quantidadeTriglicerideos;
  }

  @Override
  public void classificarResultado() {
    int idade = this.paciente.getIdade();

    boolean triglicerideosBom = (idade < 9 && quantidadeTriglicerideos < 75)
        || ((idade >= 10 && idade <= 19) && quantidadeTriglicerideos < 90)
        || (idade > 20 && quantidadeTriglicerideos < 150);

    if (triglicerideosBom) {
      System.out.println("Resultado: Triglicerídeos - BOM");
    } else {
      System.out.println("Resultado: Triglicerídeos - RUIM");
    }
  }

  @Override
  public void mostrarResultado() {
    System.out.println("Quantidade de triglicerídeos: " + quantidadeTriglicerideos);
    classificarResultado();
  }
}