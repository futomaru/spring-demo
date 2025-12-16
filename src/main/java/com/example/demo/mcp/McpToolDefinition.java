package com.example.demo.mcp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Metadata sent to MCP clients when they request the list of tools.
 */
public record McpToolDefinition(String name, String description, ObjectNode inputSchema) {

    public ObjectNode asJson(ObjectMapper mapper) {
        ObjectNode node = mapper.createObjectNode();
        node.put("name", name);
        node.put("description", description);
        node.set("inputSchema", inputSchema == null ? mapper.createObjectNode() : inputSchema.deepCopy());
        return node;
    }
}
