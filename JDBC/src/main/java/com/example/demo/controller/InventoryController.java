package com.example.demo.controller;

import com.example.demo.model.Inventory;
import com.example.demo.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    @PostMapping
    public String create(@RequestBody Inventory inventory) {
        inventoryRepository.save(inventory);
        return "Inventory saved!";
    }
}
