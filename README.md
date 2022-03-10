# Sujet de projet
- Nous vous proposons la modélisation et la réalisation d’un jeu où un héros erre dans un labyrinthe en quête de réussir
une mission.

# Aperçu du jeu
- Le jeu est composé d’une carte qui représente le labyrinthe. La carte est constituée de cases, chaque case est reliée à
une ou plusieurs des autres cases.
- Le héros est un personnage particulier qui évolue dans ce labyrinthe et qui doit accomplir une quête. La quête est
associée à une case particulière du labyrinthe (inconnue au départ) et peut être variable : simplement atteindre la case,
amasser en plus une certaine quantité d’or, avoir rencontré un certain nombre de personnages, etc.
- Le héros est incarné par le joueur et c’est donc celui-ci qui, à travers une interface texte, choisit les actions du héros.
Au cours de son parcours du labyrinthe, le héros peut rencontrer des personnages ou des objets dans le labyrinthe.
- Le héros a la possibilité d’interroger les personnages qu’il rencontre. Ces personnages fournissent alors des indices à
propos de la quête du personnage. Ces indices peuvent par exemple indiquer la distance par rapport à la case objectif ou la direction à prendre pour l’atteindre au plus vite ou la position de la case elle-même, etc.
- Les indices ne sont pas nécessairement gratuits : par exemple les sphynx échangent un indice contre une bonne réponse à une énigme, tandis que les marchands vendent leurs indices contre de l’or. Quelques personnages altruistes donnent des indices gratuits. Il faudra cependant prendre garde aux fous qui se promènent dans le labyrinthe, lorsqu’ils sont interrogés ils énoncent des phrases qui ressemblent à des indices (mais n’en sont pas . . . ). Le héros ne sait pas forcément
à qui il a affaire . . .
- Parmi les objets que le héros peut ramasser, il peut par exemple y avoir des joyaux ou encore des parchemins sur
lesquels sont inscrits un indice. Le héros peut utiliser ces objets : les joyaux pour obtenir de l’or et les parchemins pour
en lire le contenu (il ne suffit pas de le ramasser pour en connaître le contenu).

## Préparation du plateau de jeu
- Comme la quête du héros est associée à une case particulière du labyrinbthe, il faut nécessairement que le labyrinthe
construit permette l’accès à ladite case. On mettra donc en oeuvre des algorithmes permettant de construire de
labyrinthes parfaits (2 algorithmes différents seront implémentés).

## Les règles du jeu
- A chaque tour, chaque personnage effectue une et une seule action. Par exemple le héros pourra choisir soit de se
déplacer, soit de rester sur place (et regarder autour de lui par exemple), soit d’interroger un autre personnage présent
sur la même case, soit de ramasser un objet parmi ceux disponibles, soit d’utiliser un objet qu’il possède, etc. A un moment donné, toutes les actions ne sont pas nécessairement possibles. Précisons que l’ensemble des personnages, et pas seulement le héros, peuvent effectuer des actions. Par exemple les fous ou les marchands peuvent eux aussi se déplacer, mais pas les sphynx.

## Fin du jeu
- Le jeu s’arrête une fois que le héros a réussi sa quête. La quête n’est pas connue du héros au départ, il l’apprend grâce aux indices qu’il récolte.
Comme décrit plus haut la quête d’un joueur est associée à une case du labyrinthe mais il ne suffit pas d’avoir atteint la case pour valider puisqu’il peut y avoir éventuellement d’autres défis à réussir pour gagner.

## Ouverture du jeu à des extensions
- Comme beaucoup de jeux à l’heure actuelle, il existe un version de base et des extensions.
- Ce qui est décrit dans ce sujet en terme de personnages et objets constitue la version de base. On devrait pouvoir
simplement ajouter des extensions. Typiquement un nouveau personnage ou un nouvel objet. A titre d’exemple, on
peut imaginer un personnage qui dépose des objets au fur et à mesure de ses déplacements.