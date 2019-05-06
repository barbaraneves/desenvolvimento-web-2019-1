package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/efetuar-login")
public class EfetuarLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession sessao = request.getSession();
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		Usuario usuario = usuarioDAO.buscarUsuario(nome, senha);
				
		//Caso o usuário esteja na lista de pessoas cadastradas
		if (usuario != null) {
			sessao.setAttribute("usuario-logado", nome);
			
			//Ele é redirecionado para a página de sucesso.html
			response.sendRedirect("sucesso-login.html");
			
			//Para pegar o id da sessão toda vez que alguém logar no sistema
			request.getSession().setAttribute("idUsuario", nome.getId());
		}
		//Caso o usuário tenha feito o login errado
		else{
			//Ele irá para a página de erro-login.html onde ele poderá fazer o login novamente
			response.sendRedirect("erro-login.html");
		}
	}
}