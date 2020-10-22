# icosian-game
Definition: A Hamiltonian cycle on graph G(V,E) is a cycle which visits each vertex exactly once. 

This puzzle was created in 1856 by William Hamilton. He attempted to market a game where players try to find a Hamiltonian cycle on a planar graph of a dodecahedron. The game was very boring and was a major flop, selling very poorly. However, Hamiltonian cycles do present an interesting mathematical problem.

This program finds a random Hamiltonian cycle on the planar graph of the dodecahedron. My algorithm is a fairly naive approach, using an iterative depth-first-search to find every cycle for a given a vertex. A fun fact which helped direct my choice of algorithm: there is no polynomial algorithm which can find a Hamiltonian cycle. Then we try to find a Hamiltonian path out of all the possible paths. Since this graph is so small (20 vertices), this is a perfectly fine algorithm. An interesting and more efficient algorithm can be found here: https://link.springer.com/article/10.1186/s40064-016-2746-8. To run this program, simply compile and run "java Icosian" in the terminal.
