package model;

import java.util.ArrayList;

public class EnjoyQuarantine {
	
	private ArrayList<Account> accounts;
	
	private Activity activities;
	
	private MotivationalQuote rootmq;
	
	public EnjoyQuarantine() {
		accounts = new ArrayList<Account>();
	}
	
	

	public ArrayList<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}



	public Activity getActivities() {
		return activities;
	}



	public void setActivities(Activity activities) {
		this.activities = activities;
	}



	public MotivationalQuote getRootmq() {
		return rootmq;
	}



	public void setRootmq(MotivationalQuote rootmq) {
		this.rootmq = rootmq;
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
		
	public void bubbleSortN() {
		for(int i = accounts.size();i>0;i--) {
			for(int j=0;j<i-1;j++) {
				if(accounts.get(j).getName().compareTo(accounts.get(j+1).getName())>0) {
					Account temp = accounts.get(j);
					accounts.set(j, accounts.get(j+1));
					accounts.set(j+1, temp);
				}
			}
		}
	}
	
	public void bubbleSortH() {
		for(int i = accounts.size();i>0;i--) {
			for(int j=0;j<i-1;j++) {
				if(accounts.get(j).getHeight()>accounts.get(j+1).getHeight()) {
					Account temp = accounts.get(j);
					accounts.set(j, accounts.get(j+1));
					accounts.set(j+1, temp);
				}
			}
		}
	}
	
	public void selectionSortU() {
		for(int i = 0; i<accounts.size();i++) {
			Account minor = getAccounts().get(i);
			int which = i;
			for(int j = i+1;j<accounts.size();j++) {
				if(accounts.get(j).getUsername().compareTo(minor.getUsername())<0) {
					minor = accounts.get(j);
					which = j;
				}
			}
			Account temp = accounts.get(i);
			accounts.set(i, minor);
			accounts.set(which, temp);
		}
	}
	
	public void selectionSortW() {
		for(int i = 0; i<accounts.size();i++) {
			Account minor = getAccounts().get(i);
			int which = i;
			for(int j = i+1;j<accounts.size();j++) {
				if(accounts.get(j).getWeight()<minor.getWeight()) {
					minor = accounts.get(j);
					which = j;
				}
			}
			Account temp = accounts.get(i);
			accounts.set(i, minor);
			accounts.set(which, temp);
		}
	}
	
	public void insertionSortH() {
		for(int i = 1;i<accounts.size();i++) {
			for(int j = i;j > 0 && accounts.get(j-1).getHeight()>accounts.get(j).getHeight();j--) {
				Account temp = accounts.get(i);
				accounts.set(j, accounts.get(j-1));
				accounts.set(j-1, temp);
			}
		}
	}
	
	public void insertionSortU() {
		for(int i = 1;i<accounts.size();i++) {
			for(int j = i;j > 0 && accounts.get(j-1).getUsername().compareTo(accounts.get(j).getUsername())>0;j--) {
				Account temp = accounts.get(i);
				accounts.set(j, accounts.get(j-1));
				accounts.set(j-1, temp);
			}
		}
	}
}
