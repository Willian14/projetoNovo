package br.com.projetonovo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetonovo.Dao.LivroDao;
import br.com.projetonovo.entity.Livro;
@WebServlet("/livrocontroller.do")
public class LivroController extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		if(acao.equals("cadliv")){
			
			RequestDispatcher rd = req.getRequestDispatcher("frmlivro.jsp");
			rd.forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String  isbn =req.getParameter("isbn").trim();// o .trim nesse caso serve para que quando selecionarmos um valor auto completado pelo browser não gere uma exception
		String titulo = req.getParameter("titulo");
		String descricao = req.getParameter("descricao");
		String anolanc = req.getParameter("anolanc");
		String idaut =req.getParameter("idaut").trim();
		String idgen =req.getParameter("idgen").trim();
		String nomeaut = req.getParameter("nomeaut");
		String cbxgenero = req.getParameter("cbxgenero");
		String cbxaut = req.getParameter("cbxaut");
		
		Livro liv = new Livro();
		if(!req.getParameter("isbn").equals(" "))
			liv.setIsbn(Integer.parseInt(isbn));
		liv.setTitulo(titulo);
		liv.setDescricao(descricao);
		liv.setAnoLanc(anolanc);
		if(!req.getParameter("idaut").equals(" "))
			liv.setId_autor(Integer.parseInt(idaut));
		if(!req.getParameter("idgen").equals(" "))
			liv.setId_genero(Integer.parseInt(idgen));
		liv.setDescricao_genero(cbxgenero);
		liv.setNome_autor(cbxaut);
		
		LivroDao livDao = new LivroDao();
		livDao.salvarLivro(liv);
		}		
		
	
}

