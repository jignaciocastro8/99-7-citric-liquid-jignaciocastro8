<!-- 1.0.3-b1 -->
# 99.7% Citric Liquid

Base code for CC3002's *99.7% Citric Juice* Project.

The project consists in creating a (simplified) clone of the game **100% Orange Juice**
developed by [Orange_Juice](http://daidai.moo.jp) and distributed by 
[Fruitbat Factory](https://fruitbatfactory.com).

**Resumen**
Los archivos ejecutables son los *test*. Los test asociados a los characters del juego se organizaron 
en una clase abstracta *AbstractCharacterTest*, la cual contiene un método abstracto 
*CharacterInterface makeCharacter(...)* y métodos que testean las funcionalidades propias de un 
AbstractCharacter. De esta heredan las clases *PlayerTest*, *BossUnitTest* y *WildUnitTest*. los test
de BossUnit y WildUnit son practicamente igual pues no se han implementado aún las particularidades
de estas clases. 

**PlayerTest**: Testea funcionalidades básicas de un PLayer como AbstractCharacter. Además
testea acciones, hasta ahora, exclusivas a un Player como son el evento *Norma Clear*, que se testea
de forma random y determinista, y la modificación de stats. 

**WildUnitTest**: Testea funcionalidades básicas de un PLayer como AbstractCharacter. 

**BossUnitTest**: Testea funcionalidades básicas de un PLayer como AbstractCharacter.

Con respecto a la batallas, se creo el test BattleTest el cuál testea las funcionalidades que se 
ejecutan de igual manera para cualquier character como defender, evadir o atacar. En los tres casos
se generaron cantidades de ataque aleatorias para hacer los test. Para el caso de atacar se testearon
los 9 casos posibles de ganador y perdedor.

**BattleTest**: Testea las acciones básicas de una batalla. Para el caso de defender un ataque, sólo
se tomo en cuenta a Boss y Wild puesto que la decisión de que estrategia tomar frente a un ataque para
un Player aún no se ha implementado.

La implementación de los paneles es débilmente testeada, esto se debe a que no se han implementado a
cabalidad sus funciones. Si bien cada tipo de panel tiene su test correspondiente, en su mayoría sólo 
testean el constructor. La clase PanelTest, pensada con la idea de testear funcionalidades básicas de 
los paneles, cuenta con un testeo un poco mayor. Además, los paneles que modifican campos de 
characters testean estos efectos.

**PanelTest**: Testea la implementación de nextPanels.
**HomePanelTest**: Testea constructor y el efecto que genera este panel sobre un character.
**BonusPanelTest**: Testea constructor y el efecto que genera este panel sobre un character.
**DropPanelTest**: Testea constructor y el efecto que genera este panel sobre un character.