package phase3;

import java.util.LinkedList;



public class ManageNetworkGraph implements IManageNetworkGraph {
	
	
	
	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;
		
	public ManageNetworkGraph(String[] students) {
			this.students=new LinkedList<String>();
			for(int k=0; k < students.length; k++) {
				this.students.add(students[k]);
			}
			
			//we must initialize each Integer list
			//each index i corresponds to a student, the function
			//getIndex is used to obtain the correspondence
			lst_of_lstAdjacents=new LinkedList<LinkedList<Integer>>();
			int num=this.students.size();
			for (int i=0; i<num; i++) {
				lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
			}
	}
	
	//searches the student and returns its index
	public int getIndex(String student) {
		int index=-1;
		
		//to compplete

		return index;
	}
	//checks if index is right and returns its associated city
	public String checkVertex(int index) {
		//to complete
		return null;
	}
	
	/**
	 * It takes taking two students (emails) as input and 
	 * creates a friendship relation between them. 
	 * Keep in mind that friendship relation is a symmetric relationship.
	 */
	public void addStudent(String student) {
		
		//To complete
	}
	
	/**
	 * It takes two students (emails) as input and creates a friendship 
	 * relation between them. Keep in mind that friendship relation is a symmetric relationship.
	 * @param studentA
	 * @param studentB
	 */
	public void areFriends(String studentA, String studentB) {
		
	
		//To complete
	}

	/**
	 * This takes a student (email), and returns an object of LinkedList<String>, 
	 * which contains the emails of his/her direct friends.
	 * @param studentA
	 * @return
	 */
	public LinkedList<String> getDirectFriends(String studentA){
		
		LinkedList<String> lDirectFriends = new LinkedList<String>();
		//to complete
		
		return lDirectFriends;
	}
	
	
	
	public int[] getAdjacents(int i) {
		//to complete
		return null;
	}
	
	
	
	public LinkedList<String> suggestedFriends(String studentA){
		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		//to complete
		return lSuggestedFriends;
	}
	
	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path=new LinkedList<Integer>();
		return depth(i,visited, path);
	}
	

	protected LinkedList<Integer> depth(int i,boolean[] visited, LinkedList<Integer> path) {
		//to compelte
		return path;
	}
	
	public void show() {
		//to complate
	}
	
	public static void main(String args[]) {
		
	}
	
}
