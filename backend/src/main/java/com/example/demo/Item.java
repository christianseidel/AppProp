package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@Data
public class Item {

    @Id
    private String id;
    private String name;

    public Item (String item) {
        this.name = item;
    }

}
