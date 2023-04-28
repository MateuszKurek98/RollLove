package com.matshop.myshopm;

import com.matshop.myshopm.model.Item;
import com.matshop.myshopm.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner {
    private final ItemRepository itemRepository;
    @Autowired

    public DbInit(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        itemRepository.saveAll(List.of(
           new Item("RolkiK2", new BigDecimal("249.99"), "https://rolla.pl/3930-large_default/rolki-k2-fit-80-pro.jpg"),
           new Item("Rolki rekreacyjne", new BigDecimal("220.90"), "https://cdn.bladeville.pl/media/catalog/product/cache/1/image/480x480/9df78eab33525d08d6e5fb8d27136e95/i/m/img_2609.jpg"),
           new Item("Rolki rekreacyjne dziecięce", new BigDecimal("140.90"), "https://cdn.bladeville.pl/media/catalog/product/cache/1/image/265x/9df78eab33525d08d6e5fb8d27136e95/i/m/img_2616.jpg")
        ));

    }
}
