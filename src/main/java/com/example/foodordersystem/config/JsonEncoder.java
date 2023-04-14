package com.example.foodordersystem.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

@Configuration
public class JsonEncoder implements Encoder.Text<Object> {

    @Override // Initialization does nothing
    public void init(EndpointConfig config) {}

    @Override
    public String encode(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override // Do nothing to destroy
    public void destroy() {}
}
