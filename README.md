# TP1 – Injection des Dépendances avec Spring

## Introduction

Ce TP porte sur le principe fondamental de l’**injection des dépendances** (*Dependency Injection*), un concept clé de la programmation orientée objet et du framework Spring.
L’objectif est d’implémenter progressivement plusieurs approches d’injection, allant du couplage fort manuel jusqu’à l’injection automatique gérée par le conteneur Spring, en passant par une instanciation dynamique via la réflexion.

---

## Environnement de travail

* **IDE** : IntelliJ IDEA Ultimate
* **Langage** : Java
* **Framework** : Spring Framework (Core)
* **Outil de build** : Maven

---

## Architecture de l’application

L’application suit une architecture en couches basée sur deux interfaces :

* **`IDao`** : représente la couche d’accès aux données avec une méthode `getData()` retournant une valeur numérique.
* **`IMetier`** : représente la couche métier avec une méthode `calcul()` exploitant les données fournies par la couche DAO.

Ce découplage par interfaces permet de réduire les dépendances directes entre les composants et facilite l’injection des dépendances.

---

## Travail réalisé

### 1. Instanciation statique (couplage fort)

Dans cette approche, les classes concrètes sont instanciées directement dans la classe de présentation.
L’objet `DaoImpl` est créé manuellement et injecté dans `MetierImpl` via le constructeur.

👉 **Limite** : cette méthode crée un **couplage fort**, car toute modification d’implémentation nécessite une recompilation du code.

---

### 2. Instanciation dynamique (couplage faible)

Pour réduire le couplage, cette approche utilise la **réflexion Java**.

Le nom de la classe à instancier est lu depuis un fichier de configuration externe (`config.txt`). Le programme charge dynamiquement la classe à l’exécution avec `Class.forName()`.

👉 **Avantage** : changer d’implémentation ne nécessite qu’une modification du fichier de configuration.

**Fichier `config.txt` :**

```
ext.DaoImplV2
```

---

### 3. Injection avec Spring – Version XML

Spring gère la création des objets (*beans*) et leurs dépendances via un fichier de configuration XML.

Le conteneur Spring instancie automatiquement les beans et injecte les dépendances via le constructeur.

**Fichier `config.xml` :**

```xml
<bean id="dao" class="ext.DaoImplV2"/>
<bean id="metier" class="metier.MetierImpl">
    <constructor-arg ref="dao"/>
</bean>
```

Le contexte est chargé avec `ClassPathXmlApplicationContext`, puis le bean `metier` est récupéré depuis le conteneur.

---

### 4. Injection avec Spring – Version Annotations

Cette version moderne utilise les annotations pour remplacer la configuration XML.

Les classes sont annotées avec :

* `@Repository`
* `@Service`
* `@Component`

Spring scanne automatiquement les packages et injecte les dépendances.

Le contexte est initialisé avec `AnnotationConfigApplicationContext`.

👉 **Avantage** : code plus lisible, moins de configuration, et approche standard dans les projets modernes.

---

## Comparaison des approches

| Approche                | Couplage | Flexibilité | Complexité  |
| ----------------------- | -------- | ----------- | ----------- |
| Instanciation statique  | Fort     | Faible      | Très simple |
| Instanciation dynamique | Faible   | Moyenne     | Modérée     |
| Spring XML              | Faible   | Élevée      | Modérée     |
| Spring Annotations      | Faible   | Élevée      | Simple      |

---

## Résultats obtenus

* Les quatre approches ont été implémentées et testées avec succès.
* La méthode `calcul()` produit le résultat attendu dans chaque cas.
* Le changement d’implémentation (`DaoImpl` → `DaoImplV2`) ne nécessite aucune modification du code métier.

👉 Cela illustre le principe **Open/Closed** : ouvert à l’extension, fermé à la modification.

---

## Conclusion

Ce TP montre l’évolution vers une architecture **découplée, flexible et maintenable**.

L’injection de dépendances permet de séparer la création des objets de leur utilisation, respectant ainsi les principes SOLID.

Spring simplifie cette gestion grâce à son conteneur IoC, que ce soit via configuration XML ou via annotations, rendant le code plus propre, testable et évolutif.
