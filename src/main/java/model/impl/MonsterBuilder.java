package model.impl;

import model.api.Monster;

public class MonsterBuilder implements StepStr, StepDex, StepCons, StepInt, StepWis, StepCha, FinalStep {

    

    private String name;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public StepStr name(final String name) {
        this.name = name;
        return this;
    }

    @Override
    public Monster build() {
        /*TODO */
        return null;
    }


    @Override
    public FinalStep charisma(int charisma) {
        this.charisma = charisma;
        return this;
    }

    @Override
    public StepCha wisdom(int wisdom) {
        this.wisdom = wisdom;
        return this;
    }




    @Override
    public StepWis intelligence(int intelligence) {
        this.intelligence = intelligence;
        return this;
    }

    @Override
    public StepInt constitution(int constitution) {
        this.constitution = constitution;
        return this;
    }

    @Override
    public StepCons dexterity(int dexterity) {
        this.dexterity = dexterity;
        return this;
    }


    @Override
    public StepDex strength(int strength) {
        this.strength = strength;
        return this;
    }

}

interface StepStr {
    StepDex strength(final int strength);
}

interface StepDex {
    StepCons dexterity(final int dexterity);
}

interface StepCons {
    StepInt constitution(final int constitution);
}

interface StepInt {
    StepWis intelligence(final int intelligence);
}

interface StepWis {
    StepCha wisdom(final int wisdom);
}

interface StepCha {
    FinalStep charisma(final int charisma);
}

interface FinalStep {
    Monster build();
}