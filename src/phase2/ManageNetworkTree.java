package phase2;

import phase1.StudentsList;


public class ManageNetworkTree implements IManageNetworkTree {

	
	/**
	 * It takes an object of the StudentsTree class 
	 * and an object of the StudentsList class (phase 1),
	 * and inserts each student from the list into the tree. 
	 * The method does not return anything. 
	 * @param tree
	 * @param list
	 */
	public void copySocialNetwork(StudentsTree tree, StudentsList list) {
		// Completed! Test Passed!
		
		for(int ii=0; ii<list.getSize();ii++) {
			tree.insertStudent(list.getAt(ii));
		}
		
		
	}
	/**
	 * This takes an object of the StudentsTree class and returns an object of the StudentsList class
	 *  containing all the students in the tree ordered by their email. 
	 *  Hint: You can develop an auxiliary and recursive method  
	 *  which takes a BSTNode object and a StudentsList object. 
	 *  You cannot use any sort algorithm to sort the resulting list. 
	 *  To obtain the list, you must traverse the tree (or subtree) in a recursive way. 
	 * @return
	 */
	public StudentsList getOrderedList(StudentsList list, BSTNode node){
		       
        if(node != null) {
        	getOrderedList(list, node.left);
        	list.addLast(node.oStudent);
        	getOrderedList(list, node.right);
        }
        
        return list;
    }
	
	public StudentsList getOrderedList(StudentsTree tree) {
		
		StudentsList returnList = new StudentsList();
		
		getOrderedList(returnList, tree.root);
		return returnList;
	}


	
	/**
	 * This class has a parameter n as input and removes all students having a number of blocks equal or greater than n.
	 * @param num
	 */
	
	public void deleteByNumberOfBlocks(StudentsTree tree,int num) {
       //To complete
		deleteByNumberOfBlocks(num, tree.root, tree);
		
	}
	private void deleteByNumberOfBlocks(int n,BSTNode node, StudentsTree tree) {
		if(node == null) {
			return;
		}else {
			if(node.oStudent.blocks >=n) {
				tree.removeStudent(node.oStudent.email);
			}
			deleteByNumberOfBlocks(n, node.left, tree);
			deleteByNumberOfBlocks(n, node.right, tree);
		}
	}
	

}
