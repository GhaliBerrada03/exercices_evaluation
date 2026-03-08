# 📦 Gestion de Stock avec Hibernate

## 📖 Description du projet

Ce projet est une **application Java de gestion de stock** utilisant **Hibernate ORM** pour la persistance des données et **MySQL** comme système de gestion de base de données.

L'application permet de gérer :

* les **catégories de produits**
* les **produits**
* les **commandes**
* les **lignes de commande**

Le projet suit une **architecture en couches (DAO / Service / Entities)** afin de séparer la logique métier, l'accès aux données et les entités.

---

## 🛠️ Technologies utilisées

* ☕ **Java**
* 🗄️ **MySQL**
* 🔗 **Hibernate ORM**
* 📦 **Maven**
* 💻 **IntelliJ IDEA**

---

## 📁 Structure du projet

```
src
│
├── main
│   ├── java
│   │   └── org.example
│   │       ├── dao
│   │       │   └── IDao.java
│   │       │
│   │       ├── entities
│   │       │   ├── Categorie.java
│   │       │   ├── Produit.java
│   │       │   ├── Commande.java
│   │       │   ├── LigneCommandeProduit.java
│   │       │   └── CommandeProduitPk.java
│   │       │
│   │       ├── service
│   │       │   ├── AbstractFacade.java
│   │       │   ├── CategorieService.java
│   │       │   ├── ProduitService.java
│   │       │   ├── CommandeService.java
│   │       │   └── LigneCommandeProduitService.java
│   │       │
│   │       ├── util
│   │       │   └── HibernateUtil.java
│   │       │
│   │       └── App.java
│   │
│   └── resources
│       └── hibernate.cfg.xml
│
└── pom.xml
```

---

## 🧩 Entités principales

### 📂 Catégorie

Représente une catégorie de produits.

**Attributs :**

* id
* code
* libelle

Relation :

* Une catégorie peut contenir **plusieurs produits**.

---

### 📱 Produit

Représente un produit du stock.

**Attributs :**

* id
* reference
* prix
* categorie

---

### 🧾 Commande

Représente une commande effectuée.

**Attributs :**

* id
* date

---

### 📑 LigneCommandeProduit

Représente la relation entre une **commande et un produit**.

**Attributs :**

* quantite
* clé composite (**CommandeProduitPk**)

---


## ▶️ Exemple d'exécution


https://github.com/user-attachments/assets/25478b18-33ca-4300-b041-3a0fcfc66434




