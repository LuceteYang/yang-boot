package com.example.demo.controller.api;

import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
public class CookieSessionController {
	@GetMapping(path = "/hello")
	public String hello() {
		return "helloworld1";
	}
	
	@GetMapping(path = "/set-session")
	public String setSession(HttpSession session) {
		session.setAttribute("userLoginInfo", "test");
		return "session seted";
	}
	@GetMapping(path = "/get-session")
	public String getSession(HttpSession session) {
		return (String) session.getAttribute("userLoginInfo");
	}
	@GetMapping(path = "/delete-session")
    public String logout(HttpSession session) {
        session.setAttribute("userLoginInfo", null);
        return "session deleted";
    }
	@GetMapping(path = "/set-cookie")
	public String setCookie(HttpServletResponse response) {
        Cookie storeIdCookie = new Cookie("storeIdCookie", "123212");
        storeIdCookie.setMaxAge(60 * 60 * 24 * 30);
        response.addCookie(storeIdCookie);
		return "cookie seted";
	}
	@GetMapping(path = "/get-cookie")
	public String getCookie(@CookieValue(value="storeIdCookie", required = false) Cookie storeIdCookie) {
		return storeIdCookie.getValue();
	}
	@GetMapping(path = "/delete-cookie")
    public String deleteCookie(HttpServletRequest request, HttpServletResponse response) {
	    Cookie cookieWithSlash = new Cookie("storeIdCookie", null);
	    //Tomcat adds extra slash at the end of context path (e.g. "/foo/")
	    //cookieWithSlash.setPath(request.getContextPath() + "/"); 
	    cookieWithSlash.setMaxAge(0);
	    response.addCookie(cookieWithSlash);
        return "cookie deleted";
    }
}
