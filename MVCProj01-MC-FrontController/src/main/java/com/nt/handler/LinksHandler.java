package com.nt.handler;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.nt.service.ILinksMgmtService;
import com.nt.service.LinkMgmtServiceIMPL;

public class LinksHandler {
	private ILinksMgmtService service;

	public LinksHandler() {
	  service 	 = new LinkMgmtServiceIMPL();
	}
	
	//handler method1
	public String	fetchWishMessage(HttpServletRequest req) {
		String result = service.showWishMessage();
		req.setAttribute("wishMsg", result);
		return "Show_Msg";
	}
	
	//handler method2
	public String	fetchLanguages(HttpServletRequest req) {
		Set<String> langs=service.showAllLanguages();
		req.setAttribute("langsMsg",langs);
		return "langs_Msg";
	}

}
