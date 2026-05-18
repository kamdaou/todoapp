# Cours de Développement Mobile — Programme

> Document destiné à servir de contexte à Claude Code pour assister le développement
> d'une application Android Kotlin (projet fil rouge : **TodoChad**) au fil du cours.

## Métadonnées du cours

- **Public** : étudiants de Licence en Informatique (niveau mixte débutant/intermédiaire)
- **Langage principal** : Kotlin
- **Plateforme cible** : Android (API 24+)
- **UI** : Jetpack Compose (déclaratif), avec mentions de l'ancien système XML
- **Architecture cible** : MVVM + Repository
- **Projet fil rouge** : application TodoChad (gestionnaire de tâches)
- **Évaluation** : 20% CC + 20% TP + 60% Examen
- **Volume** : 8 chapitres

---

## Chapitre 1 — Introduction générale au développement mobile

### Concepts théoriques
- Écosystème mobile : Android (~70%), iOS (~28%), HarmonyOS, KaiOS
- Modèles économiques : gratuit/pub, payant, freemium, abonnement
- Typologie des apps : natives, hybrides, web/PWA, cross-platform
- Architecture Android en 6 couches : noyau Linux, HAL, bibliothèques natives, ART, framework Java/Kotlin, applications
- Les 4 composants Android : Activity, Service, BroadcastReceiver, ContentProvider
- Rôle du `AndroidManifest.xml`
- Pourquoi pas de `main()` sur Android (inversion de contrôle, ressources limitées, interruptions fréquentes)

### Compétences visées
- Justifier le choix d'une approche native pour le contexte africain
- Identifier le composant Android adapté à un scénario donné

---

## Chapitre 2 — Environnement de développement et langage Kotlin

### Concepts théoriques
- Chaîne d'outils : Android Studio (basé sur IntelliJ), Android SDK, JDK 17+, Gradle, AVD
- Processus de compilation : `.kt` → bytecode JVM → DEX (via D8) → APK/AAB → signature → installation
- Différence ART vs JVM classique (optimisations mobiles)
- Kotlin : null-safety, `val`/`var`, type inference, data classes
- Fonctions Kotlin : déclaration, expression unique, paramètres par défaut, arguments nommés
- Interopérabilité Kotlin/Java

### Compétences visées
- Installer et configurer Android Studio
- Créer un projet "Hello World" Compose
- Écrire des fonctions Kotlin idiomatiques

---

## Chapitre 3 — Interfaces utilisateur

### Concepts théoriques
- Paradigmes : impératif (XML + View System) vs déclaratif (Jetpack Compose)
- Layouts classiques : LinearLayout, ConstraintLayout, FrameLayout, RecyclerView
- Équivalents Compose : Row, Column, Box, LazyColumn
- Cycle de rendu : measure → layout → draw
- Contrainte 60 fps (16 ms par frame)
- Material Design 3 : élévation, palette, typographie, composants
- Unités `dp` et `sp` (accessibilité)
- Recyclage de vues (RecyclerView / LazyColumn)

### Compétences visées
- Composer une UI avec Compose (Column, Row, Text, Button, TextField)
- Utiliser MaterialTheme et les composants Material 3
- Comprendre la performance du layout

### Pour TodoChad
- Écran liste des tâches avec LazyColumn
- Formulaire d'ajout avec OutlinedTextField et Button
- Bouton flottant (FAB) pour créer une nouvelle tâche

---

## Chapitre 4 — Cycle de vie et navigation

### Concepts théoriques
- Cycle de vie Activity : `onCreate` → `onStart` → `onResume` → `onPause` → `onStop` → `onDestroy`
- Sauvegarde d'état : `onSaveInstanceState()`
- Problème de la rotation d'écran (destruction/recréation)
- Intents explicites vs implicites
- Pile d'activités (back stack, LIFO)
- Flags d'Intent (FLAG_ACTIVITY_CLEAR_TOP, SINGLE_TOP)
- Jetpack Navigation Component (graphe, Safe Args, deep linking)

### Compétences visées
- Naviguer entre écrans avec NavController (Compose)
- Passer des arguments typés entre écrans
- Gérer la rotation sans perte de données

### Pour TodoChad
- Navigation liste → détail d'une tâche
- Écran paramètres
- Passage de l'ID de la tâche entre écrans

---

