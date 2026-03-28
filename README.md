# 🏆 Club Sportif — Application Spring Boot

Application web de gestion d'un club sportif développée avec **Spring Boot 3**, **Thymeleaf** et **H2** (base de données en mémoire). Elle permet de gérer les membres, les activités et les inscriptions depuis une interface web sécurisée.

---

## 📋 Fonctionnalités

- **Membres** : ajout, liste, suppression avec badges de catégorie (Étudiant / Adulte / Senior)
- **Activités** : ajout, liste, suppression avec barre de capacité et badges de niveau
- **Inscriptions** : ajout, liste, suppression avec cartes de statistiques (total, payées, en attente, montant)
- **Authentification** : login/logout sécurisé avec Spring Security
- **Navigation** : barre de navigation commune à toutes les pages
- **Données de démo** : 3 membres, 3 activités et 2 inscriptions chargés automatiquement au démarrage

---

## 🛠️ Stack technique

| Composant           | Version    |
|---------------------|------------|
| Spring Boot         | 3.3.5      |
| Spring Security     | 6.x        |
| Spring Data JPA     | 3.x        |
| Thymeleaf           | 3.x        |
| Hibernate           | 6.x        |
| H2 Database         | Runtime    |
| Lombok              | Latest     |
| Java                | 17+        |
| Maven               | 3.x        |

---

## 🗂️ Structure du projet

```
src/main/java/ma/fstg/projet/
├── ClubSportifApplication.java        ← Point d'entrée
├── config/
│   ├── SecurityConfig.java            ← Configuration Spring Security
│   └── DataInitializer.java           ← Données de démonstration
├── controller/
│   ├── HomeController.java            ← Routes / et /login
│   ├── MembreController.java          ← CRUD membres
│   ├── ActivitieController.java       ← CRUD activités
│   └── InscriptionController.java     ← CRUD inscriptions
├── entities/
│   ├── Membre.java                    ← Entité membre
│   ├── Activitie.java                 ← Entité activité
│   └── Inscription.java               ← Entité inscription (jointure)
└── repositoy/
    ├── MembreRepository.java
    ├── ActiviteRepository.java
    └── InscriptionRepository.java

src/main/resources/
├── application.properties             ← Configuration H2, JPA, Thymeleaf
└── templates/
    ├── login.html
    ├── membres.html
    ├── activites.html
    └── inscriptions.html
```

---

## Video demo 


https://github.com/user-attachments/assets/c3696b31-667b-4609-90dc-866d68e5c664


## 🚀 Lancement

### Prérequis
- Java 17 ou supérieur
- Maven 3.x

### Démarrer l'application

```bash
# Cloner ou extraire le projet
cd projet-club-sprotif

# Lancer
mvn spring-boot:run
```

L'application démarre sur **http://localhost:8080**

---

## 🔐 Connexion

| Champ          | Valeur  |
|----------------|---------|
| Nom d'utilisateur | `admin` |
| Mot de passe   | `admin` |

---

## 🗄️ Console H2

La base de données H2 (en mémoire) est accessible à l'adresse :

```
http://localhost:8080/h2-console
```

| Paramètre    | Valeur                                      |
|--------------|---------------------------------------------|
| JDBC URL     | `jdbc:h2:mem:clubdb`                        |
| Username     | `sa`                                        |
| Password     | *(laisser vide)*                            |

> ⚠️ Les données sont **réinitialisées** à chaque redémarrage (base en mémoire).

---

## 📐 Modèle de données

```
Membre (1) ─────────────────── (N) Inscription (N) ─────────────────── (1) Activitie
  - id                               - id                                    - id
  - nom                              - dateInscription                        - nom
  - categorie                        - statut                                 - niveau
  - dateAdhesion                     - montant                                - capacite
```

### Catégories membre
- `Etudiant` — badge bleu
- `Adulte` — badge vert
- `Senior` — badge orange

### Niveaux activité
- `Débutant` — badge vert
- `Intermédiaire` — badge orange
- `Avancé` — badge rose

### Statuts inscription
- `Payé` — badge vert
- `En attente` — badge orange

---

## 🐛 Bugs corrigés (par rapport à la version initiale)

| Fichier | Problème | Correction |
|---|---|---|
| `Inscription.java` | Pas de `@Getter`/`@Setter` Lombok → champs inaccessibles | Ajout des annotations Lombok |
| `Inscription.java` | Champ nommé `memebre` (faute de frappe) | Renommé en `membre` |
| `ActivitieController.java` | Route GET `/activities` ≠ POST `/activites` | Unifié en `/activites` via `@RequestMapping` |
| `activites.html` | Pas de `<head>`, pas de `xmlns:th`, pas de CSRF | Template entièrement réécrit |
| `application.properties` | Fichier vide → H2, JPA, Thymeleaf non configurés | Configuration complète ajoutée |
| `Membre.java` | `mappedBy = "memebre"` (faute de frappe) | Corrigé en `mappedBy = "membre"` |

---

## ✨ Améliorations apportées

- **Page de login** dédiée et stylisée
- **Navigation** commune entre les 3 pages
- **Bouton Supprimer** sur chaque ligne (avec confirmation)
- **Badges colorés** pour catégories, niveaux et statuts
- **Cartes de statistiques** sur la page Inscriptions
- **Barre de capacité** visuelle sur la page Activités
- **Validation des formulaires** avec messages d'erreur (`@NotBlank`, `@Min`)
- **Données de démonstration** chargées automatiquement au démarrage
- **`HomeController`** pour redirection `/` → `/membres`
- **Méthodes de recherche** supplémentaires dans les repositories

---

## 📦 Build JAR

```bash
mvn clean package -DskipTests
java -jar target/ClubSportif-0.0.1-SNAPSHOT.jar
```

---

## 🐳 Dockerisation (optionnel)

Créer un `Dockerfile` à la racine :

```dockerfile
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY target/ClubSportif-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

Puis :

```bash
mvn clean package -DskipTests
docker build -t club-sportif:1.0 .
docker run -p 8080:8080 club-sportif:1.0
```
