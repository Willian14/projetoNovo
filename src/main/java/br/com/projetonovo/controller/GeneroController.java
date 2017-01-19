package br.com.projetonovo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projetonovo.Dao.AutorDao;
import br.com.projetonovo.Dao.GeneroDao;
import br.com.projetonovo.entity.Autor;
import br.com.projetonovo.entity.Genero;
@WebServlet("/generocontroller.do")
public class GeneroController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idgen = req.getParameter("idgen");
		String descricao = req.getParameter("descricao");
		
		Genero gen = new Genero();
		if (idgen.isEmpty() == false)
			gen.setId(Integer.parseInt(idgen));
		gen.setDescricao(descricao);
		
		GeneroDao genDao = new GeneroDao();
		genDao.salvarGenero(gen);
		
		
		
	}
	
}
