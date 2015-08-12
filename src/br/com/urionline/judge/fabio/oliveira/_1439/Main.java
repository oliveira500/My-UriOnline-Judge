package br.com.urionline.judge.fabio.oliveira._1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
*
* @author Fabio Oliveira
*/

public class Main {
    enum Suit {
	Clubs, Diamonds, Hearts, Spades
    }

    static class Card {
	private int value;
	private Suit suit;

	public Card(final int value, final Suit suit) {
	    this.value = value;
	    this.suit = suit;
	}

	public void setValue(final int value) {
	    this.value = value;
	}

	public int getValue() {
	    return this.value;
	}

	public void setSuit(final Suit suit) {
	    this.suit = suit;
	}

	public Suit getSuit() {
	    return this.suit;
	}
    }

    static class Player {
	List<Card> cards;

	public Player() {
	    this.cards = new ArrayList<Card>();
	}

	public Player(final List<Card> cards) {
	    this.cards = cards;
	}

	public void addCard(final Card card) {
	    this.cards.add(card);
	}

	public boolean hasCards() {
	    if (cards.size() == 0) {
		return false;
	    }
	    return true;
	}

	public List<Card> getCards() {
	    return this.cards;
	}

	public Card playCard(final Card card) {
	    Card cardToBeRemoved = null;
	    for (final Iterator<Card> iterator = cards.iterator(); iterator.hasNext();) {
		final Card playerCard = (Card) iterator.next();
		if (playerCard.getValue() == card.getValue()
			|| playerCard.getSuit().equals(card.getSuit())) {
		    if (cardToBeRemoved != null) {
			if (playerCard.getValue() >= cardToBeRemoved.getValue()) {
			    if (playerCard.getValue() != cardToBeRemoved
				    .getValue()) {
				cardToBeRemoved = playerCard;
			    } else if (playerCard.getSuit().ordinal() > cardToBeRemoved
				    .getSuit().ordinal()) {
				cardToBeRemoved = playerCard;
			    }
			}
		    } else {
			cardToBeRemoved = playerCard;
		    }
		}
	    }
	    if (cardToBeRemoved != null) {
		this.cards.remove(cardToBeRemoved);
		return cardToBeRemoved;
	    }
	    return null;
	}
    }

    static class Pile {
	Stack<Card> cards = new Stack<Card>();

	public void add(final Card card) {
	    this.cards.push(card);
	}

	public Card remove() {
	    return this.cards.pop();
	}

	public Card getCard() {
	    return this.cards.peek();
	}
    }

    static class Players {
	List<Player> players;
	boolean clockwiseDirection = true;
	int currentPlayer = 0;

	public Players() {
	    players = new ArrayList<Player>();
	}

	public boolean isDirectionClockWise() {
	    return clockwiseDirection;
	}

	public void setClockWiseDirection(final boolean clockwiseDirection) {
	    this.clockwiseDirection = clockwiseDirection;
	}

	public void changeDirection() {
	    this.clockwiseDirection = !this.clockwiseDirection;
	}

	public Player getCurrentPlayer() {
	    return this.players.get(currentPlayer);
	}

	public int getCurrentPlayerNumber() {
	    return this.currentPlayer;
	}

	public void nextTurn() {
	    if (this.clockwiseDirection) {
		if (this.currentPlayer == (this.players.size() - 1)) {
		    this.currentPlayer = 0;
		} else {
		    this.currentPlayer++;
		}
	    } else {
		if (this.currentPlayer == 0) {
		    this.currentPlayer = this.players.size() - 1;
		} else {
		    this.currentPlayer--;
		}
	    }
	}

	public Player getNextPlayer() {
	    this.nextTurn();
	    return this.getCurrentPlayer();
	}

	public List<Player> getPlayersList() {
	    return this.players;
	}

	public void addPlayer(final Player player) {
	    this.players.add(player);
	}
    }

    static class Game {
	private int numberOfPlayers;
	private int numberOfCardsPerPlayer;
	private int numberOfCards;
	private final Players players;
	private final Pile discardPile;
	private final Pile stockPile;
	private boolean firstPlayer;

	public Game() {
	    this.players = new Players();
	    this.discardPile = new Pile();
	    this.stockPile = new Pile();
	    this.firstPlayer = true;
	}

	public int getNumberOfPlayers() {
	    return numberOfPlayers;
	}

	public void setNumberOfPlayers(final int numberOfPlayers) {
	    this.numberOfPlayers = numberOfPlayers;
	}

	public int getNumberOfCardsPerPlayer() {
	    return numberOfCardsPerPlayer;
	}

	public void setNumberOfCardsPerPlayer(final int numberOfCardsPerPlayer) {
	    this.numberOfCardsPerPlayer = numberOfCardsPerPlayer;
	}

	public int getNumberOfCards() {
	    return numberOfCards;
	}

	public void setNumberOfCards(final int numberofCards) {
	    this.numberOfCards = numberofCards;
	}

	public void addPlayer(final Player player) {
	    this.players.getPlayersList().add(player);
	}

