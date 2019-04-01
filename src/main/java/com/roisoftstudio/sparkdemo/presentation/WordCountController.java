package com.roisoftstudio.sparkdemo.presentation;

import com.roisoftstudio.sparkdemo.logic.WordCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.split;

@RestController
public class WordCountController {

    @Autowired
    private WordCountService service;

    @GetMapping("/wordcount")
    public Map<String, Long> count(@RequestParam String words) {
        return service.getCount(asList(split(words)));
    }

    @GetMapping("/wordcountfile")
    public Map<String, Long> countWithFile() throws Exception {
        Path path = Paths.get(getClass().getClassLoader().getResource("data.txt").toURI());

        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return service.getCount(asList(split(data)));
    }
}