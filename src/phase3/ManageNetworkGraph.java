package phase3;

import java.util.LinkedList;

public class ManageNetworkGraph implements IManageNetworkGraph {

	public LinkedList<String> students;
	LinkedList<LinkedList<Integer>> lst_of_lstAdjacents;

	public ManageNetworkGraph(String[] students) {
		this.students = new LinkedList<String>();
		for (int k = 0; k < students.length; k++) {
			this.students.add(students[k]);
		}

		// we must initialize each Integer list
		// each index i corresponds to a student, the function
		// getIndex is used to obtain the correspondence
		lst_of_lstAdjacents = new LinkedList<LinkedList<Integer>>();
		int num = this.students.size();
		for (int i = 0; i < num; i++) {
			lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
		}
	}

	// searches the student and returns its index
	public int getIndex(String student) {
		// COMPLETED
		int index = -1;
		index = students.indexOf(student); // we look into the students LinkedList
		return index;
	}

	// checks if index is right and returns its associated email
	public String checkVertex(int index) {
		// COMPLETED
		String toReturn = students.get(index);
		return toReturn;
	}

	public void addStudent(String student) {

		// COMPLETED! TEST PASSED
		if (student != null) {
			students.addLast(student); // We add the student to the student String LinkedList

			lst_of_lstAdjacents.addLast(new LinkedList<Integer>());
		}
	}

	/**
	 * It takes two students (emails) as input and creates a friendship relation
	 * between them. Keep in mind that friendship relation is a symmetric
	 * relationship.
	 * 
	 * @param studentA
	 * @param studentB
	 */
	public void areFriends(String studentA, String studentB) {

		// COMPLETED! TEST PASSED
		//Checking if both students exists.
		if (students.indexOf(studentA) >= 0 && students.indexOf(studentB) >= 0) {
			//Add a mutual relation.
			lst_of_lstAdjacents.get(students.indexOf(studentA)).addLast(students.indexOf(studentB));
			lst_of_lstAdjacents.get(students.indexOf(studentB)).addLast(students.indexOf(studentA));
		}
	}

	/**
	 * This takes a student (email), and returns an object of LinkedList<String>,
	 * which contains the e-mails of his/her direct friends.
	 * 
	 * @param studentA
	 * @return
	 */
	public LinkedList<String> getDirectFriends(String studentA) {

		LinkedList<String> lDirectFriends = new LinkedList<String>();
		//Looking if the student exist.
		if (students.indexOf(studentA) >= 0) {
			int num = lst_of_lstAdjacents.get(students.indexOf(studentA)).size();
			for (int ii = 0; ii < num; ii++) {
				//Adding direct friends.
				lDirectFriends.addLast(students.get(lst_of_lstAdjacents.get(students.indexOf(studentA)).get(ii)));
			}

		}
		return lDirectFriends;
	}

	public int[] getAdjacents(int i) {

		// int[] adjacents = lst_of_lstAdjacents.get(i).toArray() //This should work but
		// .toArray() returns an object instead of an integer.
		// COMPLETED! NO TEST AVAILABLE
		int[] adjacents = new int[lst_of_lstAdjacents.get(i).size()];
		for (int ii = 0; ii < adjacents.length; ii++) {
			adjacents[ii] = lst_of_lstAdjacents.get(i).get(ii);
		}
		return adjacents;
	}

	public LinkedList<String> suggestedFriends(String studentA) {

		//Completed! TEST PASSED!

		LinkedList<String> lSuggestedFriends = new LinkedList<String>();
		//Checking if the student is different from null
		if (studentA == null) {
			return lSuggestedFriends;
		} else {
			//Searching for suggested friends for studentA
			suggestedFriends(studentA, lSuggestedFriends);
			//Removing studentA and students that are already friends.
			lSuggestedFriends.removeAll(getDirectFriends(studentA));
			lSuggestedFriends.remove(studentA);
			//System.out.println(lSuggestedFriends.toString());
			return lSuggestedFriends;
		}
	}

	/**
	 * Recursive method to suggestFriends to studentA.
	 * @param studentA
	 * @param friend
	 * @param lSuggestedFriends
	 */
	private void suggestedFriends(String friend, LinkedList<String> lSuggestedFriends) {

		//Looking for direct friends.
		LinkedList<String> friends = getDirectFriends(friend);
		
		for (String elem : friends) {
			//Adding friends and looking for more.
			if (!lSuggestedFriends.contains(elem) && elem != friend) {
				lSuggestedFriends.add(elem);
				suggestedFriends(elem, lSuggestedFriends);
			}

		}

	}

	public LinkedList<Integer> depth(int i, boolean[] visited) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		return depth(i, visited, path);
	}

	protected LinkedList<Integer> depth(int i, boolean[] visited, LinkedList<Integer> path) {
		// COMPLETED
		
		visited[i]=true; //we have passed through this vertex, so we mark it
		path.addLast(i);
		
		int [] adjacents = getAdjacents(i); //the vertexes are obtained
		
		for(int AVertex: adjacents) {
			if(!visited[AVertex]) { //the method goes through the vertexes that have not been visited yet
				depth(AVertex, visited, path);  //we use recursion for every vertex
			}
		}
		
		return path;
	}

	public void show() {
		// COMPLETED! NO TEST!

		for (int i = 0; i < lst_of_lstAdjacents.size(); i++) {
			System.out.println("The friends of " + students.get(i) + "are: ");
			for (int k = 0; k < lst_of_lstAdjacents.get(k).size(); k++) {
				System.out.println(" " + getDirectFriends(checkVertex(k)));
			}
		}
	}

	public static void main(String args[]) {

	}

}