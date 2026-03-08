# 💍 Gestion des Mariages – Projet Hibernate

## 📖 Description

Ce projet est une **application Java utilisant Hibernate** qui permet de gérer des **personnes et leurs mariages**.
Il montre l’utilisation de **l’héritage d’entités (Personne, Homme, Femme)** ainsi que la gestion d’une **relation de mariage avec clé composite**.

---

## 🛠️ Technologies utilisées

* ☕ Java
* 🔗 Hibernate ORM
* 🗄️ MySQL
* 📦 Maven
* 💻 IntelliJ IDEA

---

## 📁 Structure du projet

```
src
 └── main
     └── java
         └── ma.projet.gestion
             ├── dao
             │   └── IDao
             ├── entities
             │   ├── Personne
             │   ├── Homme
             │   ├── Femme
             │   ├── Mariage
             │   └── MariagePk
             ├── service
             │   ├── AbstractFacade
             │   ├── PersonneService
             │   ├── HommeService
             │   ├── FemmeService
             │   └── MariageService
             ├── util
             │   └── HibernateUtil
             └── App
```

---

## 🧩 Entités principales

### 👤 Personne

Classe de base représentant une personne.

### 👨 Homme

Représente un homme et hérite de **Personne**.

### 👩 Femme

Représente une femme et hérite de **Personne**.

### 💍 Mariage

Représente le mariage entre un **homme et une femme**.

### 🔑 MariagePk

Clé composite utilisée pour identifier un mariage.

---

## ▶️ Exécution



https://github.com/user-attachments/assets/e0be4860-ea82-497d-a094-9b7c011fd04e

