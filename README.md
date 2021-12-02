# projet-dev-genie-logiciel-2021-22-seasons-lbh : PARTIE TER

![Game seasons cover](https://user-images.githubusercontent.com/43116179/143578650-f1aed80a-3e71-4ec8-90ff-1addf65dae2e.png)


## Participant :
| *Nom et Prenom* |
| ------ |
|Belhassen Mohamed|

---
___

## Game Rules:
we keep all the rules implimented in first part **except**

- the Player can invoke a Card per round ( so we can easily evaluate and mesure the effect of this Card in the Game)
- the can be played with only two players 

---
___

## IAs to be implemented:

**GARANTIE** : our garanted IA is A multi-strategic IA :
- He switches his current strategy depends on the round state, so after every round our guaranteed IA well evaluate the current situation and try to apply the most relevant strategy to win the Game.
- We implemented our IA like a State Machine. So every round he gets an inputs, so he can evaluate them .then, as an output , he gives as a new strategy 
- 
**AMBITIEUSE** :   our AMBITIEUSE IA is based in **PLANNING** concept :
- we have to pick a GOAL and make several turns in order to reach it . so is not just about the next step. we need to look ahead several steps in order to know what the first
action .
- to implement this concept we will use the **Monte Carlo Tree Search**.




