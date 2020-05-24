package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EnjoyQuarantine {
	
	private ArrayList<Account> accounts;
	
	private Activity activities;
	
	private MotivationalQuote rootmq;
	
	private HealthTip rootht;
	
	public EnjoyQuarantine() throws IOException {
		accounts = new ArrayList<Account>();
		loadInfoHealthTips();
		loadInfoMotivationalQuotes();
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
	
	public void addActivity(String text) {
		Activity toAdd = new Activity();
		toAdd.setText(text);
		if(activities==null) {
			activities = toAdd;
		}
		else {
			Activity aux = activities;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(toAdd);
			toAdd.setPrev(aux);
		}
	}

	public void loadInfoHealthTips() throws IOException{
		FileReader fr = new FileReader("data/health-tips.txt");
		BufferedReader br = new BufferedReader(fr);
		String l = br.readLine();
		String[] line = l.split(";");
		br.close();
		for(int i = 0; i<line.length;i++) {
			addHealthTip(line[i]);
		}
	}
	
	 public void addHealthTip(String text){
		  HealthTip act = new HealthTip();
		  act.setText(text);
		        if(rootht==null){
		        rootht=act;
		        }
		        else{
		        	if(rootht.getText().compareTo(act.getText())<0){
		        		if(rootht.getLeft()==null)
		        			rootht.setLeft(act);
		        		else {
		        			addHealthTip1(rootht.getLeft(),act);
		        		}
		            }
		            else{
		            	if(rootht.getRight()==null)
		        			rootht.setRight(act);
		        		else {
		        			addHealthTip1(rootht.getRight(),act);
		        		}
		            }
		        }
		    }
		    
		    private void addHealthTip1(HealthTip current,HealthTip newht){
		            if(newht.getText().compareTo(current.getText()) <= 0){
		             if(current.getLeft() == null){
		                current.setLeft(newht);
		             }
		             else{
		            	 addHealthTip1(current.getLeft(),newht);
		             }
		        }
		        else{
		             if(current.getRight() == null){
		                current.setRight(newht);
		             }
		             else{
		            	 addHealthTip1(current.getRight(),newht);
		             }
		        }
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
	
	
	public void loadInfoMotivationalQuotes() throws IOException{
		FileReader fr = new FileReader("data/motivational-quotes.txt");
		BufferedReader br = new BufferedReader(fr);
		String l = br.readLine();
		String[] line = l.split(";");
		br.close();
		for(int i = 0; i<line.length;i++) {
			addMotivationalQuote(line[i]);
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
