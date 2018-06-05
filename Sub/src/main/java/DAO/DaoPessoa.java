package DAO;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.ConexaoBD1;
import Model.Pessoa;

@SuppressWarnings("unused")
public class DaoPessoa {

@SuppressWarnings("static-access")
public boolean InserirPessoa(Pessoa pes) {
		
		String SQL = "INSERT INTO bank2.peoples2 (id, nome, idade, endereco, cpf) values (?, ?, ?, ?, ?)"; 

try {
	PreparedStatement pst = ConexaoBD2.getConexaoMySQL().prepareStatement(SQL);

	pst.setInt(1, pes.getId());
	pst.setString(2, pes.getNome());
	pst.setInt(3, pes.getIdade());
	pst.setString(4, pes.getEndereco());
	pst.setString(5, pes.getCpf());
	
	pst.executeUpdate();
} catch(SQLException ex) {
	System.out.println("Erro: " + ex.getMessage());
	return false;
}
return false;	
}


@SuppressWarnings("static-access")
public void busca(Pessoa pessoa) {
	String SQL = "SELECT * FROM sys.peoples WHERE id = ?";
	
	try {
		PreparedStatement stmt = ConexaoBD1.getConexaoMySQL().prepareStatement(SQL);
		stmt.setInt(1, pessoa.getId());
	
		ResultSet result = stmt.executeQuery();
		
		if (result.next()) {
			System.out.println("Entrou no buscador");
			Pessoa pessoaP = new Pessoa();
			
			pessoaP.setId(result.getInt("id"));
			pessoaP.setNome(result.getString("nome"));
			pessoaP.setIdade(result.getInt("idade"));
			pessoaP.setEndereco(result.getString("endereco"));
			pessoaP.setCpf(result.getString("cpf"));
		
			InserirPessoa(pessoaP);
			
		}else {
			System.out.println("Saiu do buscador sem nada!");
		}
		
	} catch(SQLException ex) {
		System.out.println("Erro: " + ex.getMessage());
	}
	
}
}