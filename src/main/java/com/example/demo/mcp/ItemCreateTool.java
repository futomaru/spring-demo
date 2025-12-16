package com.example.demo.mcp;

import com.example.demo.model.ItemRequest;
import com.example.demo.service.ItemsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public record ItemCreateTool(ItemsService itemsService, ObjectMapper mapper) {

    public McpToolDefinition definition() {
        var schema = mapper.createObjectNode();
        schema.put("type", "object");
        return new McpToolDefinition("createItem", "Create a new item.", schema);
    }

    public Object execute(JsonNode arguments) {
        ItemRequest request = mapper.convertValue(arguments, ItemRequest.class);
        return itemsService.createItem(request);
    }
}
