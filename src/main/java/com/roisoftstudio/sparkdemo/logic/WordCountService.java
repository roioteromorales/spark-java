package com.roisoftstudio.sparkdemo.logic;

import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WordCountService {

    @Autowired
    private JavaSparkContext sc;

    public Map<String, Long> getCount(List<String> wordList) {
        return sc.parallelize(wordList).countByValue();
    }

}