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
* [ ] User will have a 'statistic page' after a study session

### 2. Screen Archetypes
* Registration Screen
   * User can create a new account
* Login Screen
   * User can Login
* Profile Screen
    * User information
* Home Screen
   * All decks can be viewd here
* Create Deck Screen
   * User can create their own deck
* Learn Screen
   * User can use the existing cards to review/ learn concepts
   
### 3. Navigation Layout
**Tab Navigation** (Tab to Screen)
* Home
* Profile
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

### Wireframes from 2/22/2021
<img src="https://github.com/ZotCards/ZotCards/blob/main/ZotCards.PNG" width=800><br>

## Schema 
[This section will be completed in Unit 9]
### Models
User

Create Card
[Add table of models]
|Property |Type| Description|
|-----|--------|------------|
|objectid |String| unique id for the user post (default field)|
|Author | String | author name|
|question| String | Text |
|answer | String | Text |
| createdAt| DateTime| date when post is created (default field)|
| updatedAt | DateTime| date when post is last updated (default field)|
### Networking
- [Add list of network requests by screen ]
- Home Screen
```
 mAuth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }

                // ...
            }
        });
   ```
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]


