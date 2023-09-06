package LongFractions;

import java.math.BigDecimal;

public class Solution {
public static void main(String[] args) {
	Double n=1d;
	Double d=3d;
	BigDecimal db=new BigDecimal(n/d);
	System.err.println(db.toPlainString());
}
}
