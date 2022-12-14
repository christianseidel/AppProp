package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final ItemRepository itemRepository;

    public TestService (ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String createItem(String myString) {
        System.out.println(myString);
        Item item = itemRepository.save(new Item(myString));
        return "Your last item was: " + item.getName();
    }

}
