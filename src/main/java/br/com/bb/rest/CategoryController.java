package br.com.bb.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.dao.CategoryDAO;
import br.com.bb.entity.Category;

@RestController
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/category/listAll", produces = "application/json;charset=UTF-8")
	public Iterable<Category> categorias() {

		return categoryDAO.findAll();
	}

	@RequestMapping(value = "/category/ocurrences/{letter}", produces = "application/json;charset=UTF-8")
	public Category categorias(@PathVariable("letter") char letra) {

		Iterable<Category> findAll = categoryDAO.findAll();
		long times = -1;
		Category moreTimes = null;
		for (Category category : findAll) {
			long count = category.getName().chars().filter(num -> num == letra).count();
			if (count > times) {
				times = count;
				moreTimes = category;
			}
		}
		return moreTimes;
	}
}
