import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class MyResizeableArray{
	public ArrayList<String> resizeableArray = new ArrayList<>();
	public class Comp implements Comparator<String>{
		public int compare(String o1, String o2) {
			//char s0= (char)o1[0];
			if(o1.length()>o2.length()) {
				return 1;
			}
			else return -1;
		}
	}
	public void add_to_array(String newString) {
		this.resizeableArray.add(newString);
	}
	public void modifyAtSpecificString(String orginal,String replaceString) {
		Iterator iterator = this.resizeableArray.iterator();
		int index = 0;
		while(iterator.hasNext()) {
			String tempString = (String) iterator.next();
			if(tempString == orginal) {
				break;
			}
			index++;
		}
		this.resizeableArray.set(index, replaceString);
	}
	public void  addTo(String moreString) {
		this.resizeableArray.add(moreString);
	}
	public void transerve() {
		Iterator iterator = this.resizeableArray.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	public void remove(String removedString) {
		Iterator iterator = this.resizeableArray.iterator();
		int index = 0;
		while(iterator.hasNext()) {
			String tempString = (String)iterator.next();
			if(tempString==removedString) {
				break;
			}
			index++;
		}
		this.resizeableArray.remove(index);
	}
	public void removeDirectly(String removedString) {
		this.resizeableArray.remove(removedString);
	}
	public void  sort() {
		this.resizeableArray.sort(new Comp());
//		this.transerve();
	}
	/*
	 * Take an element : O(1)
	 * Add an element to : O(1)
	 * Remove an element ; O(n)
	 * Sort :  nlogn 
	 */
}