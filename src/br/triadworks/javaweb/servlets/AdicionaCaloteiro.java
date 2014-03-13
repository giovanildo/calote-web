package br.triadworks.javaweb.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.triadworks.javaweb.dao.CaloteiroDAO;
import br.triadworks.javaweb.modelo.Caloteiro;

@WebServlet("/adicionaCaloteiro")
public class AdicionaCaloteiro extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String devendo = request.getParameter("devendo");
		String dataDivida = request.getParameter("dataDivida");	
		Calendar dataDividaConvertida = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataDivida);
			dataDividaConvertida = Calendar.getInstance();
			dataDividaConvertida.setTime(data);	
		}catch (ParseException e) {
			out.println("Erro de conversão da data");
			throw new CaloteiroServletException();
		}

		//Motando o objeto Caloteiro
		Caloteiro caloteiro = new Caloteiro();
		caloteiro.setNome(nome);
		caloteiro.setEmail(email);
		caloteiro.setDevendo(new Integer(devendo));
		caloteiro.setDataDivida(dataDividaConvertida);
		
		//inserindo no banco com o CaloteiroDAO
//		CaloteiroDAO dao = new CaloteiroDAO();
		Connection connection = (Connection) request.getAttribute("conexao");
		CaloteiroDAO dao = new CaloteiroDAO(connection);
		dao.adiciona(caloteiro);

		//imprime em HTML o resultado
//		out.println("<html>");
//		out.println("<body>");
//		out.println("Caloteiro " + caloteiro.getNome() +
//			" adicionado com sucesso");
//		out.println("</body>");
//		out.println("</html>");
		RequestDispatcher rd = request.getRequestDispatcher("/caloteiro-adicionado.jsp");
		rd.forward(request, response);
	}
}
