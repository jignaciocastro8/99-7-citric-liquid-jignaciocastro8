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






# **Second version (in English):**

Model aspects added or deleted:

- The interface **IUnit** is created, wich is implemented by **WildUnit** and **BossUnit** classes. Its function
is to separate the unit's behavior from the player's.

- The interface **IPlayer** is created to represent the player behavior. It is implemented by **Player** class
only.

- The **Board** class was deleted and replaced by a **BoardController** wich is explained later.

- The panelFactory package is created in boardPackage. The first contains classes related to the factory 
pattern that is implemented for panel creation, it uses a **IPanelFactory** interface that has the 
(abstract) method **createWithKey(int key)** and creates a panel with key as its id. The classes 
**TypePanelFactory** with Type the panel's type, implement this abstract method in the expected way.


- The charactersFactory package is created in gameCharacter package. This package contains classes related
to the factory pattern that is implemented for characters (player, wilds, bosses) creation, it uses
the **ICharacterFactory** that has the (abstract) method **create("player information")**. This method
is implemented by **WildFactory**, **BossFactory**. Besides, **PlayersFactory** implements **IPlayerFactory**
wich is another interface that implementes **ICharacterFactory**. This **IPlayerFactory** has method that
allow us to create more specialized player.

- The playerState package is created to put classes that represents a player state: **MovingState**, 
**WaitingOnPanelState**, **NeutralState** and **RecoveryState**. All this classes implements the 
**IPlayerState** with methods that enables to do a double dispatch execution to know the player state.

- GameController: On the controller package, the game controller is implemented. It is separated in 3
specialized classes that handles different structures of the game: **PlayerController**
, **BoardController**, **UnitController**. The name of this classes explains the part of the game that
deals with. Each one of this classes implements its corresponding interface **IPlayerController**
, **IBoardController** and **IUnitController** and has instance of the corresponding game data (player, 
panels and units). The principal class of this package is **GameController** which deals with 
the interaction of the previous controllers: move player, chapter and turn counters, initiate game,
turn owner and all that stuff. An important aspect of this part of the program is that **GameController**
implements, besides the corresponding **IGameInterface**, all the interface of the other controllers.
This allows **GameController** to encapsule the total control of the game and fit the implementation
of the **MediatorClass** and the test **MediatorTest**, wich was the principal reason to do it in that way.


- GameFlux: On the gameFlux controller a (incomplete) implementation of the game flux is created. It
has a principal class **Turn** that tries to fulfill the different turn phases. To do this, I took a 
state pattern aproach from the point of view of the turn, this is, the turn enters different phases.
the principal states are characterized for the game waiting for a player to make a decision. Here, we
have the interface **IWaitTurnState** that represent a general waiting state of the turn, and is 
implemented by: **BattleOrNotState** a class that is in charge of asking the player if she/he wants or not
to enter a battle, **EvdOrDefState** that asks the player if she/he wants to evade or def in a battle 
context, **NextPanelState** that ask the player which panel to follow when she/he lands on a panel with 
more than one next panel and **NeutralWaitState** that represent a neutral state trying to follow a null
object pattern. The common interface allows to do a double dispatch excution. 

- Mediator: this is a given class but i completed it in a way that it pass the test.


# **Execution instructions (Second version)**

Besides the instructions of the first version (The spanish version at the beggining of this documents),
we have new tests added that are explained here:

- **Factory tests** : Each factory has its own tests and basically test that the created object is the
correct one.

- **GameControllerTest** : Is a long class that tests all the methods of the controller package. 

- **TurnTest** : Tests the partial implementation of the turn phases.

# **Third version**

In this version some changes are made in order to fit some required patterns and fix problems of the
previous version. The view is implemented in a shallow way and the principal objective, actually be
able to play the game, is not fullfilled. But, changing a line in the program allows to move the 
players just increasing and decreasing the stars count until one of the player reaches the amount of
stars to win the game.

# **Implementations added**:

- **Observer pattern**:  The GameController object has three controllers that acts as an observer
that observes the model objects. Controllers classes implements oobverser interfaces and the game
objects, such as Player and Panel, implements observable interfraces.
- **View: ** We assume that the board is fixed by the program, the board is just a loop where the players
are putted on the corners. Also, there are not home panels with more than one next panel (in fact no panel
has more than one next panel) because the program can't deal with these case. There are 4 players  created
by the program and are fixed, the roll button start the turn (create a set a new phase) with the turn
owner of the moment. There are a label on the view that print a message refering to the game current
state.

# **Instructions**: 

-**Roll button**: Roll and moves the player owner.