package br.com.projetonovo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.projetonovo.Dao.AutorDao;
import br.com.projetonovo.entity.Autor;


@WebServlet("/autorcontroller.do")
public class AutorController extends HttpServlet {
 @Override
public void init() throws ServletException {
	// TODO Auto-generated method stub
	super.init();
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String id = req.getParameter("id");
	String nome = req.getParameter("nome");
	
	Autor aut = new Autor();
	
	if(id.isEmpty() == false)
		aut.setId(Integer.parseInt(id));
	aut.setNome(nome);
	
	AutorDao autDao = new AutorDao();
	autDao.salvarAutor(aut);
	System.out.println("chamou post");
	
	
		
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     System.out.println("cahmou get");

	}
	@Override
		public void destroy() {
			// TODO Auto-generated method stub
			super.destroy();
		}
}
