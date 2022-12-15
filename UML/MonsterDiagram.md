```mermaid

classDiagram
    class Creature{
        getInitiative() int
        getAC() int
        getName() String
        getPassivePerception() int
    }
    <<Interface>> Creature

    class FactoryCreature{
        createMonster() Monster
        createHero() Hero
    }
    <<Interface>> FactoryCreature
    

    class Monster{
        getHP() int
        getLanguages() String
        getSenses() String
        getSpells() String
        getInfo() String
        savingThrow() int
        attackAction() String
        gainHP(int gained) void
        loseHP(int lost) void
    }
    <<Interface>> Monster
    Creature <|-- Monster

    class Hero {

    }
    <<Interface>> Hero
    Creature <|-- Hero

    class MonsterImpl {

    }
    Monster <|.. MonsterImpl

    class HeroImpl {

    }
    Hero <|.. HeroImpl

    class FactoryCreatureImpl {

    }
    FactoryCreature <|.. FactoryCreatureImpl
    FactoryCreatureImpl ..> MonsterImpl
    FactoryCreatureImpl ..> HeroImpl
