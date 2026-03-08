# Gestion des Employés, Projets et Tâches (Hibernate / JPA)

## 📌 Description

Ce projet est une application Java utilisant **Hibernate (JPA)** pour gérer les relations entre **Employés, Projets et Tâches**.
Il permet de créer des employés, des projets et des tâches, puis d’associer les employés aux tâches réalisées.

Le projet suit une architecture organisée avec **DAO, Services, Entités et Utilitaires**.

---

## 🛠 Technologies utilisées

* Java
* Hibernate / JPA
* Maven
* MySQL (XAMPP)
* IntelliJ IDEA 

---

## 📂 Structure du projet

```
src
 └─ main
     └─ java
         └─ org.example
             ├─ dao
             │   └─ IDao.java
             │
             ├─ entities
             │   ├─ Employe.java
             │   ├─ Projet.java
             │   ├─ Tache.java
             │   ├─ EmployeTache.java
             │   └─ EmployeTachePk.java
             │
             ├─ service
             │   ├─ AbstractFacade.java
             │   ├─ EmployeService.java
             │   ├─ ProjetService.java
             │   ├─ TacheService.java
             │   └─ EmployeTacheService.java
             │
             ├─ util
             │   └─ HibernateUtil.java
             │
             └─ App.java
             
resources
 └─ hibernate.cfg.xml
```

---

## 🗂 Entités principales

### Employe

Représente un employé avec :

* id
* nom
* prénom
* téléphone

### Projet

Représente un projet :

* nom
* date de début
* date de fin
* employé responsable

### Tache

Représente une tâche dans un projet :

* nom
* date début
* date fin
* prix
* projet associé

### EmployeTache

Association entre un employé et une tâche avec :

* date de début réelle
* date de fin réelle

---

## ⚙️ Configuration Hibernate

Le fichier **hibernate.cfg.xml** contient :

* les paramètres de connexion à la base de données
* les entités mappées
* la configuration Hibernate

Exemple de configuration :

```xml
hibernate.connection.url=jdbc:mysql://localhost:3306/gestion_projet
hibernate.connection.username=root
hibernate.connection.password=
hibernate.dialect=org.hibernate.dialect.MySQLDialect
hibernate.hbm2ddl.auto=update
```

---

## ▶️ Exécution du projet

[evalulition2.mp4](../../Videos/evalulition2.mp4)