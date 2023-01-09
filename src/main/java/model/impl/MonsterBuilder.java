package model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.api.Monster.Element;
import model.api.Monster.Stat;

public class MonsterBuilder {
    private final String name;
    private int ac;
    private final Map<Stat, Integer> stats = new HashMap<>();
    private final Map<Stat, Integer> savingThrows = new HashMap<>();
    private final Map<Element, Double> resistances = new HashMap<>();
    private int hpTotal;
    private String info; //Comprehends movement, senses, languages, skills, special attacks
    private final List<String> actions = new ArrayList<>();
    private int numberOfLegendaryActions;
    private final Map<String, Integer> legendaryActions = new HashMap<>();


}