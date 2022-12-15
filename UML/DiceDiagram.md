```mermaid

classDiagram
    class Die {
        roll() int
        rollAdvantage() int
        rollDisadvantage() int
    }
    <<Interface>> Die

    class FactoryDie {
        createD100() Die
        createD20() Die
        createD12() Die
        createD10() Die
        createD8() Die
        createD6() Die
        createD4() Die
    }
    <<Interface>> FactoryDie
    Die <.. FactoryDie

    class DieImpl {

    }
    Die <|.. DieImpl

    class FactoryDieImpl {

    }
    FactoryDie <|.. FactoryDieImpl
    DieImpl <.. FactoryDieImpl
    
