/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apache.sis.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author haonguyen
 */
@WebServlet("/GetCpabilities")
public class GetCapabilities extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Object requestObject = request.getParameter("REQUEST");
                if (requestObject != null) {
                    String fileName = (String) requestObject;
                    URL url = getServletContext().getResource("/xmlfiles/"+fileName+".xml");
                    response.setContentType("application/xml");
                    PrintWriter printWriter = response.getWriter();
                    URLConnection urlConnection = url.openConnection();
                    urlConnection.connect();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
                    int byteOfDataRead = bufferedInputStream.read();
                    while (byteOfDataRead != 1) {
                        printWriter.write(byteOfDataRead);
                        byteOfDataRead = bufferedInputStream.read();
                    }
                    if (printWriter != null) printWriter.close();
                    if (bufferedInputStream !=null) bufferedInputStream.close();
                }
            }
    
}