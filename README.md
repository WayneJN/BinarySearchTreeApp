# 🌳 Binary Search Tree Visualizer

A full-stack application built with **Spring Boot** and **React** that allows users to create, visualize, and explore Binary Search Trees (BSTs). Users can input a series of numbers, generate a BST, view it in multiple formats, and revisit previously saved trees.

---

## 📌 Project Overview

This application was developed as part of the **Semester 4 Final Sprint** for the Data Structures and Algorithms course. It demonstrates key concepts of binary search trees, including insertion, traversal, balancing, and visualization.

---

## 🚀 Features

- ✅ **User Input Interface**: Enter a series of numbers to generate a BST.
- ✅ **Tree Processing**: Sequential or balanced BST construction.
- ✅ **Visualization Modes**:
  - Tree View (nested boxes)
  - Traversal View (in-order)
  - Raw JSON View
  - Graphical SVG View
- ✅ **Previous Trees**: View and revisit previously generated trees.
- ✅ **Database Integration**: Stores input and tree structure using JPA.
- ✅ **Bonus**: Balanced BST generation via sorted input.
- ✅ **Unit Testing**: Core tree operations tested for correctness.

---

## 🧰 Technologies Used

### Backend
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 / MySQL (configurable)**
- **Jackson (JSON serialization)**

### Frontend
- **React**
- **Axios**
- **CSS Modules**
- **SVG for graphical rendering**

---

## 📂 Project Structure

BinarySearchTreeApp/ 

├── backend/ 

│ ├── controller/ 

│ ├── model/ 

│ ├── repository/ 

│ ├── service/ 

│ ├── BstappApplication.java 


│ └── DataSeeder.java 

├── frontend/ 

│ ├── components/ 

│ ├── css/ 

│ ├── App.js 

│ └── bstApi.js


---

## 🛠️ Setup Instructions

### Backend (Spring Boot)
1. Navigate to `backend/`
2. Run the application:
   ```bash
   ./mvnw spring-boot:run
3. Server will start at http://localhost:8080

## Frontend (React)
1. Navigate to frontend/

2. Install dependencies:

  npm install

3. Start the React app:

  npm start

4. App will run at http://localhost:3000

## Testing
Unit tests are included for:

BST insertion , Traversals , Tree height and balance check

Run tests using : 

  ./mvnw test

## 📈 Future Enhancements
Traversal type selector (pre-order, post-order, level-order)

Tree animations for insertion/deletion

Export tree as image or JSON

Mobile responsiveness improvements

## 📚 Credits
Developed by Wayne as part of the Semester 4 Final Sprint for Data Structures and Algorithms.
