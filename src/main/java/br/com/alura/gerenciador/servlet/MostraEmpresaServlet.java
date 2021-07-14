package br.com.alura.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/mostraEmpresa") //mapeamento
public class MostraEmpresaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String paramId = request.getParameter("id");
        Integer id = Integer.valueOf(paramId);

        Banco banco = new Banco();
        Empresa empresa = banco.buscaPelaId(id);

        System.out.println(empresa.getNome());

        request.setAttribute("empresa", empresa);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
        requestDispatcher.forward(request, response);
    }
}

