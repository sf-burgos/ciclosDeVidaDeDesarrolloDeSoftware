package edu.eci.cvds.servlet;

import edu.eci.cvds.servlet.model.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    urlPatterns = "/laHeredada"
	)
public class LaHeredera extends HttpServlet {
	static final long serialVersionUID = 35L;

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Writer responseWriter = resp.getWriter();
       ArrayList<Todo> lis = new ArrayList<Todo>();
       Todo t;
       int temp;
       try {
	       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
	       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : null;
	       temp = Integer.parseInt(id);
	       t = Service.getTodo(temp);
	       lis.add(t);	
	       resp.setStatus(HttpServletResponse.SC_OK);
	       responseWriter.write(Service.todosToHTMLTable(lis));
       }catch(FileNotFoundException e){
           resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }catch(NumberFormatException e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch(Exception e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       } 
       responseWriter.flush();
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
	   Writer responseWriter = resp.getWriter();
       ArrayList<Todo> lis = new ArrayList<Todo>();
       Todo t;
       int temp;
       try {
	       Optional<String> optName = Optional.ofNullable(req.getParameter("id"));
	       String id = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : null;
	       temp = Integer.parseInt(id);
	       t = Service.getTodo(temp);
	       lis.add(t);	
	       resp.setStatus(HttpServletResponse.SC_OK);
	       responseWriter.write(Service.todosToHTMLTable(lis));
       }catch(FileNotFoundException e){
           resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
       }catch(NumberFormatException e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       }catch(MalformedURLException e){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
       }catch(Exception e){
	        resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
       } 
       responseWriter.flush();
   }

}
