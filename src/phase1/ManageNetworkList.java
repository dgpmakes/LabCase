package phase1;

import java.time.LocalDate;

public class ManageNetworkList implements IManageNetworkList {

	/**
	 * 1. The methods must join two social networks into a single social network. The
	 * method takes two objects of the StudentsList and returns a new list
	 * containing first the students from the first list followed by the students
	 * from the second list.
	 * 
	 * @param lst1
	 * @param lst2
	 * @return
	 */
	public StudentsList union(StudentsList lst1, StudentsList lst2) {
		
		//TODO: Completed! Test passed!
		
		StudentsList resultList = new StudentsList();
		for (DNode node = lst1.header.next; node != lst1.trailer; node = node.next) {
			resultList.addLast(node.elem);
		}
		for (DNode node = lst2.header.next; node != lst2.trailer; node = node.next) {
			resultList.addLast(node.elem);
		}
		return resultList;
	}

	/**
	 * 2. This method takes a social network as input and an integer parameter opc so
	 * that: - If opc =1: the method must return a StudentsList containing all the
	 * students residing in the same city that the campus where they are studying. -
	 * If opc =2: the method must return a StudentsList containing all the students
	 * residing in cities different that the one where their campus is located.
	 * 
	 * @param lst
	 * @param opc
	 * @return
	 */
	public StudentsList getCampusCity(StudentsList lst, int opc) {

		StudentsList l = new StudentsList();
		
		// Completed! and passed

		if (opc == 1) {
			for(DNode index = lst.header.next; index!=lst.trailer;index=index.next) {
				if((index.elem.city.equals(index.elem.campus.toString()))){
					l.addLast(index.elem);
				}
			}
		} else if (opc == 2) {
			for(DNode index=lst.header.next;index!=lst.trailer;index=index.next) {
				if((!index.elem.city.equals(index.elem.campus.toString()))){
					l.addLast(index.elem);
				}
			}
		} 
		return l;
	}


	/**
	 * 3. This methods takes a social network (that is an object of StudentsList class)
	 * and a city name as input and returns a list containing all the students (that
	 * is, an object of the StudentsList class) who live in that city.
	 * 
	 * @param lst
	 * @param city
	 * @return
	 */
	public StudentsList locateByCity(StudentsList lst, String city) {

		//TODO: COMPLETED!!! TEST PASSED!
		
		StudentsList l = new StudentsList();
		for(DNode node = lst.header.next; node!= lst.trailer; node= node.next) {
			if(node.elem.city==city) {
				l.addLast(node.elem);
			}
		}
		
		return l;

	}
	
	/**
	 * 4. This method takes a social network as input and a integer parameter opc so
	 * that: - If opc=1, the method returns a list of students sorted by ascending
	 * order according to their full name. - If opc=2, the method returns a lit of
	 * students sorted by descending order according to their full name. Note 1. You
	 * must implement your own sort method based on some of the sorted algorithms
	 * (such as bubble, sort). Note 2: Remember that you cannot modify or extend the
	 * StudentsList class. Therefore, if you need an auxiliary method that help you
	 * to sort the list, please include this method into the ManageNetwork class.
	 * Note 3. The input list cannot be modified. The method must return a new list
	 * where the students are sorted.
	 * 
	 * @param lst
	 * @param opc
	 * @return
	 */
	public StudentsList orderBy(StudentsList lst, int opc) {

		StudentsList sortedList = new StudentsList();
	    DNode temp;
	    
        //We check if the list is empty  
        if(lst.header == null) {  
            return null; 
        }
        
		if(opc==1) { //ASCENDING
		    for(DNode actualNode = lst.header; actualNode.next != null; actualNode = actualNode.next) {  
                for(DNode index = actualNode.next; index != null; index = index.next) {  
                    if(actualNode.elem.email.compareToIgnoreCase(index.elem.email)>0) {  
                        temp = actualNode;  
                        actualNode = index;  
                        index = temp;  
                    }  
                }  
            } 
		}else if(opc==2) { //DESCENDING
			for(DNode actualNode = lst.header; actualNode.next != null; actualNode = actualNode.next) {  
                for(DNode index = actualNode.next; index != null; index = index.next) {
                	
                    if(actualNode.elem.email.compareToIgnoreCase(index.elem.email)<0) {  
                        temp = actualNode;  
                        actualNode = index;  
                        index = temp;
                    }
                }
			}
		}

		return sortedList;
	}

	/**
	 * auxiliary method to insert student in a sorted way
	 * 
	 * @param lst
	 * @param newStudent
	 * @param opc
	 */
	public static void sortedInsert(StudentsList lst, Student newStudent, int opc) {
		
		if(opc == 1) {
			for(int i=0; i<lst.size;i++) {
				if(newStudent.email.compareToIgnoreCase(lst.getAt(i).email)<0) {
					lst.insertAt(i-1, newStudent);
				}
			}
		}
		
		if (opc==2) {
			for(int i=0; i< lst.size;i++) {	
				if(newStudent.email.compareToIgnoreCase(lst.getAt(i).email)>0) {
					lst.insertAt(i+1, newStudent);
				}
			}
		}
	}


	/**
	 * This takes a social network (an object of the StudentsList class) and two
	 * dates and returns the list of all students from the input list whose
	 * registration dates are in the interval of input dates. Please, take into
	 * account the following comments: - start <= end. - Both dates are included
	 * into the interval. - The order in the resulting list must be the same that in
	 * the input list.
	 * 
	 * @param lst
	 * @param start
	 * @param end
	 * @return
	 */
	public StudentsList getStudentsByDateInterval(StudentsList lst, LocalDate start, LocalDate end) {
		
		StudentsList resultList = new StudentsList();

		for(DNode node = lst.header.next; node!=lst.trailer;node=node.next) {
			
			if(start.isBefore(end)||start.equals(end)) {
				if(node.elem.date_sign_in.isEqual(start) || node.elem.date_sign_in.isEqual(end) || (node.elem.date_sign_in.isAfter(start) && node.elem.date_sign_in.isBefore(end))) {
					resultList.addLast(node.elem);
				}
			}
			
		}
		return resultList;

	}

	public static void main(String[] args) {

	}

}
