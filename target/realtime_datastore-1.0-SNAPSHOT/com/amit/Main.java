package com.amit;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Main extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            InMemory<String, Object> inMemory = new InMemory<>();
            String key = request.getParameter("key");
            Object value = inMemory.get(key);

            PrintWriter printWriter = response.getWriter();
            printWriter.print(value);
        }
        catch(Exception exception){

            PrintWriter printWriter = response.getWriter();
            printWriter.print("");
        }

    }

    // Method to handle POST method request.
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try{
            InMemory<String, Object> inMemory = new InMemory<>();
            String key = request.getParameter("key");
            Object value = request.getParameter("value");
            inMemory.put(key, value);

            PrintWriter printWriter = response.getWriter();
            printWriter.print("Done");
        }
        catch(Exception exception){
            PrintWriter printWriter = response.getWriter();
            printWriter.print("Fail");
        }

    }

}
