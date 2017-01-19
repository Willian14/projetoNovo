<%@page import="br.com.projetonovo.Dao.AutorDao"%>
<%@page import="br.com.projetonovo.entity.Autor"%>
<%@page import="br.com.projetonovo.entity.Genero"%>
<%@page import="java.util.List"%>
<%@page import="br.com.projetonovo.Dao.GeneroDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<% 
		
		Genero genero = (Genero)request.getAttribute("genero");
		GeneroDao genDao= new GeneroDao();
		AutorDao autDao = new AutorDao();
		List<Autor> listaaut = autDao.buscaTodos();
		List<Genero> listag = genDao.buscaTodosGeneros();
	%>
	<form method="post" action="livrocontroller.do">
		<h1>Cadastro de livros</h1>
		<label>Isbn:</label><br/>
		<input type = "number" name="isbn" /><br/>
		<label>Título:</label><br/>
		<input type = "text" name="titulo" value = " "/><br/>
		<label>Descrição:</label><br/>
		<input type = "text" name="descricao" value = " "/><br/>
		<label>Ano de Lançamento:</label><br/>
		<input type = "text" name="anolanc" value = " "/><br/>
		<label>ID Autor:</label><br/>
		<input type = "text" name="idaut" value = " "/><br/>
		<label>Id Gênero:</label><br/>
		<input type = "text" name="idgen" value = " "/><br/>
				
		Gênero:<select name="cbxgenero">
			<%for(Genero g : listag){%>
				<option><%=g.getDescricao() %></option>
			<%}%>			
		</select>
		Autores:<select name="cbxaut">
			<%for(Autor a : listaaut){%>
				<option><%=a.getNome() %></option>
			<%}%>			
		</select>
		<input type="submit" value="SALVAR"/>
	</form>
</body>
</html>