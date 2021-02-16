# Team 3 

---

### (FLASH-CARD-APP) ZotCard
## Table of Contents
1. [Overview](#Overview)
2. [Product Spec](#Product-Spec)

## Overview
### Description
ZotCards is a flashcard app like {Anki / Quizlet} to learn languages. We will initially focus on creating flashcards for a single language and then extend this functionality to multiple languages. Users will be able to select the level they wish to start learning from, the different levels are {beginner, intermediate, expert}. In addtion users can also customise the flashcards.

## Product Spec

### 1. User Stories (Required and Optional) 
**Required Must-have Stories**
 * [ ] User can create a new account
 * [ ] User can login
 * [ ] User can create their own deck
     * A filled with "cards"
     * A deck should have "names" 
 * [ ] User can edit their deck
     * Remove specific cards
     * Alter front and back side
     * Add cards to deck 
 * [ ] User should be able save the card (via the cloud)
     * Firebase
     * Local persistent storage (MVP)
 * [ ] User can interact with "study" mode by swiping left if they don't know OR swipe right (if they got it right)
 * [ ] Spanish to English for a sample layout (deck 1)

**Optional Nice-to-have Stories**
* [ ] User can arrange the card based on difficulty level
* [ ] Speech to text utility
* [ ] User can create multiple different decks
* [ ] User can share decks across multiple users
    * [ ] DeckStore 
      * [ ] Public or Private
    * [ ] User can "bookmark" a card 
    * [ ] French to English (deck 2)

### 2. Screen Archetypes
* Registration Screen
   * User can create a new account
* Login Screen
   * User can Login
* Home Screen
   * All decks can be viewd here
* Create Deck Screen
   * User can create their own deck
* Learn Screen
   * User can use the existing cards to review/ learn concepts
   
### 3. Navigation Layout
**Tab Navigation** (Tab to Screen)
* Home
* Create Deck

**Flow Navigation** (Screen to Screen)
* Registration Screen
   * Home Screen
* Login Screen
   * Home screen
* Create Deck Screen
   * View Deck Screen (after the user creates the deck)
* Home Screen
   * Learn Screen


### 4. UI/UX
* [ ] Design the deck based on preferences (personalization stuff)
    * [ ] Background Layout
    * [ ] Dark Mode color themes
    



