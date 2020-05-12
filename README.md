<!-- 1.0.3-b1 -->
# 99.7% Citric Liquid

Base code for CC3002's *99.7% Citric Juice* Project.

The project consists in creating a (simplified) clone of the game **100% Orange Juice**
developed by [Orange_Juice](http://daidai.moo.jp) and distributed by 
[Fruitbat Factory](https://fruitbatfactory.com).

**Resumen: **
Los archivos ejecutables son los *test*. Los test asociados a los characters del juego se organizaron 
en una clase abstracta *AbstractCharacterTest* la cual contiene un método abstracto 
*CharacterInterface makeCharacter(...)* y métodos que testean las funcionalidades propias de un 
AbstractCharacter. De esta heredan las clases *PlayerTest*, *BossUnitTest* y *WildUnitTest*. los test
de BossUnit y WildUnit son practicamente igual pues no se han implementado aún las particularidades
de estas clases. 

**PlayerTest**: Testea funcionalidades básicas de un PLayer como AbstractCharacter. Además
testea acciones, hasta ahora, exclusivas a un Player como son el evento *Norma Clear*, que se testea
de forma random y determinista, y la modificación de stats. 

**WildUnitTest**: Testea funcionalidades básicas de un PLayer como AbstractCharacter. 

**BossUnitTest**: Testea funcionalidades básicas de un PLayer como AbstractCharacter.