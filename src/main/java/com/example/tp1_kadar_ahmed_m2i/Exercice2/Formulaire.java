package com.example.tp1_kadar_ahmed_m2i.Exercice2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Formulaire" , value = "/formulaire")
public class Formulaire extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<form action=\"nomAge\" method=\"post\">" +
                "Nom : <input type=\"text\" name=\"nom\" > <br><br>" +
                "Prénom : <input type=\"text\" name=\"prenom\" > <br><br>" +
                "Date de naissance : <input type=\"text\" placeholder = \"jj/mm/aaaa\" name=\"date\" > <br><br>" +
                "<input type=\"submit\" name=\"Envoyer\" > <br><br></form>");

        out.println("</html></body>");
    }

}
