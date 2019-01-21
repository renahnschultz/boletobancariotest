package br.com.bb.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.dao.ProductDAO;
import br.com.bb.entity.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDAO productDAO;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/product/listByCategory/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Iterable<Product> produtos(@PathVariable("id") Integer id) {
		return productDAO.findByCategoryId(id);
	}
}
