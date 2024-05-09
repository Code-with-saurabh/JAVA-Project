import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
interface methods{
		void AddTask();
		void RemoveTask();
		void WatchAllTask();
		void MarkAsComlited();
}


class task implements methods{
		Scanner sc = new Scanner(System.in);
	private  ArrayList<String> Task  = new ArrayList<String>();
	 
	void get_task(){
		System.out.println("Task : " + Task.get(0));
		System.out.println("Task : " + Task);
	}
	@Override
	public void AddTask(){
		System.out.print("Enter Task : ");
		String Task = sc.nextLine();
		System.out.println();
		this.Task.add(Task);
		if(Task != null){
			System.out.println("");	
			System.out.println("Task Added Suscessfuly");	
		}
		else{
			System.out.println("Task Not Added");	
		}
	}
	
	@Override
	public void RemoveTask(){
		try{
		if(Task.size() ==1){
			System.out.println(Task.get(0)+" Removed Sussesfully..");
			Task.remove(0);
		}	
		else if(Task.size() != 0){
		System.out.print("Enter The Number Of Task Which You Want to remove from the List :  ");	
		int index_remove = sc.nextInt();
		System.out.println();	
		System.out.println(Task.get(index_remove-1)+" Removed..");
		Task.remove(index_remove-1);
		}
		else{
			System.out.println("No Task in task list....");	
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("Please Enter A Vaid Task Number..\n");
			RemoveTask();
		}
		catch(InputMismatchException e){ 
		 System.out.println("\nInvalide Input Type....\n\n"); 
	 }
		catch(Exception e){
		 System.out.println("Somthing Want Wrong...");
		  
	 }
	}
	
	@Override
	public void WatchAllTask(){
		int ind=0;
		if(Task.size() != 0){
			
		for(String i : Task){
			ind++;
			System.out.println(ind+". "+i);
		 }
		}
		else{
			System.out.println("No Task In List...");
		}
	}
	@Override
	public void MarkAsComlited(){
		try{
		if(Task.size() ==1){
			System.out.println(Task.get(0)+" Mark As Compited..");
			Task.remove(0);
		}	
		else if(Task.size() != 0){
			System.out.print("Enter The Number Of Task Which You Want to Mark As Complited :  ");
			int index_complete = sc.nextInt();
			System.out.println();	
			System.out.println(Task.get(index_complete-1)+" Mark As Compited..");	
			
			Task.remove(index_complete-1);
		}
		else{
			System.out.println("No Task in task list....");	
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("Please Enter A Vaid Task Number..\n");
			MarkAsComlited();
		}catch(InputMismatchException e){ 
		 System.out.println("\nInvalide Input Type....\n\n"); 
		 } 
		catch(Exception e){
		 System.out.println("Somthing Want Wrong...");
	 }
	}
}



class TODO_GUI extends task{
	Scanner sc = new Scanner(System.in);
	TODO_GUI(){
		System.out.println("   			    ! TO-DO List Application !  ");
		System.out.println("   			    --------------------------   ");
		// System.out.println("   			    _______________________   ");
		System.out.print("\n");
		// OptionList();
	}
	void OptionList(){
		
		System.out.print("\n");
		System.out.println("   			_________________________________   \n");
		System.out.println("   			|				|\n");
        System.out.println("			| 1.Add Task               	|\n");
	    System.out.println("			| 2.Mark As Compete Task    	|\n");
	    System.out.println("			| 3.Watch Task			|\n");
	    // System.out.println("			| 4.List All Task\n");
	    System.out.println("			| 4.Remove Task			|\n");
	    System.out.println("			| 10.Exit			|\n");
	    // System.out.println("			| 10.Exit	  		 |\n");
		// System.out.print("\n");
		System.out.println("   			|				|");
		System.out.println("   			_________________________________   \n\n");
	}
	
	int for_input(){
		System.out.println();	
		System.out.print("Enter Your Choice : ");	
		System.out.println();	
		int i = sc.nextInt();
		return i;
	}
	
	//for cheking a error of infinite loop
	
	void BackEnd(){
		// int retry=3;
		try{
		// while(retry>0){
		while(true){
		OptionList();
		int i = for_input();
		switch(i){
			case 1 :
		        System.out.println();	
				AddTask();
			break;
			
			case 2 :
		        System.out.println();	
				MarkAsComlited();
			break;
			
			case 3 :
		        System.out.println();	
				WatchAllTask();
			break;
			
			case 4 :
		        System.out.println();	
				RemoveTask();
			break;
			case 10 : 
				System.out.print("Exiting program....");	
				System.out.println( );	System.out.println( );	
				System.out.println("\n\n 						   	   Created By Saurabh...\n"); 
				System.exit(0);
				break;
			default : 
				System.out.print("Wrong option Please Try Again....");	
				System.out.println( );	System.out.println( );	
				BackEnd();
				break;
		 }
		 
	}
		}catch(InputMismatchException e){ 
		 System.out.println("\nInvalide Input Type\n\n"+"Error : "+e+"\n\nExiting Program.....");
		 // retry--;
	 }
	 catch(Exception e){
		 System.out.println("Somthing Want Wrong...\n");
			// retry--;
	 }		
		
  }
  
}

class ToDo_List_Application{
	public static void main(String Saurabh[]){
		TODO_GUI Task = new TODO_GUI();
		Task.BackEnd();
		System.out.println("\n\n 						   	   Created By Saurabh...\n"); 
	}
}