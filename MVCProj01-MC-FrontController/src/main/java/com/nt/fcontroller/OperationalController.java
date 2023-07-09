package com.nt.fcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.handler.LinksHandler;

@WebServlet(urlPatterns = "/", loadOnStartup = 1)
public class OperationalController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinksHandler handler=null;
	public void init() throws ServletException{
		handler=new LinksHandler();
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
        String path=req.getServletPath();
        String lvn=null;
        if(path.equalsIgnoreCase("/wish"))
        	lvn=handler.fetchWishMessage(req);
        else if(path.equalsIgnoreCase("/langs"))
        	lvn=handler.fetchLanguages(req);
        else
        	lvn="home";
        
        String destPage=null;
        if(lvn.equalsIgnoreCase("Show_Msg"))
        	destPage="/show_wish.jsp";
        else if (lvn.equalsIgnoreCase("langs_Msg"))
        	destPage="/show_languages.jsp";
        else
        	destPage="index.jsp";
        
        RequestDispatcher rd=req.getRequestDispatcher(destPage);
        rd.forward(req, res);
        	
	}
	

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		doGet(req, res);
	}

}
