# ENT-Etudiant
Projet ENT Etudiant M1A 2016-2017

# Angular 2

* Avant tout, vous devez installer node.js et npm https://wsvincent.com/install-node-js-npm-windows/

Les sources utilisant Angular 2 (au format .ts (TypeScript)) sont situées
dans le dossier /src/main/resources/static/js/app/Angular/ent

Pour faire fonctionner l'application, il faut d'abord lancer Spring Boot puis ensuite lancer
l'application Angular avec un `ng serve --open` une fois que vous vous êtes
déplacés dans le dossier /src/main/resources/static/js/app/Angular/ent. 

L'application devrait alors s'ouvrir dans votre navigateur (chez moi à l'adresse localhost:4200)


L'approche est intéressante mais je pense trop compliquée pour l'utiliser sur
toute l'application. On peut peut-être réfléchir à n'utiliser Angular2
que pour lire (comme dans l'exemple) mais ne pas s'en servir pour écrire en base.