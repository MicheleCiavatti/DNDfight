package model.impl;

import java.time.temporal.ValueRange;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import control.api.Stat;
import model.api.Monster;

/**Step builder for creating a {@link Monster} */
public class MonsterBuilder implements StepAc, StepInitiative, StepPerception, StepStr, StepDex, StepCons, StepInt, StepWis, StepCha, StepHP, 
StepAtt, StepSenses, StepLanguages, StepInfo, StepFinal {

    private static final int MIN_STAT = -5;
    private static final int MAX_STAT = 10;

    private final String name;
    private int ac;
    private int initiative;
    private int passivePerception;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int hp;
    private List<String> attacks;
    private String senses;
    private String languages;
    private String info;


    /**Constructor represents the first step of the builder.
     * The next step is ac().
    */
    public MonsterBuilder(final String name) {
        this.name = name;
    }

    @Override
    public Monster build() {
        return new MonsterImpl(this.name, this.ac, this.initiative, this.passivePerception, this.strength, this.dexterity,
                                this.constitution, this.intelligence, this.wisdom, this.charisma, this.hp, this.attacks, 
                                this.senses, this.languages, this.info);
    }

    @Override
    public StepFinal info(final String info) {
        this.info = info;
        return this;
    }

    @Override
    public StepInfo languages(final String languages) {
        this.languages = languages;
        return this;
    }

    @Override
    public StepLanguages senses(final String senses) {
        this.senses = senses;
        return this;
    }

    @Override
    public StepSenses attacks(final List<String> attacks) {
        Objects.requireNonNull(attacks);
        this.attacks = List.copyOf(attacks);
        return this;
    }

    @Override
    public StepAtt hp(final int hp) {
        if (hp <= 0) {
            throw new IllegalArgumentException();
        }
        this.hp = hp;
        return this;
    }

    @Override
    public StepHP charisma(final int charisma) {
        checkStat(charisma);
        this.charisma = charisma;
        return this;
    }

    @Override
    public StepCha wisdom(final int wisdom) {
        checkStat(wisdom);
        this.wisdom = wisdom;
        return this;
    }

    @Override
    public StepWis intelligence(final int intelligence) {
        checkStat(intelligence);
        this.intelligence = intelligence;
        return this;
    }

    @Override
    public StepInt constitution(final int constitution) {
        checkStat(constitution);
        this.constitution = constitution;
        return this;
    }

    @Override
    public StepCons dexterity(final int dexterity) {
        checkStat(dexterity);
        this.dexterity = dexterity;
        return this;
    }

    @Override
    public StepDex strength(final int strength) {
        checkStat(strength);
        this.strength = strength;
        return this;
    }

    @Override
    public StepStr passivePerception(final int passivePerception) {
        this.passivePerception = passivePerception;
        return this;
    }

    @Override
    public StepPerception initiative(final int initiative) {
        this.initiative = initiative;
        return this;
    }

    @Override
    public StepInitiative ac(final int ac) {
        this.ac = ac;
        return this;
    }

    private void checkStat(final int stat) {
        if (!ValueRange.of(MIN_STAT, MAX_STAT).isValidIntValue(stat)) {
            throw new IllegalArgumentException();
        }
    }



    private class MonsterImpl implements Monster {

        private final String name;
        private final int ac;
        private final int initiative;
        private final int passivePerception;
        private final int strength;
        private final int dexterity;
        private final int constitution;
        private final int intelligence;
        private final int wisdom;
        private final int charisma;
        private final int totalHP;
        private int currentHP;
        private final List<String> attacks;
        private final String senses;
        private final String languages;
        private final String info;
        
        public MonsterImpl(final String name, final int ac, final int initiative, final int passivePerception, final int strength,
                            final int dexterity, final int constitution, final int intelligence, final int wisdom, final int charisma,
                            final int hp, final List<String> attacks, final String senses, final String languages, final String info) {
            this.name = name;
            this.ac = ac;
            this.initiative = initiative;
            this.passivePerception = passivePerception;
            this.strength = strength;
            this.dexterity = dexterity;
            this.constitution = constitution;
            this.intelligence = intelligence;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.totalHP = hp;
            this.currentHP = hp;
            this.attacks = List.copyOf(attacks);
            this.senses = senses;
            this.languages = languages;
            this.info = info;
        }

        @Override
        public int getInitiative() {
            return this.initiative;
        }

        @Override
        public int getAC() {
            return this.ac;
        }

        @Override
        public int getPassivePerception() {
            return this.passivePerception;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public int getHP() {
            return this.currentHP;
        }

        @Override
        public String getLanguages() {
            return this.languages;
        }

        @Override
        public String getSenses() {
            return this.senses;
        }

        @Override
        public String getInfo() {
            return this.info;
        }

        @Override
        public void gainHP(int gained) {
            this.currentHP += gained;
            if (this.currentHP > this.totalHP) {
                this.currentHP = this.totalHP;
            }
        }

        @Override
        public void loseHP(int lost, double resistance) {
            //TODO
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
        
    }

}

interface StepAc {
    StepInitiative ac(final int ac);
}

interface StepInitiative {
    StepPerception initiative(final int initiative);
}

interface StepPerception {
    StepStr passivePerception(final int passivePerception);
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
    StepHP charisma(final int charisma);
}

interface StepHP {
    StepAtt hp(final int hp);
}

interface StepAtt {
    StepSenses attacks(final List<String> attacks);
}

interface StepSenses {
    StepLanguages senses(final String senses);
}

interface StepLanguages {
    StepInfo languages(final String languages);
}

interface StepInfo {
    StepFinal info(final String info);
}

interface StepFinal {
    Monster build();
}