	public void addToDiscardedPile(final Card card) {
	    this.discardPile.add(card);
	}

	public void addToStockPile(final Card card) {
	    this.stockPile.add(card);
	}

	public Card getDiscardedCard() {
	    return this.discardPile.getCard();
	}

	public Players getPlayers() {
	    return this.players;
	}

	public int start() {
	    boolean discardedCardUsed = false;
	    boolean alreadyGotCard = false;
	    int winner = -1;
	    do {
		if (discardedCardUsed) {
		    final Card card = this.players.getCurrentPlayer().playCard(
			    discardPile.getCard());
		    if (card != null) {
			this.discardPile.add(card);
			if (!players.getCurrentPlayer().hasCards()) {
			    winner = this.players.getCurrentPlayerNumber();
			}
			this.players.nextTurn();
			discardedCardUsed = false;
			alreadyGotCard = false;
		    } else {
			if (!alreadyGotCard) {
			    this.players.getCurrentPlayer().addCard(
				    stockPile.remove());
			    alreadyGotCard = true;
			} else {
			    this.players.nextTurn();
			    alreadyGotCard = false;
			}
		    }
		} else {
		    switch (getDiscardedCard().getValue()) {
		    case 12:
			if (!discardedCardUsed) {
			    this.players.changeDirection();
			    if (!firstPlayer) {
				this.players.nextTurn();
				this.players.nextTurn();
			    }
			    discardedCardUsed = true;
			}
			break;
		    case 7:
			if (!discardedCardUsed) {
			    this.players.getCurrentPlayer().addCard(
				    stockPile.remove());
			    this.players.getCurrentPlayer().addCard(
				    stockPile.remove());
			    this.players.nextTurn();
			    discardedCardUsed = true;
			}
			break;
		    case 1:
			if (!discardedCardUsed) {
			    this.players.getCurrentPlayer().addCard(
				    stockPile.remove());
			    this.players.nextTurn();
			    discardedCardUsed = true;
			}
			break;
		    case 11:
			if (!discardedCardUsed) {
			    this.players.nextTurn();
			    discardedCardUsed = true;
			}
			break;
		    default:
			final Card card = this.players.getCurrentPlayer().playCard(
				discardPile.getCard());
			if (card != null) {
			    this.discardPile.add(card);
			    if (!players.getCurrentPlayer().hasCards()) {
				winner = this.players.getCurrentPlayerNumber();
			    }
			    this.players.nextTurn();
			    discardedCardUsed = false;
			    alreadyGotCard = false;
			} else {
			    if (!alreadyGotCard) {
				this.players.getCurrentPlayer().addCard(
					stockPile.remove());
				alreadyGotCard = true;
			    } else {
				this.players.nextTurn();
				alreadyGotCard = false;
			    }
			}
			break;
		    }
		    firstPlayer = false;
		}
	    } while (winner == -1);
	    return winner;
	}
    }

    private static Suit getSuit(final String value) {
	if (value.equals("C")) {
	    return Suit.Clubs;
	} else if (value.equals("D")) {
	    return Suit.Diamonds;
	} else if (value.equals("H")) {
	    return Suit.Hearts;
	} else {
	    return Suit.Spades;
	}
    }

    public static void main(final String[] args) throws IOException {
	final InputStreamReader inputStream = new InputStreamReader(System.in);
	final BufferedReader bufferedReader = new BufferedReader(inputStream);
	while (true) {
	    String[] line = bufferedReader.readLine().split(" ");
	    final Game game = new Game();
	    game.setNumberOfPlayers(Integer.parseInt(line[0]));
	    game.setNumberOfCardsPerPlayer(Integer.parseInt(line[1]));
	    game.setNumberOfCards(Integer.parseInt(line[2]));
	    if (game.getNumberOfPlayers() == 0) {
		break;
	    }

	    for (int i = 0; i < game.getNumberOfPlayers(); i++) {
		final Player player = new Player();
		for (int j = 0; j < game.getNumberOfCardsPerPlayer(); j++) {
		    line = bufferedReader.readLine().split(" ");
		    final Card card = new Card(Integer.parseInt(line[0]),
			    getSuit(line[1]));
		    player.addCard(card);
		}
		game.addPlayer(player);
	    }
	    line = bufferedReader.readLine().split(" ");
	    final Card card = new Card(Integer.parseInt(line[0]), getSuit(line[1]));
	    game.addToDiscardedPile(card);
	    final int numberOfCardsStockPile = game.getNumberOfCards()
		    - (game.getNumberOfPlayers()
			    * game.getNumberOfCardsPerPlayer() + 1);
	    final Card[] cards = new Card[numberOfCardsStockPile];
	    for (int i = 0; i < numberOfCardsStockPile; i++) {
		line = bufferedReader.readLine().split(" ");
		cards[i] = new Card(Integer.parseInt(line[0]), getSuit(line[1]));
	    }
	    for (int i = (cards.length - 1); i >= 0; i--) {
		game.addToStockPile(cards[i]);
	    }
	    System.out.println(game.start() + 1);
	}

    }
}
