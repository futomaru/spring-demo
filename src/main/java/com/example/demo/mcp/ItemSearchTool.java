package com.example.demo.mcp;

import com.example.demo.service.ItemsService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public record ItemSearchTool(ItemsService itemsService, ObjectMapper mapper) {

    public McpToolDefinition definition() {
        var schema = mapper.createObjectNode();
        schema.put("type", "object");
        return new McpToolDefinition("searchItems", "Search items by name.", schema);
    }

    public Object execute(JsonNode arguments) {
        String name = arguments == null ? "" : arguments.path("name").asText("");
        return itemsService.findByName(name);
    }
}
