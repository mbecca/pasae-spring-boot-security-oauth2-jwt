package ar.edu.unlp.pasae.pasaepractica.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/")
	public String index() {
		return "Hola mundo desde UserController";
	}

	@RequestMapping("/user")
	public Principal user(final Principal user) {
		return user;
	}

}
