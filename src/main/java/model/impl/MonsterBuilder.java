package model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.api.Monster;
import model.api.Monster.Element;
import model.api.Monster.Stat;

public class MonsterBuilder {
    private final String name;
    private int ac = 0;
    private int initiative = 0;
    private final Map<Stat, Integer> stats = new HashMap<>();
    private final Map<Stat, Integer> savingThrows = new HashMap<>();
    private final Map<Element, Double> resistances = new HashMap<>();
    private int hpTotal = 0;
    private String info; //Comprehends movement, senses, languages, skills, special attacks
    private final List<String> actions = new ArrayList<>();
    private int numberOfLegendaryActions = 0;
    private final Map<String, Integer> legendaryActions = new HashMap<>();

    public MonsterBuilder(final String name) {
        this.name = name;
    }

    public MonsterBuilder ac(final int ac) {
        this.ac = ac;
        return this;
    }

    public MonsterBuilder initiative(final int initiative) {
        this.initiative = initiative;
        return this;
    }

    public MonsterBuilder stats(final Map<Stat, Integer> stats) {
        this.stats.putAll(stats);
        return this;
    }

    public MonsterBuilder savingThrows(final Map<Stat, Integer> savingThrows) {
        this.savingThrows.putAll(savingThrows);
        return this;
    }

    public MonsterBuilder resistances(final Map<Element, Double> resistances) {
        this.resistances.putAll(resistances);
        return this;
    }

    public MonsterBuilder hpTotal(final int hpTotal) {
        this.hpTotal = hpTotal;
        return this;
    }

    public MonsterBuilder info(final String info) {
        this.info = info;
        return this;
    }

    public MonsterBuilder actions(final List<String> actions) {
        this.actions.addAll(actions);
        return this;
    }

    public MonsterBuilder numberOfLegendaryActions(final int numberOfLegendaryActions) {
        this.numberOfLegendaryActions = numberOfLegendaryActions;
        return this;
    }

    public MonsterBuilder legendaryActions(final Map<String, Integer> legendaryActions) {
        this.legendaryActions.putAll(legendaryActions);
        return this;
    }

    public Monster build() {
        if (this.ac == 0 || this.stats.isEmpty() || this.savingThrows.isEmpty() || this.resistances.isEmpty() ||
            || this.hpTotal == 0 || this.info.isEmpty() || this.actions.isEmpty() || this.numberOfLegendaryActions == 0 || this.legendaryActions.isEmpty()) {
                throw new IllegalStateException();
            }
        return new MonsterImpl(name, ac, stats, savingThrows, resistances, hpTotal, info, actions, numberOfLegendaryActions, legendaryActions, initiative);
    }

    private class MonsterImpl implements Monster {

        private final String name;
        private final int ac;
        private final int initiative;
        private Map<Stat, Integer> stats;
        private Map<Stat, Integer> savingThrows;
        private final Map<Element, Double> resistances;
        private final int hpTotal;
        private int hpCurrent;
        private final String info; //Comprehends movement, senses, languages, skills, special attacks
        private final List<String> actions;
        private final int numberOfLegendaryActions;
        private final Map<String, Integer> legendaryActions;

        private MonsterImpl(final String name, final int ac, final Map<Stat, Integer> stats, final Map<Stat, Integer> savingThrows, 
                        final Map<Element, Double> resistances, final int hpTotal, final String info, final List<String> actions,
                        final int numberOfLegendaryActions, final Map<String, Integer> legendaryActions, final int initiative) {
            this.name = name;
            this.ac = ac;
            this.stats = stats;
            this.savingThrows = savingThrows;
            this.stats = Map.copyOf(stats);
            this.savingThrows = Map.copyOf(savingThrows);
            this.resistances = Map.copyOf(resistances);
            this.hpTotal = hpTotal;
            this.hpCurrent = hpTotal;
            this.info = info;
            this.actions = List.copyOf(actions);
            this.numberOfLegendaryActions = numberOfLegendaryActions;
            this.legendaryActions = Map.copyOf(legendaryActions);
            this.initiative = initiative;
        }

        @Override
        public int getInitiative() {
            return this.initiative + Die.D20.roll();
        }

        @Override
        public int getAC() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public int getPassivePerception() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public String getName() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int getHP() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public String getLanguages() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getSenses() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public String getInfo() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public int savingThrow(Stat statistic, Optional<Boolean> condition) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public List<String> attackAction(Optional<Boolean> condition) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public void gainHP(int gained) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void loseHP(int lost, double resistance) {
            // TODO Auto-generated method stub
            
        }
        
    }



}