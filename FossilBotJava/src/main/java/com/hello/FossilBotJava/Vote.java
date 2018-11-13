package com.hello.FossilBotJava;


public class Vote {
	private String author;
	private int numOfPeople;
	private String peopleWhoVoted;
	private int yvotes;
	private int nvotes;
	private String vote;
	
	public Vote(String vote, String user) {
		this.author = user;
		this.numOfPeople = numOfPeople;
		this.yvotes = yvotes;
		this.nvotes = nvotes;
		this.vote = vote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNumOfPeople() {
		return numOfPeople;
	}

	public void setNumOfPeople(int numOfPeople) {
		this.numOfPeople = numOfPeople;
	}

	public String getPeopleWhoVoted() {
		return peopleWhoVoted;
	}

	public void addPeopleWhoVoted(String objUser) {
		if(this.peopleWhoVoted == null) {
			this.peopleWhoVoted = objUser;
		}else {
		
		this.peopleWhoVoted = this.peopleWhoVoted + ", " + objUser;
		}
	}

	public int getYvotes() {
		return yvotes;
	}

	public void voteY() {
		this.yvotes++;
	}
	public void clearVotes() {
		this.yvotes = 0;
		this.nvotes = 0;
		this.peopleWhoVoted = "";
	}

	public int getNvotes() {
		return nvotes;
	}

	public void voteN() {
		this.nvotes++;
	}

	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	
	
	
}
