package com.example.demo;

import java.util.List;
import java.util.Optional;

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

	//商品一件取得
	public Optional<Item> findOne(int id) {
		return itemRepository.findById(id);
	}

	//商品一覧取得
	public Item create(Item item) {
		return itemRepository.save(item);
	}

	//商品を一件削除
	public void delete(Integer id) {
		itemRepository.deleteById(id);
	}

	//商品を更新
	public Item update(Item item) {
		return itemRepository.save(item);
	}
}
