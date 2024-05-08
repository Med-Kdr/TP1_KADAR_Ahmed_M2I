package com.example.tp1_kadar_ahmed_m2i.Exercice2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.Printable;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.PrimitiveIterator;

@WebServlet(name = "NomAge" , value = "/nomAge")
public class NomAge extends HttpServlet {

    private int calculAge(String dateNaissanceString) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissanceDate = df.parse(dateNaissanceString);
        Calendar dateNaissanceCalendar = Calendar.getInstance();
        dateNaissanceCalendar.setTime(dateNaissanceDate);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dateNaissanceCalendar.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dateNaissanceCalendar.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == dateNaissanceCalendar.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) <
                dateNaissanceCalendar.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }
        return age;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html><head><link rel=\"stylesheet\" href=\"nomAgeStyle.css\"></head>");
        out.println("<body><div class=\"container\">");

        int age = -1;
        try {
            age = calculAge(request.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String msg;
        if(age == -1) {
            msg = " '"+request.getParameter("date")+ "' n'est pas le bon format 'JJ/MM/AAAA'.";
        }
        else {
            msg = "vous avez "+age+" ans.";
        }

        out.println("<p>Bonjour "+request.getParameter("nom")+" "+request.getParameter("prenom")+" "+msg+" </p>");

        out.println("</div></html></body>");

    }

}
