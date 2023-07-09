package com.nt.service;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LinkMgmtServiceIMPL implements ILinksMgmtService {

	@Override
	public String showWishMessage() {
       //get current time
		LocalTime ldt=LocalTime.now();
		//get current hour of the day
		int hour=ldt.getHour();
		if(hour<12)
			return "Good Morning";
		else if(hour < 16)
			return "Good afternoon";
		else if(hour < 20)
			return "Good Evening";
		else
			return "Good night";
		
	}

	@Override
	public Set<String> showAllLanguages() {
		Locale locales[]=Locale.getAvailableLocales();
		Set<String>  languagesSet=new HashSet<String>();
		for(Locale l:locales) {
			languagesSet.add(l.getDisplayLanguage());
		}
		
		return languagesSet;
	}

}
