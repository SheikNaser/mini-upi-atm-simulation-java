# 💳 Mini UPI / ATM Simulation (Java)

Description

This is a **console-based ATM/UPI simulation** built using Java as part of my learning journey.

The application allows users to perform basic banking operations like deposit, withdrawal, and balance enquiry with **PIN-based authentication** for every transaction.

---

##  Features

*  Session-based **4-digit PIN generation**
*  Authentication before every transaction
*  Deposit money
*  Withdraw money
*  Balance enquiry
*  Menu-driven interface (loop-based transactions)
*  Handles edge cases:

  * Incorrect PIN
  * Insufficient balance

---

##  Concepts Used

* Methods and method calls
* Conditional statements (`if-else`, `switch`)
* Loops (`do-while`)
* User input using `Scanner`
* Random number generation (`Random`)
* Basic constructor usage (default & custom initialization)

---

##  How to Run

1. Compile the program:

```
javac MINIUPI.java
```

2. Run the program:

```
java MINIUPI
```

---

##  Sample Flow

* Program starts → generates a random PIN
* User selects operation (Deposit / Withdraw / Balance)
* User enters PIN for authentication
* If correct → transaction successful
* If wrong → transaction blocked

---

##  Project Type

This is a **beginner-level learning project** focused on understanding:

* Program flow
* Authentication logic
* State management (balance handling)

---

##  Future Improvements

* Limit PIN attempts (security enhancement)
* Transaction history
* GUI / Web-based version
* Real OTP integration

---

##  Author

Built by **Naser (SheikNaser)** as part of Java practice and hands-on learning.
