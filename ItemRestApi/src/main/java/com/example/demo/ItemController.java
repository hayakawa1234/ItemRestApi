package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("api/items")
public class ItemController {
	@Autowired
	ItemService itemService;

	//商品一覧取得API
	@RequestMapping(method = RequestMethod.GET)
	List<Item> getItems() {
		List<Item> customers = itemService.findAll();
		return customers;
	}

	//商品一件取得API
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Item getCustomer(@PathVariable Integer id) {
		Item customer = itemService.findOne(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"The given customer id is not found : " + id));
		return customer;
	}

	//商品登録API
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	Item postItem(@RequestBody Item item) {
		return itemService.create(item);
	}

	//商品削除API
	@DeleteMapping(path = "{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	void deleteItem(@PathVariable Integer id) {
		itemService.delete(id);
	}

	//商品削除API
		@DeleteMapping(path = "all")
		@ResponseStatus(HttpStatus.NO_CONTENT)
		void alDeleteItem() {
			itemService.allDelete();
		}

	//商品更新API
	@PutMapping(path = "{id}")
    Item putItem(@PathVariable Integer id, @RequestBody Item item) {
    	item.setId(id);
    	return itemService.update(item);
    }
}