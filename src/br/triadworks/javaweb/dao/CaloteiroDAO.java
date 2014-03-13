package br.triadworks.javaweb.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.triadworks.javaweb.modelo.Caloteiro;

public class CaloteiroDAO {

	private Connection connection;
	
	public CaloteiroDAO(Connection connection){
		this.connection = connection;
	}
	
	public void adiciona(Caloteiro caloteiro){
		String sql = "insert into caloteiro " +
			"(nome, email, devendo, dataDivida) " +
			"values (?,?,?,?)";

		try {
			//preparando a insercao
			PreparedStatement pstmt = connection.prepareStatement(sql);	

			//setando os valores
			pstmt.setString(1, caloteiro.getNome());
			pstmt.setString(2, caloteiro.getEmail());
			pstmt.setInt(3, caloteiro.getDevendo());
			pstmt.setDate(4, new Date(caloteiro.getDataDivida().getTimeInMillis()));

			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Caloteiro> getLista(){
		try{
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from caloteiro");

			List<Caloteiro> caloteiros = new ArrayList<Caloteiro>();
			Caloteiro caloteiro = null;
			ResultSet rs = stmt.executeQuery();

			while(rs.next()){
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				int devendo = rs.getInt("devendo");

				Calendar dataDivida = Calendar.getInstance();
			    dataDivida.setTime(rs.getDate("dataDivida"));

			    //criando o objeto caloteiro
				caloteiro = new Caloteiro();

				caloteiro.setNome(nome);
				caloteiro.setEmail(email);
				caloteiro.setDevendo(new Integer(devendo));
				caloteiro.setDataDivida(dataDivida);

				caloteiros.add(caloteiro);
			}

			rs.close();
			stmt.close();
			return caloteiros;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
