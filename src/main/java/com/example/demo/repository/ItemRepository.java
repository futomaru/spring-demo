package com.example.demo.repository;

import com.example.demo.model.Item;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemRepository {

    String BASE_SELECT = """
        SELECT id, name, price, description
        FROM items
        """;

    @Select(BASE_SELECT + " ORDER BY id")
    List<Item> findAll();

    @Select(BASE_SELECT + """
        WHERE name LIKE CONCAT('%', #{name}, '%')
        ORDER BY id
        """)
    List<Item> findByName(String name);
}
