package com.example.demo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "item_info")
@Data
public class Item implements Serializable {
	@Id
	private Integer id;
	private String name;
	private Integer price;
	private String img_path;
}
