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
 * [x] User can create a new account
 * [x] User can login
 * [ ] User can create their own deck
     * A filled with "cards"
     * A deck should have "names" 
 * [ ] User can edit their deck
     * Remove specific cards
     * Alter front and back side
     * Add cards to deck 
 * [x] User should be able save the card (via the cloud)
     * Firebase
     * Local persistent storage (MVP)
 * [x] User can interact with "study" mode by swiping left if they don't know OR swipe right (if they got it right)
 * [x] Spanish to English for a sample layout (deck 1)

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

### GIF Walkthrough
<img src='ZotCards Final Walkthrough.gif' title='Full Video Walkthrough' width='' alt='Video Walkthrough' />


## Schema 
### Models
User
|Property |Type| Description|
|-----|--------|------------|
|userid| Int | unique id for the user (default field)|
|userEmail | String | user's email |
|userPassword| String | password | 

Create Deck
|Property |Type| Description|
|-----|--------|------------|
|deckId| Int | unique id for the deck (default field)| 
|deckName |String| deck name|
|deckCount | Integer | number of cards in the deck|
|author| String | author name |
|cardCollection| List<Cards> | Text |
|createdAt| DateTime| date when post is created (default field)|
|updatedAt | DateTime| date when post is last updated (default field)|

Create Card
|Property |Type| Description|
|-----|--------|------------|
|objectid |String| unique id for the user post (default field)|
|Author | String | author name|
|question| String | Text |
|answer | String | Text |
| createdAt| DateTime| date when post is created (default field)|
| updatedAt | DateTime| date when post is last updated (default field)|


### Networking
#### List of network requests by screen

- Signup Request
 ```
 private void SignUpUser(String username, String password) {
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG,"Issue with sign up",e);
                    return;
                }
                goMainActivity();
            }
        });
    }
 ```
- Login Request
```
private void loginUser(String username, String password){
    
    ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e !=null){
                    Log.e(TAG,"Issue with login",e);
                    Toast.makeText(LoginActivity.this,"Issue with login!",Toast.LENGTH_SHORT).show();
                    return;
                }
                //TODO: navigate to the main activity if the user has signed in properly
                goMainActivity();
                Toast.makeText(LoginActivity.this,"Logged in ",Toast.LENGTH_SHORT).show();

            }
        });
    }

```
- GetDeck Request
```
Class Deck
{
	List<Cards> cardCollection;
	String deckName;
	String deckUID;
	Int numCards;
	ParseUser author;

	// Grab the deck from the DB
	private void setDeck(String deckUID);
	// Returns the deck
	Public List<Cards> getDeck();
	Public void fetchDeck(String UID);
	Public void deleteDeck();
	Public void deleteCard(int index);

	// Set the Deck Name
	Private void setDeckName(String deckName);
	// Get the Deck Name
	Public String getDeckName();

	// Set the Deck ID
	Private void setDeckUID(String UID);
	// Get the Deck ID
    	Public String getDeckUID();

	// Return the deckSize
    	Public int getDeckSize();

    	// Set the Author of Parseuser type
	Private void setAuthor(ParseUser author);
    	// Get the Author of Parseuser type
	Public ParseUser getAuthor();	

    	public ArrayList<Deck> getDecks(int courseID){

	       ArrayList<Deck> deckList = new ArrayList<Deck>();

	       String selectQuery = "SELECT * FROM " + TABLE_DECK_DETAIL + " WHERE " + COURSE_ID + "=" + courseID;

	       SQLiteDatabase db = this.getReadableDatabase();

	       Cursor cursor = db.rawQuery(selectQuery, null);

	       cursor.moveToFirst();

	       System.out.println("DBHandler courseID in getDecks: " + courseID);

	       //loop through all rows to return

	       while(!cursor.isAfterLast()){

		   Deck deck = new Deck(Integer.parseInt(cursor.getString(0)), courseID,

			   cursor.getString(2), Integer.parseInt(cursor.getString(3)));

		   deck.set_deckId(courseID);
		   deckList.add(deck);

		   //Log.i(TAG, "HERE WE ARE CourseID: " + courseID);

		   cursor.moveToNext();
	       }
	       Log.i(TAG, "Return All Deck Names");
	       db.close();
	       return deckList;

   	}
 }

````

* Deck Screen
	* (Create/POST) Create a new deck object
	* (Delete) Delete existing deck
* Card Screen
	* (Create/ POST) Add cards to the deck
	* (Delete) Delete existing cards

- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]


