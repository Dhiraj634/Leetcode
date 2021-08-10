class Solution {
	public String addStrings(String num1, String num2) {
		int carry = 0;
		num1= new StringBuilder(num1).reverse().toString();
		num2= new StringBuilder(num2).reverse().toString();
		int minLen = Math.min(num1.length(), num2.length());
		StringBuilder sb = new StringBuilder();
		int i=0;
		for(;i<minLen;i++){
			int temp1 = num1.charAt(i) - '0';
			int temp2 = num2.charAt(i) - '0';
			int finalTemp = temp1 + temp2 + carry;
			carry = finalTemp /10;
			sb.append(finalTemp % 10);
		}
		while(i < num1.length()){
			int temp = (num1.charAt(i) - '0' + carry);
			sb.append(temp%10);
			carry = temp/10;
			i++;
		}
		while(i< num2.length()){
			int temp = (num2.charAt(i) - '0' + carry);
			sb.append(temp%10);
			carry = temp/10;
			i++;
		}
		if(carry > 0){
			sb.append(carry);
		}
		return sb.reverse().toString();

	}
}