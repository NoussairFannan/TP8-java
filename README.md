# TP8-java

## Description

Ce projet contient deux exercices démontrant l'utilisation des **sockets** et des **threads** en Java pour développer des applications réseau multi-clients.

### Exercice 1 : Jeu du Nombre Magique

#### Objectif

Développer un jeu où plusieurs joueurs tentent de deviner un nombre magique généré aléatoirement par le serveur.

#### Fonctionnalités

- Le serveur génère un nombre magique entre 0 et 100 à l'aide de la méthode `Math.random`.
- le joueur peut soumettre des propositions pour deviner le nombre magique.
- Le serveur fournit des indices pour chaque tentative :
  - **"C'est plus !"** si la tentative est inférieure au nombre magique.
  - **"C'est moins !"** si la tentative est supérieure au nombre magique.
  - **"Félicitations !"** si le joueur trouve le nombre magique.

#### Techniques utilisées

- **Sockets** : pour la communication réseau entre le serveur et les clients.

---

### Exercice 2 : Serveur de Fichiers Multi-Clients

#### Objectif

Créer un serveur de fichiers permettant à plusieurs clients de demander et de recevoir des fichiers via des sockets.

#### Fonctionnalités

- Le serveur écoute les connexions sur un port spécifique et gère plusieurs clients simultanément.
- Les clients peuvent demander un fichier en envoyant son nom au serveur.
- Le serveur :
  - Vérifie si le fichier demandé existe.
  - Envoie le contenu du fichier au client si le fichier est trouvé.
  - Renvoie un message d'erreur si le fichier est introuvable.

#### Techniques utilisées

- **Sockets** : pour établir une communication entre le serveur et les clients.
- **Threads** : chaque client est géré dans un thread distinct pour permettre une gestion multi-clients.
- **BufferedReader** : pour lire les données.
- **PrintWriter** : pour envoyer des données.
- **BufferedReader** : pour lire les entrées de la console.

---

