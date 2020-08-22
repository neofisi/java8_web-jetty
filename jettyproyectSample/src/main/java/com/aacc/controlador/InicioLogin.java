package com.aacc.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.util.security.Credential;

/**
 * Servlet implementation class InicioLogin
 */
@WebServlet("/InicioLogin")
public class InicioLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final private static byte[] CHALLENGE_MESSAGE =	{(byte)'N', (byte)'T', (byte)'L', (byte)'M', (byte)'S', (byte)'S', (byte)'P', 0,
			2, 0, 0, 0, 0, 0, 0, 0,	40, 0, 0, 0, 1, (byte)130, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, // nonce
			0, 0, 0, 0, 0, 0, 0, 0};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fechaCarga = getServletContext().getInitParameter("fechacarga");
		System.out.println("init param = "+ fechaCarga);
		System.out.println("Pagina de Inicio");
		System.out.println("req.getRequestURI():"+request.getRequestURI());
		System.out.println("req.getQueryString():"+request.getQueryString());
		System.out.println("CHALLENGE_MESSAGE=["+CHALLENGE_MESSAGE+"]");
		System.out.println(HttpServletResponse.SC_UNAUTHORIZED);
		String auth = request.getHeader("Authorization");		
		
		System.out.println(auth);
		System.out.println("ruta completa=["+request.getContextPath()+"]");
		ofuscacionPassword(); 
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
	private void ofuscacionPassword() {
		System.out.println("Ofuscando");
		String usuario = "neo";
		String password = "pasword";
		org.eclipse.jetty.util.security.Password pw =  new org.eclipse.jetty.util.security.Password(password);
		String campoOfuscado = pw.toString();
		System.out.println("campoOfuscado=["+pw.obfuscate(pw.toString())+"]");
		System.out.println("Credential.MD5.digest=["+Credential.MD5.digest(pw.toString())+"]");
		System.out.println("Credential.Crypt.crypt=["+ Credential.Crypt.crypt(usuario, pw.toString()) +"]");
	}

}
