package com.example.tp1_kadar_ahmed_m2i.Exercice1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Table_multiplication" , value = "/multiplication")
public class Table_multiplication extends HttpServlet {

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><style>table, th, td {border:1px solid black;text-align:center}h1 {text-align: center;margin: 30px;}th,td {width:80px;height:30px}</style><body>");
        out.println("<h1>Table de multiplication</h1>");
        out.println("<table  style=\"width:80%;margin:auto;\">");
        out.println("<tr><th style=\"background-color: #ccc;\">x*y</th>");
        for(int i=1;i<=10;i++) {
            out.println("<th style=\"background-color: #ddd;\">"+i+"</th>");
        }
        out.println("</tr>");
        for(int i=1;i<=10;i++) {
            out.print("<tr><th style=\"background-color: #ddd;\">"+i+"</th>");
            for(int j=1;j<=10;j++) {
                out.println("<td>"+i*j+"</td>");
            }
            out.println("</tr>");
        }


        out.println("</table>");
        out.println("</html></body>");

    }



}
