package phase3;

import java.util.LinkedList;

public interface IManageNetworkGraph {

	public int getIndex(String student);
	
	public String checkVertex(int index);
	
	public void addStudent(String student);
	
	public void areFriends(String studentA, String studentB);
	
	public LinkedList<String> getDirectFriends(String studentA);
	
	public int[] getAdjacents(int i);
	
	public LinkedList<String> suggestedFriends(String studentA);
		
	public void suggestedFriends(String friend, LinkedList<String> lSuggestedFriends);
	
	public LinkedList<Integer> depth(int i, boolean[] visited);
	
	public void show();
}
