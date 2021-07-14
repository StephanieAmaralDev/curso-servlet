package br.com.alura.gerenciador.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/novaEmpresa") //mapeamento
public class NovaEmpresaServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //doPost   doGet  requisições
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("Cadastrando nova empresa");

        String nomeEmpresa = request.getParameter("nome");
        String paramDataEmpresa = request.getParameter("data");
        Date dataAbertura = null;

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dataAbertura = simpleDateFormat.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Empresa empresa = new Empresa();
        empresa.setNome(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        request.setAttribute("empresa", empresa.getNome());

        response.sendRedirect("listaEmpresas");

        /*//chamar o jsp
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresas");
        request.setAttribute("empresa", empresa.getNome());
        requestDispatcher.forward(request, response);*/
    }
}