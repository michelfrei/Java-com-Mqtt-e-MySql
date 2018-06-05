package DAO;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Control.Mosquitto_pub;
import Model.Pessoa;

public class DaoPessoa {

public static boolean InserirPessoa(Pessoa pes) {
		
		String SQL = "INSERT INTO sys.peoples (nome, idade, endereco, cpf) values (?, ?, ?, ?)"; 

try {
	PreparedStatement stmt = ConexaoBD1.getConexaoMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

	
	stmt.setString(1, Pessoa.getNome());
	stmt.setInt(2, Pessoa.getIdade());
	stmt.setString(3, Pessoa.getEndereco());
	stmt.setString(4, Pessoa.getCpf());
	
	 if(stmt.executeUpdate()>0){
		
		ResultSet result = stmt.getGeneratedKeys();
		System.out.println("chegou aqui");
		
		if (result.next()) {
			
		    System.out.println("ID: " + result.getInt(1));
		    
		    Mosquitto_pub mosquittoPub = new Mosquitto_pub(Integer.toString(result.getInt(1)), "teste_SD", 1883, "localhost");
		    
		    if (!mosquittoPub.SendMessege()){
		    	JOptionPane.showMessageDialog(null, "Erro no enviar mensagem 'DaoPessoa'", "Sistema", JOptionPane.ERROR_MESSAGE);
		    }		    
		}		
        return true;
    } 
} catch(SQLException ex) {
	System.out.println("Erro: " + ex.getMessage());
	return false;
}
return false;	
}
}