## Chapitre 5 — Persistance des données

### Concepts théoriques
- Options : SharedPreferences, DataStore, fichiers, SQLite, Room, Cloud
- Modèle relationnel : tables, schéma, clé primaire, clé étrangère, normalisation
- SQL : SELECT, INSERT, UPDATE, DELETE, JOIN, WHERE, GROUP BY
- SQLite : base embarquée la plus déployée au monde
- Room : ORM officiel — Entity, DAO, Database
- Annotations : `@Entity`, `@PrimaryKey`, `@Dao`, `@Query`, `@Insert`, `@Update`, `@Delete`
- Sérialisation : kotlinx.serialization, Moshi, Gson

### Compétences visées
- Définir une Entity Room
- Écrire un DAO avec opérations CRUD
- Observer les données avec Flow
- Choisir le bon mécanisme de stockage selon le besoin

### Pour TodoChad
- Entity `Tache(id, titre, description, terminee, dateCreation, dateEcheance)`
- DAO avec `Flow<List<Tache>>` pour l'observation réactive
- Migration de schéma (ajout d'une colonne)

---

## Chapitre 6 — Réseau et API REST

### Concepts théoriques
- Modèle client-serveur
- Protocole HTTP/HTTPS : verbes (GET, POST, PUT, PATCH, DELETE)
- Architecture REST : ressources, URLs, stateless, représentation JSON
- Codes de statut HTTP : 2xx, 3xx, 4xx, 5xx
- Programmation asynchrone : threads, callbacks, coroutines, Flow
- Pourquoi ne pas bloquer le thread UI (ANR)
- Retrofit : annotations `@GET`, `@POST`, `@Path`, `@Body`, `@Query`
- Conversion JSON : Moshi/Gson Converter
- Sécurité : HTTPS obligatoire, TLS, certificate pinning

### Compétences visées
- Définir une interface Retrofit
- Appeler une API REST avec coroutines
- Gérer les erreurs réseau (try/catch, sealed class Result)
- Convertir JSON ↔ objets Kotlin

### Pour TodoChad
- Synchronisation optionnelle des tâches avec un backend distant
- Appel à `https://jsonplaceholder.typicode.com/todos` pour démo
- Gestion de l'état de connectivité

---

## Chapitre 7 — Capteurs et services système

### Concepts théoriques
- Sandbox Android et modèle de permissions (normales, dangereuses, spéciales)
- Permissions install-time vs runtime (depuis Android 6)
- API `registerForActivityResult` + `ActivityResultContracts.RequestPermission`
- Capteurs : accéléromètre, gyroscope, GPS (trilatération), magnétomètre, luminosité, proximité
- Précision GPS : 3-5 m en extérieur dégagé
- Notifications : canaux obligatoires (Android 8+), actions, médias, FCM
- Tâches en arrière-plan : Coroutines + ViewModel, WorkManager, Foreground Service
- Restrictions arrière-plan depuis Android 8 (économie batterie)

### Compétences visées
- Demander une permission runtime proprement
- Accéder à la géolocalisation avec FusedLocationProviderClient
- Créer une notification avec NotificationCompat + canal
- Planifier une tâche périodique avec WorkManager

### Pour TodoChad
- Notification de rappel à l'heure d'échéance d'une tâche
- Géolocalisation pour rappel contextuel ("au marché")
- Permissions POST_NOTIFICATIONS (Android 13+) et ACCESS_FINE_LOCATION

---

## Chapitre 8 — Architecture, qualité et publication

### Concepts théoriques
- Patterns : MVC, MVP, MVVM, Clean Architecture
- MVVM en détail : Model, View, ViewModel + Repository
- Jetpack : `ViewModel`, `LiveData`, `StateFlow`, `viewModelScope`
- Principes SOLID
- Injection de dépendances : Hilt (recommandé), Koin, Dagger
- Tests : unitaires (JUnit, MockK), instrumentés (Espresso, Compose Testing)
- TDD (Test-Driven Development)
- Publication : keystore, signature numérique (asymétrique), AAB vs APK, fiche Play Store
- Différence APK / AAB (taille téléchargée optimisée)

### Compétences visées
- Refactorer une app simple en MVVM
- Configurer Hilt et injecter un Repository dans un ViewModel
- Écrire un test unitaire JUnit
- Générer un keystore et signer un AAB

### Pour TodoChad
- Refactor complet en MVVM + Repository
- Hilt pour l'injection (Database, DAO, Repository, ViewModel)
- Tests unitaires sur le ViewModel
- Génération d'un AAB signé prêt pour le Play Store

---

## Projet fil rouge : TodoChad

### Vue d'ensemble
Application Android Kotlin de gestion de tâches développée progressivement
sur les 8 chapitres. Chaque TP capitalise sur le précédent. À la fin du cours,
l'étudiant possède une application complète, installable, prête à publier.

### Spécifications fonctionnelles minimales

#### Données
- `Tache` : id (Long auto), titre (String, requis), description (String, optionnel),
  terminee (Boolean, défaut false), dateCreation (Long, timestamp),
  dateEcheance (Long?, optionnel), categorie (String?, optionnel)

#### Écrans
1. **ListeTaches** : LazyColumn des tâches, checkbox pour marquer terminé,
   FAB pour ajouter, filtre par statut/catégorie
2. **DetailTache** : afficher/éditer une tâche, supprimer
3. **AjouterTache** : formulaire de création
4. **Parametres** : thème (clair/sombre), langue (fr/en), activation sync cloud

#### Fonctionnalités par chapitre
- Ch.3 : UI fonctionnelle avec données en mémoire
- Ch.4 : navigation entre les 4 écrans
- Ch.5 : persistance Room (toutes les tâches survivent au redémarrage)
- Ch.6 : sync optionnelle avec un backend (JSONPlaceholder pour démo)
- Ch.7 : notification de rappel + permission géoloc
- Ch.8 : refactor MVVM + Hilt + tests + publication

### Stack technique imposée
- Kotlin 2.0+
- Jetpack Compose (UI uniquement, pas de XML)
- Room (persistance)
- Retrofit + kotlinx.serialization (réseau)
- Hilt (DI) à partir du Ch.8
- Coroutines + Flow (asynchrone)
- WorkManager (tâches en arrière-plan)
- Material 3 (design)
- Navigation Compose (navigation)
- JUnit + MockK (tests unitaires)

### Conventions de code attendues
- Nommer les packages : `td.cadet.todochad.<feature>`
- Une classe par fichier
- ViewModel suffixe : `XxxViewModel`
- Repository suffixe : `XxxRepository`
- UI states : `data class XxxUiState`
- Events : sealed class `XxxEvent`
- Pas de logique dans les `@Composable` autre que la composition
- Tous les strings dans `strings.xml` (préparation i18n)

### Branches Git attendues
Une branche par TP : `tp1-ui`, `tp2-navigation`, `tp3-room`, `tp4-retrofit`,
`tp5-capteurs`, `tp6-mvvm-hilt`. Commits réguliers, datés (anti-triche).

---

## Évaluation

| Composante | Pondération | Format |
|---|---|---|
| Contrôle continu | 20% | 2 mini-tests théoriques (après Ch.4 et Ch.6) |
| TP (TodoChad) | 20% | Rendus par étape + soutenance orale 3 min |
| Examen final | 60% | Théorique (25%) + pratique sur machine (35%) |

### Critères d'évaluation des TP
- Code fonctionnel (40%)
- Qualité du code et respect des conventions (25%)
- Respect du pattern MVVM (à partir du Ch.8) (20%)
- Soutenance orale, capacité à expliquer son code (15%)

---

## Ressources et bibliographie

- Documentation officielle Android : https://developer.android.com
- Documentation Kotlin : https://kotlinlang.org/docs/
- Codelabs Compose : https://developer.android.com/courses/jetpack-compose/course
- Cours en français : Android Basics with Compose (Google)
- Material Design 3 : https://m3.material.io

---

## Notes pour Claude Code

Lorsque tu assistes le développement de TodoChad :
- **Toujours** utiliser Kotlin moderne, Compose, coroutines, Flow
- **Jamais** suggérer du XML, des AsyncTask, ni de l'API Java legacy
- Respecter le pattern MVVM dès qu'il a été introduit (Ch.8)
- Privilégier la lisibilité sur la concision excessive
- Commenter le code en français
- Suggérer des tests unitaires pour chaque ViewModel/Repository
- Quand un concept est de niveau supérieur au chapitre courant, le signaler
  explicitement avant d'introduire l'extrait de code