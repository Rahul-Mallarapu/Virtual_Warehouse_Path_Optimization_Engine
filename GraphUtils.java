package com.example.godown_project;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class GraphUtils {

    public static Map<String, List<String>> parseAdjacencyData(String jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonData, new TypeReference<Map<String, List<String>>>(){});
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse adjacency data", e);
        }
    }
}

