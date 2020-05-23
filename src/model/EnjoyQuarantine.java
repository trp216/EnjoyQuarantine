package model;

import java.util.ArrayList;

public class EnjoyQuarantine {
	
	private ArrayList<Account> accounts;
	
	private Activity activities;
	
	private MotivationalQuote rootmq;
	
	public EnjoyQuarantine() {
		accounts = new ArrayList<Account>();
	}

	public void addAccount(String username, String name, String password, String birthdate, String gender, double height,
			double weight, boolean isPremium) {
		
		if(isPremium==true) {
			accounts.add(new PremiumAccount(username, name, password, birthdate, gender, height, weight));
		}
		else {
			accounts.add(new FreeAccount(username, name, password, birthdate, gender, height, weight));
		}
	}
	
	  public void addMotivationalQuote(String text){
		  MotivationalQuote act = new MotivationalQuote();
		  act.setText(text);
		        if(rootmq==null){
		        rootmq=act;
		        }
		        else{
		        	if(rootmq.getText().compareTo(act.getText())<0){
		        		if(rootmq.getLeft()==null)
		        			rootmq.setLeft(act);
		        		else {
		            		addMotivationalQuote1(rootmq.getLeft(),act);
		        		}
		            }
		            else{
		            	if(rootmq.getRight()==null)
		        			rootmq.setRight(act);
		        		else {
		            		addMotivationalQuote1(rootmq.getRight(),act);
		        		}
		            }
		        }
		    }
		    
		    private void addMotivationalQuote1(MotivationalQuote current,MotivationalQuote newmq){
		            if(newmq.getText().compareTo(current.getText()) <= 0){
		             if(current.getLeft() == null){
		                current.setLeft(newmq);
		             }
		             else{
		            	 addMotivationalQuote1(current.getLeft(),newmq);
		             }
		        }
		        else{
		             if(current.getRight() == null){
		                current.setRight(newmq);
		             }
		             else{
		            	 addMotivationalQuote1(current.getRight(),newmq);
		             }
		        }
		    }
}
