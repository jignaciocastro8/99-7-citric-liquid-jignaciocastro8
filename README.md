<!-- 1.0.3-b1 -->
# 99.7% Citric Liquid

Base code for CC3002's *99.7% Citric Juice* Project.

The project consists in creating a (simplified) clone of the game **100% Orange Juice**
developed by [Orange_Juice](http://daidai.moo.jp) and distributed by 
[Fruitbat Factory](https://fruitbatfactory.com).

# **Funcionamiento y lógica del programa**

En este documento entenderemos por character al conjunto de los personajes del juego, es decir, players,
wild y boss units. Para cada uno de estos se creo su clase asociada, *Player*, *WildUnit* y *BossUnit*.
 
Los characters se organizan base a una clase abstracta *AbstractCharacter* de la cual hereda *Player*
y *AbstractUnit*, siendo esta última una clase abstracta que representa las entidades que no son 
controladas desde fuera del programa y por lo tanto tienen un comportamiento *random* (podría no serlo 
pero se toma como supuesto). La clase *Player* tiene como fin representar a los personajes del juego 
que pueden ser controlados desde fuera lo cual nos dice que sus respuestas a distintos eventos vendrán
desde fuera del programa. Por lo anterior las clases *WildUnit* y *BossUnit* heredan de 
*AbstractUnit*, esto facilita la adición de nuevos units. La presencia de *AbstracUnit* tiene como fin 
mantener este comportamiento *random* para todos los units.

Las clases *AbstractCharacter* y *Player* implementan la interfaz *CharacterInterface*. En esta se 
incluyen los métodos que todo character debe poder ejecutar, desde modificar *stars* y *wins* hasta 
poder hacer un *roll* (lanzar los dados). La interfaz *BattleInterface*, que guarda los métodos 
asociados al desarrollo de una batalla, es implementada por *Player*, *WildUnit* y *BossUnit*. La 
creación de una interfaz que controle la acción de una batalla permite la independencia de este evento 
del resto del programa. Otro aspecto positivo de esta interfaz es poder hacer *Double Dispatch* entre 
los personajes al momento de vencer o se vencido. 

Por otro lado, como sólo los players pueden modificar sus stats, los métodos que ejecutan estas 
instrucciones sólo se encuentran en la clase *Player*.

En cuanto a los paneles, se creo la clase abstracta *Panel* cuyo método abstracto más notable es 
*void activatedBy(Player player)*. De esta heredan las clases que representan a todos los paneles, 
cuyos nombres son de la forma *TypePanel* (Ej: HomePanel, DrawPanel). La clase *Panel* implementa la 
interfaz *PanelInterface*, esta contiene métodos que permiten agregar jugadores al panel, agregar 
paneles siguientes y hacer que el panel sea activado por algún jugador desencadenando el efecto 
adecuado dependiendo del tipo del panel. Este último método sólo se ha implementado para *HomePanel*, 
*BonusPanel* y *DropPanel*. La separación de los paneles en distintas clases simplifica la 
implementación del método mencionado puesto que el efecto que este tiene depende del tipo de panel. 
Además, facilita la adición de nuevos tipos de paneles.

# **Supuestos**
- Los wild y boss units serán controlados desde dentro del programa a través de resultados random.
- Siguiendo el supuesto anterior, los wild y boss deciden al azar entre defender y evadir.
- Todos los personajes son capáces de evadir, defender y atacar.
- Todos los personajes evaden y defienden de la misma forma en una batalla.
- Un player puede cumplir con los requisitos para subir de norma pero no hacerlo hasta que logre
llegar a su HomePanel.
- Cada jugador posee un HomePanel.
- Cada HomePanel sabe quien es su dueño.

# **Instrucciones de ejecución**

Los archivos ejecutables son los *test*. Los test asociados a los characters del juego se organizaron 
en una clase abstracta *AbstractCharacterTest*, la cual contiene un método abstracto 
*CharacterInterface makeCharacter(...)* y métodos que testean las funcionalidades propias de un 
AbstractCharacter. De esta heredan las clases *PlayerTest*, *BossUnitTest* y *WildUnitTest*. los test
de BossUnit y WildUnit son practicamente igual pues no se han implementado aún las particularidades
de estas clases. 

- **PlayerTest**: Testea los métodos de CharacterInterface. Además
testea acciones, hasta ahora, exclusivas a un Player como son el evento *Norma Clear*, que se testea
de forma random y determinista, y la modificación de stats. 

- **WildUnitTest**: Testea los métodos de *CharacterInterface*. 

- **BossUnitTest**: Testea los métodos de *CharacterInterface*.

Con respecto a la batallas, se creo la clase BattleTest la cuál testea las funcionalidades comunes 
para cualquier character como defender, evadir o atacar que se encuentran en BattleInterface. En los 
tres métodos mencionados se generaron cantidades de ataque aleatorias para hacer los test. Para el 
caso de atacar se testearon los 9 casos posibles de ganador y perdedor.

- **BattleTest**: Testea las acciones básicas de una batalla. Para el caso de recibir un ataque, sólo
se tomo en cuenta a Boss y Wild puesto que la decisión de que estrategia tomar frente a un ataque para
un Player aún no se ha implementado. Aún así, el método que realiza esto en la clase Player quedó listo
para ser completado.

La implementación de los paneles es débilmente testeada, esto se debe a que no se han implementado a
cabalidad sus funciones. Si bien cada tipo de panel tiene su test correspondiente, en su mayoría sólo 
testean el constructor. La clase PanelTest, pensada con la idea de testear funcionalidades básicas de 
los paneles, cuenta con un testeo un poco mayor. Además, los paneles que modifican campos de 
characters testean estos efectos.

- **PanelTest**: Testea la implementación de nextPanels.

- **HomePanelTest**: Testea constructor y el efecto que genera este panel sobre un character.

- **BonusPanelTest**: Testea constructor y el efecto que genera este panel sobre un character.

- **DropPanelTest**: Testea constructor y el efecto que genera este panel sobre un character.

- **DrawPanelTest**: Testea constructor.

- **EncounterPanelTest**: Testea constructor.

- **NeutralPanelTest**: Testea constructor.