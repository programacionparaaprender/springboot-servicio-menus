package com.formacionbdi.springboot.app.menus.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionbdi.springboot.app.commons.models.entity.Menu;
import com.formacionbdi.springboot.app.menus.models.dao.MenuRepository;

@Service
public class MenuService implements IMenuService{

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Menu> findAll() {
		return (List<Menu>) menuRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Menu findById(Long id) {
		return menuRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Menu save(Menu menu) {
		return menuRepository.save(menu);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		menuRepository.deleteById(id);
	}
	
}
