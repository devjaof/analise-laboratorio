import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        String[] options = { "Glicemia", "Colesterol", "Trglicerídeos" };

        String nome = JOptionPane.showInputDialog("Digite o nome do paciente");
        String tipoSanquineo = JOptionPane.showInputDialog("Digite o tipo sanguineo");
        int anoNascimento = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento"));

        Paciente paciente = new Paciente(nome, tipoSanquineo, anoNascimento);

        int indexEscolhido = JOptionPane.showOptionDialog(
                null,
                "Escolha um tipo de exame",
                "Tipo de exame",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (indexEscolhido == 0) {
            int quantidadeGlicose = Integer.parseInt(JOptionPane.showInputDialog("Nível de clicose do paciente"));

            ExameGlicemia exameGlicemia = new ExameGlicemia(paciente, quantidadeGlicose);
            exameGlicemia.mostrarResultado();
        }

        if (indexEscolhido == 1) {
            String[] opcoesRiscoColesterol = { "Baixo", "Médio", "Alto" };

            int quantidadeLDL = Integer.parseInt(JOptionPane.showInputDialog("Nível de LDL do paciente"));
            int quantidadeHDL = Integer.parseInt(JOptionPane.showInputDialog("Nível de HDL do paciente"));

            int riscoIndex = JOptionPane.showOptionDialog(
                    null,
                    "Risco de colesterol do paciente",
                    "Risco do Paciente",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoesRiscoColesterol,
                    opcoesRiscoColesterol[0]);

            RiscoColesterol risco = RiscoColesterol.BAIXO;

            switch (riscoIndex) {
                case 0:
                    break;
                case 1:
                    risco = RiscoColesterol.MEDIO;
                    break;
                case 2:
                    risco = RiscoColesterol.ALTO;
                    break;
                default:
                    break;
            }

            ExameColesterol exameColesterol = new ExameColesterol(paciente, quantidadeLDL, quantidadeHDL, risco);
            exameColesterol.mostrarResultado();
        }

        if (indexEscolhido == 2) {
            int quantidadeTriglicerideos = Integer
                    .parseInt(JOptionPane.showInputDialog("Nível de triglicerideos do paciente"));

            ExameTriglicerideos exameTriglicerideos = new ExameTriglicerideos(paciente, quantidadeTriglicerideos);
            exameTriglicerideos.mostrarResultado();
        }
    }
}
