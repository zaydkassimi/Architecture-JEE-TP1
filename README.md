### 3. Injection avec Spring – Version XML

Spring prend en charge la gestion des objets (beans) et leurs dépendances via un fichier de configuration XML. Le conteneur Spring instancie les beans et effectue l'injection par constructeur automatiquement, sans aucune ligne d'instanciation dans le code Java.

**Fichier `config.xml` :**
```xml
<bean id="dao" class="ext.DaoImplV2"/>
<bean id="metier" class="metier.MetierImpl">
    <constructor-arg ref="dao"/>
</bean>
```

Le contexte Spring est chargé avec `ClassPathXmlApplicationContext`, et le bean `metier` est récupéré directement depuis le conteneur.

### 4. Injection avec Spring – Version Annotations

La version la plus moderne utilise les annotations Spring pour éliminer complètement la configuration XML. Les classes sont annotées avec `@Repository`, `@Service`, et `@Component`, et Spring scanne automatiquement les packages déclarés pour détecter et injecter les beans. Le contexte est initialisé avec `AnnotationConfigApplicationContext`.

Cette approche est la plus concise, la plus lisible, et la plus utilisée dans les projets Spring modernes.

---

## Comparaison des approches

| Approche | Couplage | Flexibilité | Complexité |
|---|---|---|---|
| Instanciation statique | Fort | Faible | Très simple |
| Instanciation dynamique | Faible | Moyenne | Modérée |
| Spring XML | Faible | Haute | Modérée |
| Spring Annotations | Faible | Haute | Simple |

---

## Résultats obtenus

- Les quatre approches d'injection ont été implémentées et testées avec succès.
- Le résultat de `calcul()` est affiché correctement dans chaque scénario.
- Le passage d'une implémentation DAO à une autre (`DaoImpl` → `DaoImplV2`) ne nécessite aucune modification du code métier, ce qui illustre parfaitement le principe **Ouvert/Fermé** (Open/Closed Principle).

---

## Conclusion

Ce TP illustre l'évolution naturelle vers une architecture découplée et maintenable. L'injection de dépendances, qu'elle soit manuelle ou gérée par Spring, permet de respecter les principes SOLID en séparant la création des objets de leur utilisation. Spring simplifie considérablement cette gestion grâce à son conteneur IoC, que ce soit via configuration XML ou via annotations, rendant le code plus propre, testable et extensible.
