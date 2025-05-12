package com.formacionbdi.springboot.app.menus.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.commons.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
