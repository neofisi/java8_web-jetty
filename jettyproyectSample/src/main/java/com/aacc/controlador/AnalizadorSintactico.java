package com.aacc.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AnalizadorSintactico
 */
@WebServlet("/AnalizadorSintactico")
public class AnalizadorSintactico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnalizadorSintactico() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<HashMap<String, String>> lista1 = new ArrayList<HashMap<String, String>>();
		String campo1 = request.getParameter("campo1");
		System.out.println("campo1=" + campo1);
		if (campo1 != null &&!campo1.isEmpty()) {
			campo1 = campo1.replaceAll("<", " ");
			System.out.println("campo1=" + campo1);
			for (String lista : campo1.split(">:")) {
				HashMap<String, String> mapa = new HashMap<String, String>();
				String cadena1 = lista.split("=")[0];
				String cadena2 = lista.split("=")[1];
				mapa.put(cadena1, (cadena2.trim()).replace(">", ""));
				lista1.add(mapa);
			}
		}
		HttpSession sesion = request.getSession();
		sesion.setAttribute("lista1", lista1);
		request.getRequestDispatcher("/mapeadorSintactico1.jsp").forward(request, response);
	}

}
