package datetostring;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String [] args) {
		List<String> codeOp = new ArrayList<String>();
		codeOp.add(Const.ADD);
		codeOp.add(Const.UPDATE);
		for(int i=0;i<codeOp.size();i++){
			System.out.println(codeOp.get(i));
		}
	}
}
