# Conway's Game of Life

I developed this program as a course assignment when I was studying non-linear dynamics and chaos theory during my undergraduate studies.

<img src="https://github.com/kayhan-momeni-1995/Game-of-life/blob/main/game%20of%20life%20screenshot.png?raw=true" alt="drawing" style="width:200px;"/>

The Game of Life, is a dynamical system represented by cellular automaton. There are 4 rules governing the system:
1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

This program is a 20 by 20 version of this system that I implemented. After hitting the "start" button, the system starts over the initial conditions and the dynamical evolution of the system is visualized, generation by generation. To change the "initial condition" of the system, edit (fill in with 0's and 1's) the 2D array "board" in the file "Chaos.java" (line 17.)


