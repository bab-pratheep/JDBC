package com.example.demo.repository;

import com.example.demo.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class InventoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Inventory> findAll() {
        String sql = "SELECT * FROM inventory";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Inventory.class));
    }

    public void save(Inventory inventory) {
        String sql = "INSERT INTO inventory (code, description, details, in_stock, type_id, supplier_id, rate_type_id, category_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                inventory.getCode(),
                inventory.getDescription(),
                inventory.getDetails(),
                inventory.getInStock(),
                inventory.getTypeId(),
                inventory.getSupplierId(),
                inventory.getRateTypeId(),
                inventory.getCategoryId());
    }
}
