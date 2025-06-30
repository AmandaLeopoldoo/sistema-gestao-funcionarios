package entities;

public class Funcionario {
    private Integer id;
    private String nome;
    private Double salario;

    public Funcionario(Integer id, String nome, Double salario) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID deve ser um número positivo");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (salario == null || salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("ID não pode ser nulo"); // Mensagem de erro acaso o usuario digite valor invalido.
        }
        if (id <= 0){
            throw new IllegalArgumentException("ID deve ser um número positivo");
        }
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        if (salario == null) {
            throw new IllegalArgumentException("Salário não pode ser nulo");
        }
        if (salario < 0) {
            throw new IllegalArgumentException("Salário não pode ser negativo");
        }
        this.salario = salario;
    }

    public void aumentoSalario(double porcentagem){
        if (porcentagem < 0) {
            throw new IllegalArgumentException("Porcentagem de aumento não pode ser negativa");
        }
        salario += salario * porcentagem / 100.0;
    }

    @Override
    public String toString() {
        return String.format("%d, %s, %.2f", id, nome, salario);
    }
}
