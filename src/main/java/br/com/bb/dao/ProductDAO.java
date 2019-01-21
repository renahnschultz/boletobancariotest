package br.com.bb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.entity.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Long> {

	public List<Product> findByCategoryId(Integer id);
}
