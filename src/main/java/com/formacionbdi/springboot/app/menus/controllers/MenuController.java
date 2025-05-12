package com.formacionbdi.springboot.app.menus.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.commons.models.entity.Menu;
import com.formacionbdi.springboot.app.menus.models.service.IMenuService;
import com.formacionbdi.springboot.app.menus.request.MenuRequest;


@RestController
//@RequestMapping("/producto") //localhost:8080/usuarios
@CrossOrigin
@Controller
public class MenuController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IMenuService menuService;
	
	
	
	@GetMapping("/listar")
	public List<Menu> listar(){
		return menuService.findAll().stream().map(menu ->{
			//producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			//producto.setPort(port);
			return menu;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/ver/{id}")
	public Menu detalle(@PathVariable Long id) {
		Menu menu = menuService.findById(id);
		//menu.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		//producto.setPort(port);
		
		/*
		 * try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return menu;
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Menu crear(@RequestBody MenuRequest menuRequest) {
		Menu menu = MenuRequest.from(menuRequest);
		return menuService.save(menu);
		
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Menu editar(@RequestBody MenuRequest menuRequest, @PathVariable Long id) {
		Menu menuDb = menuService.findById(id);
		
		menuDb = menuRequest.from(menuRequest, id);
        
        return menuService.save(menuDb);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		menuService.deleteById(id);
	}
	

}