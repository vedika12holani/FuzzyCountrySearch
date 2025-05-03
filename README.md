# FuzzyCountrySearch

Welcome to **FuzzyCountrySearch** — an intelligent autocomplete system for country names!  
This project implements a **Trie Data Structure** to provide fast and efficient autocomplete, and also supports **fuzzy (typo-tolerant)** search when the user misspells.

---

## ✨ Features

- Fast country name autocomplete based on user input
- Handles typos or misspellings in search
- Suggests the most relevant country names
- Simple command-line interface
- Uses full list of **195 countries**

---

## ⚙️ How It Works

- When the user types a prefix, the system suggests matching countries.
- If there’s a typo, it uses **Levenshtein Distance** to find near matches.
- Typing 'exit' will close the application.

---

## 🛠️ Data Structures Used and Why

- **Trie (Prefix Tree)**:  
  - Used to store all country names.
  - Enables extremely fast lookup and suggestions for a given prefix.
  - Space-efficient for storing many words with common prefixes.

- **Levenshtein Distance (Dynamic Programming)**:  
  - Used to find words close to the mistyped input.
  - Helps in implementing a fuzzy search (tolerant to small errors).

Both data structures were chosen for **speed**, **efficiency**, and **handling human typing errors** smartly.

---

## 🚀 How to Run

1. Make sure you have **Java** installed.
2. Compile all files:

```bash
javac *.java
```
3. Run the project
```bash
java AutoCompleteDemo
```
4. Start typing prefixes of country names and see suggestions!

---

## 🔥 Example
Welcome to the Country Name Autocomplete!
Type a few letters and see suggestions (handles typos). Type 'exit' to quit.

Enter prefix: can
Suggestions:
- Canada
- Central African Republic

Enter prefix: untied
Exact matches not found, checking for possible matches with typos...
No countries found starting with or similar to 'untied'.

Enter prefix: south
Suggestions:
- South Africa
- South Korea
- South Sudan

Enter prefix: exit
Goodbye!

---

## 🌟 Future Improvements
1. Highlight best match suggestions.

2. Support multi-word corrections.

3. Add GUI interface for a better user experience.

4. Optimize fuzzy search for larger datasets.

---

## 📁 Project Structure
FuzzyCountrySearch/
├── TrieNode.java
├── Trie.java
├── FuzzySearch.java
├── AutoCompleteDemo.java
└── README.md

---

## 👤 Author
Author:Vedika Holani

GitHub: vedika12holani

---

## 📥 Clone Repository
bash
```
git clone https://github.com/yourusername/FuzzyCountrySearch.git
```

