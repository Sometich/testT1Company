package ru.balayn.testt1company.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class FrequencyService {


    public Map<String, Integer> frequencyCounter(String word) {
        Map<String, Integer> resultCount = new HashMap<>();

        // Обрабатываем случай если строка пришла пустая или в качестве параметра передан null и возвращаем пустую Map
        if (word == null || word.isEmpty()) {
            return Map.of();
        }

        Arrays.stream(word.split(""))
                .forEach(a -> resultCount.put(a, resultCount.getOrDefault(a, 0) + 1));
        return resultCount;
    }
}
