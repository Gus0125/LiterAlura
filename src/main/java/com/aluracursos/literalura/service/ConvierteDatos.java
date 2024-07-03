package com.aluracursos.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos implements IConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            System.out.println("JSON recibido: " + json); // Imprime el JSON recibido
            T datos = objectMapper.readValue(json, clase);
            System.out.println("Objeto mapeado: " + datos); // Imprime el objeto mapeado
            return datos;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
