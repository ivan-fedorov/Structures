package com.maps;

import lombok.extern.java.Log;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Log
class MapOfMaps {

    Map<String, Map<String, List<String>>> cityMap;
    Map<String, List<String>> tmpMap;
    List<String> tmpList;

    MapOfMaps() {
        cityMap = new TreeMap<>();
    }

    void addData(String continent, String country, String city) {

        tmpMap = new TreeMap<>();
        tmpList = new LinkedList<>();
        if (cityMap.containsKey(continent)) {
            tmpMap = cityMap.get(continent);
            if (cityMap.get(continent).containsKey(country)) {
                tmpList = tmpMap.get(country);
            }
        }
        tmpList.add(city);
        tmpMap.put(country, tmpList);
        cityMap.put(continent, tmpMap);
    }

    void printMap() {
        String continent;
        for (Map.Entry<String, Map<String, List<String>>> entry : cityMap.entrySet()) {
            continent = entry.getKey();
            for (Map.Entry<String, List<String>> stringEntry : entry.getValue().entrySet()) {
                for (String s : stringEntry.getValue()) {
                    log.info(String.format("%s : %s : %s", continent, stringEntry.getKey(), s));
                }
            }
        }
    }

}
