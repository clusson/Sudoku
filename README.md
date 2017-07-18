# Sudoku

## Android Application 

- LevelChoice, permet de choisir le niveau de la grille de Sudoku
- L’adapteur (**MyAdapter.java**) permet d’afficher le numéro, le niveau et le pourcentage complété
- Dessin de la grille du sudoku + remplissage des numéro en fonction du .txt passé en paramètre
- Gestion des interactions avec *Action_DOWN* et *Action_UP*
- La classe **GridDraw.java** sert de modèle afin de réaliser la grille de sudoku.
- Les classes **Cell.java** et **CellNumber.java** sont utilisées pour dessiner les cases, et les numéros.

#### Todo :

- Timer (affiche le temps passé sur une partie)
- Database avec SQLite + Pourcentage réalisé d'une partie
