import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ConsultaAgendada {
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private static int quantidade = 0;
    private String nomeMedico;

    // Construtor sem parâmetros, com entrada de dados via Scanner
    public ConsultaAgendada() {
        
        Scanner sc = new Scanner(System.in);
        this.data = new Data();
        this.hora = new Hora();
        
       this.nomePaciente= getNomePaciente();
        
        System.out.println("Escolha o médico:");
        this.nomeMedico = getNomeMedico();

        /*String[] medicos = {"Dr. João", "Dra. Maria", "Dr. Carlos", "Dra. Ana"};
        for (int i = 0; i < medicos.length; i++) {
            System.out.println((i + 1) + ". " + medicos[i]);
        }
        
        System.out.print("Digite o número do médico: ");
        int escolha = sc.nextInt();
        sc.nextLine();  // Limpa o buffer após nextInt()

        if (escolha > 0 && escolha <= medicos.length) {
            this.nomeMedico = medicos[escolha - 1];
        } else {
            System.out.println("Escolha inválida. Médico padrão selecionado.");
            this.nomeMedico = medicos[0];
        } */

        quantidade++;
    }

    // Construtor com parâmetros individuais
    public ConsultaAgendada(int h, int mi, int s, int d, int mes, int a, String p, String m) {
        this.hora = new Hora(h, mi, s);
        this.data = new Data(d, mes, a);
        this.nomePaciente = p;
        this.nomeMedico = m;
        quantidade++;
    }

    // Construtor com objetos Data e Hora
    public ConsultaAgendada(Data d, Hora h, String p, String m) {
        this.data = d;
        this.hora = h;
        this.nomePaciente = p;
        this.nomeMedico = m;
        quantidade++;
    }

    // Métodos set
    public void setData(int d, int m, int a) {
        if (this.data != null) {
            this.data = new Data(d, m, a);
        }
    }

    public void setData() {
        this.data = new Data();
    }

    public void setHora(int h, int mi, int s) {
        if (this.hora != null) {
            this.hora = new Hora(h, mi, s);
        }
    }

    public void setHora() {
        this.hora = new Hora();
    }

    public void setNomePaciente(String p) {
        this.nomePaciente = p;
    }

    public void setNomePaciente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome completo do paciente: ");
        this.nomePaciente = sc.nextLine();
    }

    public void setNomeMedico(String m) {
        this.nomeMedico = m;
    }

    public void setNomeMedico() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do médico: ");
        this.nomeMedico = sc.nextLine();
    }

    // Métodos get
    public int getAmostra() {
        return quantidade;
    }

    public String getData() {
        return this.data.mostra1();
    }

    public String getHora() {
        return this.hora.getHora1();
    }

    public String getNomePaciente() {
        return this.nomePaciente;
    }

    public String getNomeMedico() {
        return this.nomeMedico;
    }

    @Override
    public String toString() {
        return "Consulta Agendada:\n" +
               "Data: " + getData() + "\n" +
               "Hora: " + getHora() + "\n" +
               "Paciente: " + getNomePaciente() + "\n" +
               "Médico: " + getNomeMedico();
    }

    public static void main(String[] args) {

        StringBuilder resultado = new StringBuilder();

        // Instanciar o objeto p1 com o construtor com parâmetros
        ConsultaAgendada p1 = new ConsultaAgendada(10, 30, 15, 15, 8, 2024, "João da Silva", "Dr. João");
        resultado.append("Propriedades de p1:\n");
        resultado.append(p1.toString()).append("\n\n");

        // Instanciar o objeto p2 com o construtor sem parâmetros
        ConsultaAgendada p2 = new ConsultaAgendada();
        resultado.append("Propriedades de p2:\n");
        resultado.append(p2.toString()).append("\n\n");

        // Alterar propriedades de p1
        p1.setData(25, 12, 2024);
        p1.setHora(14, 45, 0);
        p1.setNomePaciente("Maria Oliveira");
        p1.setNomeMedico("Dra. Maria");

        resultado.append("Propriedades de p1 após alterações:\n");
        resultado.append(p1.toString()).append("\n\n");

        // Exibir a quantidade final de consultas
        resultado.append("Quantidade final de consultas: ").append(p1.getAmostra()).append("\n");

        // Exibir e escrever todo o resultado no arquivo de texto
        System.out.println(resultado.toString());

        try (PrintWriter writer = new PrintWriter(new FileWriter("resultado_exercicio3.txt"))) {
            writer.write(resultado.toString());
            System.out.println("Resultados escritos no arquivo 'resultado_exercicio3.txt'.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever o arquivo: " + e.getMessage());
        }
    }
}
