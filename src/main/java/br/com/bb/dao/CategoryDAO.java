package br.com.bb.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.bb.entity.Category;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Long> {

	public List<Category> findByNameLike(String name);
}
