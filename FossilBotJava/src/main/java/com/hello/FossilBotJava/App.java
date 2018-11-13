package com.hello.FossilBotJava;



import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * Hello world!
 *
 */
public class App extends ListenerAdapter 
{
    public static void main( String[] args ) throws Exception 
    {
	JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
       jda.addEventListener(new App());
    }
   
    @Override
    
    public void onMessageReceived(MessageReceivedEvent evt) {
    	
    	User objUser = evt.getAuthor();
    	MessageChannel objMsgCh = evt.getChannel();
    	Message objMsg = evt.getMessage();
    	String[] words = objMsg.getContentRaw().split(" ");
    	String voteTxt = "";
    	int voteCount = 0;
    	
    	boolean alreadyVoted = false;
    	
    	if(objUser.isBot()) {
    		
    	}else {
    	
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"ping")) {
    		objMsgCh.sendMessage(objUser.getAsMention() + " Pong!").queue();
    	}
    	if(objMsgCh.getName().equals("council-voting") || objMsgCh.getName().equals("public-voting") ) {
    		objMsg.addReaction("✅").queue();
    		objMsg.addReaction("🔶").queue();
    		objMsg.addReaction("❌").queue();
    	}
    	if(words[0].equalsIgnoreCase(Ref.prefix +"poll")) {
    		objMsg.addReaction("✅").queue();
    		objMsg.addReaction("🔶").queue();
    		objMsg.addReaction("❌").queue();
    		  }
    	if(words[0].equalsIgnoreCase(Ref.prefix +"result")) {
				
    		  }
    	if(objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"hello")
    	|| objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"hi")
    	|| objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"sup")
    	|| objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"yo")
    	|| objMsg.getContentRaw().equalsIgnoreCase(Ref.prefix+"good moring")) {
    		objMsgCh.sendMessage("Greetings!").queue();
    	}
    	if(words[0].equalsIgnoreCase(Ref.prefix+"call") && words[1].equalsIgnoreCase("vote"))
    	{
    		for(int i = 0; i < words.length - 2; i++) {
    			voteTxt = voteTxt + " " + words[i + 2];
    		}
    		objMsgCh.sendMessage("**A Vote Has Been Started!** Please vote vote whether or not you want __**" + voteTxt + " **__" + '!').queue();
    		for(int  i = 0; i < Ref.votes.length; i++) {
    			if(Ref.votes[i] == null) {
    				Ref.votes[i] = new Vote(voteTxt, objUser.getName());
    		}
    	}	
    }
    	if(words[0].equalsIgnoreCase(Ref.prefix+"vote")) {
//    		for(int i = 0; i == Ref.votes[voteCount].getPeopleWhoVoted().split(", ").length - 1; i++) {
//    			if(Ref.votes[voteCount].getPeopleWhoVoted().split(", ")[i].equals(objUser.getName())) {
//    				alreadyVoted = true;
//    			}
//    		}
    		if(alreadyVoted) {
    			objMsgCh.sendMessage("Error, you can only vote once!!!!");
    		}else {
    			if(words[1].equalsIgnoreCase("yes")) {
    				Ref.votes[voteCount].addPeopleWhoVoted(objUser.getName());
    				objMsgCh.sendMessage(objUser.getAsMention() + " has voted to have __**"+ Ref.votes[voteCount].getVote()+ "!**__" ).queue();
    				Ref.votes[voteCount].voteY();
    			} else if(words[1].equalsIgnoreCase("no")) {
    				Ref.votes[voteCount].addPeopleWhoVoted(objUser.getName());
    				objMsgCh.sendMessage(objUser.getAsMention() + " has voted __**not**__ to have __**"+ Ref.votes[voteCount].getVote()+ "!**__" ).queue();
    				Ref.votes[voteCount].voteN();
    				}
    		}
    		if(words[1].equalsIgnoreCase("getWho") || words[1].equalsIgnoreCase("getWhoVoted") || words[1].equalsIgnoreCase("get")) {
    			objMsgCh.sendMessage(Ref.votes[voteCount].getPeopleWhoVoted() + " Have all voted!").queue();
    		}
    		if(words[1].equalsIgnoreCase("result") || words[1].equalsIgnoreCase("results")) {
    			objMsgCh.sendMessage( "__**"+Ref.votes[voteCount].getYvotes() + "**__ people have voted yes, and __**" 
    		+ Ref.votes[voteCount].getNvotes() + "**__ people have voted no.").queue();
    		}
    		if(words[1].equalsIgnoreCase("end") || words[1].equalsIgnoreCase("clear")) {
    			objMsgCh.sendMessage( "__**"+Ref.votes[voteCount].getYvotes() + "**__ people have voted yes, and __**" 
    		+ Ref.votes[voteCount].getNvotes() + "**__ people have voted no.").queue();
    		}
    		
    	}
    	/////////////////////////////////////////
    	}
    }
}
   

 



   

