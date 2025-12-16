package com.example.demo.mcp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("stdio-mcp")
public record StdioMcpRunner(
        ObjectMapper mapper,
        ItemCreateTool createTool,
        ItemSearchTool searchTool,
        ItemDeleteTool deleteTool) implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Map<String, ToolExecutor> toolMap = Map.of(
                "createItem", createTool::execute,
                "searchItems", searchTool::execute,
                "deleteItem", deleteTool::execute);
        List<McpToolDefinition> defs = List.of(
                createTool.definition(),
                searchTool.definition(),
                deleteTool.definition());

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(System.out, true)) {
            writer.println(helpMessage());
            for (String line; (line = reader.readLine()) != null;) {
                if (line.isBlank()) {
                    continue;
                }
                JsonNode request = mapper.readTree(line);
                String tool = request.path("tool").asText();
                JsonNode params = request.get("arguments");

                ObjectNode response = mapper.createObjectNode();
                if ("listTools".equals(tool)) {
                    response.set("tools", mapper.valueToTree(defs.stream().map(def -> def.asJson(mapper)).toList()));
                }
                else {
                    Object result = toolMap.getOrDefault(tool, json -> "unknown tool").execute(params);
                    response.set("result", mapper.valueToTree(result));
                }
                writer.println(response);
            }
        }
    }

    private ObjectNode helpMessage() {
        ObjectNode node = mapper.createObjectNode();
        node.put("usage", "Send JSON lines like {\"tool\":\"listTools\"}");
        return node;
    }

    private interface ToolExecutor {
        Object execute(JsonNode arguments);
    }
}
