package com.example.welthia.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import com.example.welthia.dto.AssessmentRequest;
import com.example.welthia.dto.PreAssessment;
import com.example.welthia.service.AiService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OpenAIService implements AiService {

   private final ChatModel chatModel;
   private final ObjectMapper objectMapper;

    public OpenAIService(ChatModel chatModel, ObjectMapper objectMapper) {
        this.chatModel = chatModel;
        this.objectMapper = objectMapper;
    }

    @Override
    public PreAssessment generarPreAssessment(AssessmentRequest request) {
        
        String jsonSchema = obtenerEsquemaJson(PreAssessment.class);

        String template = """
            Eres un experto en bienestar, salud y hábitos. Tu tarea es generar un pre-diagnóstico
            y recomendaciones de hábitos de bienestar altamente personalizadas, basándote
            en los datos del usuario proporcionados a continuación.

            --- DATOS DEL USUARIO ---
            Edad: {age} años, Sexo: {userSex}
            IMC: {weightKg}/{heightM}²
            Sueño: {sleepTime} a {wakeTime}. Despertares: {nightAwakenings}. Dificultad al despertar: {wakeDifficulty}.
            Ejercicio: {activityLevel}, {exerciseFrequencyPerWeek} veces/semana.
            Hábitos: Alcohol: {drinksAlcohol} ({alcoholFrequency}). Tabaco: {smokesTobacco} ({tobaccoUnitsPerDay} unidades/día).
            Dieta: Frutas: {fruitServingsDay} porciones, Verduras: {vegetableServingsDay} porciones. Comida procesada: {processedFoodWeek} veces/semana.
            Estrés: Nivel {stressLevel}/10. Sentimiento hoy: {endOfDayFeeling}.

            --- REQUISITOS DE RESPUESTA ---
            1. Genera un análisis conciso y profesional.
            2. Identifica el área de enfoque principal (e.g., "Higiene del Sueño", "Nutrición", "Gestión del Estrés").
            3. Crea 3 a 5 recomendaciones de hábitos de la subclase `RecomendacionHábito`.
            4. **El formato de salida DEBE ser JSON**, siguiendo el esquema proporcionado en {format}.
            """;
        
        Map<String, Object> modelParams = new HashMap<>();
        modelParams.put("age", request.age());
        modelParams.put("userSex", request.userSex());
        modelParams.put("weightKg", String.format("%.2f", request.weightKg()));
        modelParams.put("heightM", String.format("%.2f", request.heightM()));
        modelParams.put("sleepTime", request.sleepTime());
        modelParams.put("wakeTime", request.wakeTime());
        modelParams.put("nightAwakenings", request.nightAwakenings());
        modelParams.put("wakeDifficulty", request.wakeDifficulty());
        modelParams.put("activityLevel", request.activityLevel());
        modelParams.put("exerciseFrequencyPerWeek", request.exerciseFrequencyPerWeek());
        modelParams.put("drinksAlcohol", request.drinksAlcohol() ? "Sí" : "No");
        modelParams.put("alcoholFrequency", request.alcoholFrequency());
        modelParams.put("smokesTobacco", request.smokesTobacco() ? "Sí" : "No");
        modelParams.put("tobaccoUnitsPerDay", request.tobaccoUnitsPerDay());
        modelParams.put("fruitServingsDay", request.fruitServingsDay());
        modelParams.put("vegetableServingsDay", request.vegetableServingsDay());
        modelParams.put("processedFoodWeek", request.processedFoodWeek());
        modelParams.put("stressLevel", request.stressLevel());
        modelParams.put("endOfDayFeeling", request.endOfDayFeeling());
        
        PromptTemplate promptTemplate = new PromptTemplate(template);

        modelParams.put("age", request.age());

        modelParams.put("endOfDayFeeling", request.endOfDayFeeling());
        
        modelParams.put("jsonSchema", jsonSchema); 

        Prompt prompt = promptTemplate.create(modelParams);

        ChatResponse chatResponse = chatModel.call(prompt);

        String jsonContent = chatResponse.getResult().getOutput().getText();

        try {
            return objectMapper.readValue(jsonContent, PreAssessment.class);
        } catch (Exception e) {
            System.err.println("Error parseando JSON de OpenAI: " + jsonContent);
            throw new RuntimeException("Error al procesar la respuesta de IA", e);
        }
    }
    

    private <T> String obtenerEsquemaJson(Class<T> clazz) {
        try {
            return clazz.toGenericString(); 
        } catch (Exception e) {
            return "{\"error\": \"No se pudo generar el esquema para la IA\"}";
        }
    }
}
