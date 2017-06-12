![test](https://github.com/RyanFleck/BattleCommander/blob/54d1960009d8b000c4429bbd3fd6693c40847e8e/core/assets/BCOMLOGO.png?raw=true)
## Simple strategy game built using LibGDX.

*Battle Commander* is a top-down, turn-based tactical wargame. Built as a tribute to games like Advance Wars, BCOM will eventually have an equivalent set of features, namely a variety of levels and terrain, unit types, bases and a story. Currently BCOM is in an experimental stage of development, so the developers can get to know the libgdx engine. Originally, BCOM was going to be built in GameMaker, but the developers wished to excersize the java that had been learned in Software Engineering and Computer Science courses.

Concept, design and artwork by Ryan Fleck. Programmed by Saimoon Azad and Ryan Fleck. Sound files courtesy of [freesound.org](https://www.freesound.org).

Download latest .jar for testing here: **[BattleCommander.jar](https://github.com/RyanFleck/BattleCommander/releases)**

**Current features:**
- Pannable map, using arrow keys.
- Soldier sprite, movable using WASD.

**Next release targets:**

1. Click-based commands:
   * Unit selection.
   * Unit movement.
   * Unit actions, attack and resupply.
  
2. Unit interface properly outfitted.

3. Soldier class implemented:
   * Animation when moving to new tile.
   * Blink when selected.
   * Able to be selected and moved with mouse.
  
**Future releases:**
- More units.
- Attacking.
- Better UI.
- Animated map.
- Enemy AI.
- *LAN* multiplayer.

## Project goals:

Efficiency:
- Min spec goal: Run at 60hz on slowest common machines, i.e. mobile celerons like 2955U.
- Make clever design choices, namely a common rendering queue and good resource management.

Reliability:
- Crashing in the middle of a match with a friend sucks. Clear code will help this project be as stable as possible.

Maintainability:
- Write minimal, but useful, documentation.
- Follow code design guidelines provided by ID SOFTWARE. 

Reusability:
- Hopefully, once this title is finished, some of the resources could be potentially re-used for a successor.

