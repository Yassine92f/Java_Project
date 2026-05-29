# Catalogue Console

## Membres du groupe

- BELGHAZI Smain
- FATHI Yassine
- RAVEENDRAN Thirisan

## Description

Application console Java Maven permettant de manipuler un catalogue de produits et des commandes avec les lambdas et l'API Stream.

## Fonctionnalités

- Affichage des produits
- Filtrage
- Transformation
- Tri
- Distinct
- Pagination
- Calculs avec reduce
- Calculs avec mapToDouble
- Commandes avec flatMap
- Collecte vers Map
- Démonstration parallelStream

## Gitflow

On a utilisé Gitflow pour organiser le projet :

- `main` : la version finale et stable
- `develop` : la branche où on regroupe le travail validé
- `feature/*` : une branche par fonctionnalité ou par personne, fusionnée dans develop avec une pull request

On n'a jamais codé directement sur main. Chacun travaillait sur sa branche feature puis on fusionnait dans develop.

## Lancer le projet

```bash
mvn clean compile
mvn test
mvn package
```

Ensuite on lance la classe `fr.ecole.tp.Main`.

## Choix techniques

**Pourquoi utiliser filter**
filter sert à garder seulement les produits qui respectent une condition (un Predicate), par exemple les produits en promo ou ceux à plus de 100 €. Ça évite de faire des if dans des boucles.

**Pourquoi utiliser map**
map transforme chaque élément en autre chose. Par exemple un produit en son nom, ou un nom en majuscules. Le nombre d'éléments ne change pas, juste leur contenu.

**Pourquoi utiliser flatMap**
flatMap on l'a utilisé pour les commandes. Chaque commande contient une liste de lignes, donc avec un simple map on aurait une liste de listes. flatMap aplatit tout pour avoir une seule liste de produits.

**Différence entre reduce et mapToDouble().sum()**
Les deux calculent le prix total du catalogue. reduce additionne les valeurs une par une avec une fonction (ici Double::sum). mapToDouble().sum() fait pareil mais c'est plus simple à écrire et un peu plus rapide, parce qu'on travaille directement avec des double et pas des Double (pas de conversion à faire).

**Limite de parallelStream**
parallelStream découpe le travail sur plusieurs threads, donc ça peut aller plus vite sur de grosses listes. Mais sur des petites listes ou des calculs simples, c'est souvent plus lent parce que gérer les threads coûte du temps. Et il ne faut pas modifier une liste externe dans un parallelStream, sinon ça donne des résultats faux.

## Répartition du travail

- Thirisan : les classes du modèle (Produit, Client, LigneCommande, Commande) et la DataFactory avec les données.
- Yassine : les traitements Stream (filtres, tris, calculs, commandes).
- Smain : le menu console, les tests, le Gitflow et le README.

## Difficultés rencontrées

- On a mis un peu de temps avant de trouver une bonne organisation (la répartition des fichiers entre nous et la gestion des branches Gitflow). Du coup on a perdu du temps au début et on n'a pas réussi à terminer toutes les fonctionnalités demandées.

- On a eu du mal à comprendre reduce au début, surtout le passage par map(Produit::getPrix) avant de faire la somme avec reduce(0.0, Double::sum). La différence avec mapToDouble().sum() n'était pas évidente non plus.

- Parcourir les commandes nous a posé problème parce qu'une commande contient une liste de lignes, et chaque ligne a un produit et une quantité. Il a fallu un moment pour comprendre comment aller chercher les produits à l'intérieur.

- La syntaxe de collect(Collectors.toSet()) n'était pas intuitive, on ne savait pas trop comment écrire la collecte vers un Set au début.

- Pour trouver le premier produit Informatique, on ne pensait pas à utiliser ifPresent. On ne connaissait ni l'idée ni la syntaxe de findFirst().ifPresent(...). On a compris que findFirst renvoie un Optional (qui peut être vide), et que ifPresent permet d'afficher le résultat seulement s'il existe vraiment.

- Mettre en place les tests unitaires nous a posé problème au début, on ne savait pas qu'il fallait créer un dossier src/test/java séparé du code principal, et que le package devait correspondre exactement au chemin du fichier. Plusieurs erreurs de compilation venaient de là.

- L'annotation @BeforeEach n'était pas claire pour nous au début. On ne comprenait pas pourquoi initialiser la liste de produits avant chaque test au lieu de le faire une seule fois. On a compris que ça permet à chaque test de partir d'un état propre et indépendant des autres.

- La différence entre assertEquals et assertTrue nous a fait hésiter sur plusieurs tests. On a fini par comprendre qu'assertEquals sert à comparer deux valeurs précises (taille attendue, total attendu), alors qu'assertTrue valide une condition globale comme allMatch ou isPresent.

- Pour comparer des double avec assertEquals, on a eu une erreur la première fois car on n'avait pas mis de tolérance (delta). On a appris qu'il faut écrire assertEquals(954.0, total, 0.001) parce que les calculs sur les double peuvent donner de toutes petites imprécisions.
