package exam01;

import java.util.*;

public class PosIntSet {

private ArrayList<Integer> list = new ArrayList<Integer>();


public boolean contains(int n){
	for(Integer x : list)
		if(x == n)
			return true;
	return false;			
}

public ArrayList<Integer> getElements(){
	return list;
}

public boolean add(int n){
	if(n > 0 && !contains(n))
		return list.add(n);
	else return false;
}


public int union(PosIntSet other){
int total_added = 0;

for(Integer x : other.list)
	if(add(x))
		total_added++;
return total_added;
}


public int size(){
int total = 0;
for(Integer x : list)
	total++;
return total;

}




}
