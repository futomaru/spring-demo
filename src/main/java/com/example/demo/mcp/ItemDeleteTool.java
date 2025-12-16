package com.example.demo.mcp;

import com.example.demo.service.ItemsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public record ItemDeleteTool(ItemsService itemsService, ObjectMapper mapper) {

    public McpToolDefinition definition() {
        var schema = mapper.createObjectNode();
        schema.put("type", "object");
        return new McpToolDefinition("deleteItem", "Delete an item by ID.", schema);
    }

    public Object execute(JsonNode arguments) {
        long id = arguments == null ? 0 : arguments.path("id").asLong();
        itemsService.deleteItem(id);
        var response = mapper.createObjectNode();
        response.put("status", "deleted");
        response.put("id", id);
        return response;
    }
}
