package com.formacionbdi.springboot.app.menus.request;

import java.util.stream.Collectors;

import com.formacionbdi.springboot.app.commons.models.entity.Menu;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MenuRequest {

	private String nombre;

	private String url;

	private int hijo;
	
	public static Menu from(MenuRequest menuRequest, Long id) {
		if(menuRequest == null) return null;
		
		return Menu.builder()
				  .Id(id)
	              .nombre(menuRequest.getNombre())
	    		  .url(menuRequest.getUrl())
	    		  .hijo(menuRequest.getHijo())
	    		  .build();
	}
	
	public static Menu from(MenuRequest menuRequest) {
		if(menuRequest == null) return null;
		
		return Menu.builder()
	              .nombre(menuRequest.getNombre())
	    		  .url(menuRequest.getUrl())
	    		  .hijo(menuRequest.getHijo())
	    		  .build();
	}
	
}
