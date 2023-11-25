package ru.balayn.testt1company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.balayn.testt1company.service.FrequencyService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * REST контроллер для обработки запросов
 */
@RestController
public class FrequencyController {

    @Autowired
    FrequencyService frequencyService;

    /**
     * GET Метод контроллера считает частоту символов в строке
     * и в возвращает результат в виде JSON в виде <символ> : <частота>
     * @param input - исходная строка
     * @return возвращает частоту символов в строке
     */
    @GetMapping("/frequency")
    public Map<String, Integer> frequencyCounter(@RequestParam String input) {
        Map<String, Integer> result = frequencyService.frequencyCounter(input);
        return result.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }
}
