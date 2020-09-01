package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	@Autowired
	ItemRepository itemRepository;

	//商品一覧取得
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	//商品一覧取得
	public Item create(Item item) {
		return itemRepository.save(item);
	}

}
