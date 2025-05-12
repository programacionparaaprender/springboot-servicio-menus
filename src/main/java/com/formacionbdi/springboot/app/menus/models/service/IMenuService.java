package com.formacionbdi.springboot.app.menus.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.commons.models.entity.Menu;

public interface IMenuService {
	public List<Menu> findAll();

	public Menu findById(Long id);

	public Menu save(Menu menu);

	public void deleteById(Long id);
}
