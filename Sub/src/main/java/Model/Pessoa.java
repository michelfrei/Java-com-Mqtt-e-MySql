package Model;

public class Pessoa {
    private static int id;
    private static String nome;
    private static String endereco;
    private static int idade;
    
    private static String cpf;
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Pessoa.id = id;
	}
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Pessoa.nome = nome;
	}
	public static int getIdade() {
		return idade;
	}
	public static void setIdade(int idade) {
		Pessoa.idade = idade;
	}
	public static String getEndereco() {
		return endereco;
	}
	public static void setEndereco(String endereco) {
		Pessoa.endereco = endereco;
	}
	public static String getCpf() {
		return cpf;
	}
	public static void setCpf(String cpf) {
		Pessoa.cpf = cpf;
	}

    
}
