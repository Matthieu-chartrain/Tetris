# Tetris
Projet personnel réalisé en collaboration avec Sylvain Frediani, en JAVA.

## Installation
Vous devez avoir un IDE (Integrated Development Environment) JAVA pour faire fonctionner ce programme. De mon côté, je vais utiliser Eclipse à titre d'exemple :
- Téléchargez le code sous format ZIP
- Ouvrez Eclipse IDE et créer un nouveau projet JAVA
- Faites un clic droit sur le nom de votre projet puis "Importer"
- Sélectionner le type "General" -> "Archive File"
- Sélectionner le code que vous avez télécharger en format .zip dans la case "From archive file". Un nouveau dossier nommé "Tetris-master" devrait apparaitre dans votre projet.
- Sélectionner le dossier "src" et "bin" de "Tetris-master" et déplacer les dans le dossier src du projet.
- Renommer les packages "src.Forme" en "Forme" et "src.Main" en "Main"
- Faites un clic droit sur le projet, "Run As" -> "Java Application"

Vous pouvez dès à présent jouer à Tetris.

## Principe de jeu

Le but du jeu est d'effectuer des lignes pleines avec les pièces (nommées Tetriminos) qui chutent. Quand une ligne est effectuée, elle est supprimée. Si les Tetriminos arrivent tout en haut de la grille de jeu, le joueur perd la partie.

## Contrôle
Utiliser les flèches et "Q", "D" pour jouer.
- Flèche de gauche ← : Déplace le Tetrimino d'une case vers la gauche
- Flèche de droite → : Déplace le Terminino d'une case vers la droite
- Flèche du bas ↓ : Accélère la chute du Tetrimino
- Flèche du haut ↑ : Pose instantannement le Tetrimino tout en bas 
- Q : Tourne le Tetrimino de 90° vers la gauche
- D : Tourne le Tetrimino de 90° vers la droite

## Fabriqué avec
- JAVA - Langage
- Eclipse - IDE

## Auteurs
- Matthieu Chartrain
- Sylvain Frediani
