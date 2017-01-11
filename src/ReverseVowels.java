public class ReverseVowels{
	public static void main(String[] args){
		ReverseVowels test = new ReverseVowels();
		
		System.out.println(test.reverseVowels("hello"));
	}
	
	public String reverseVowels(String s){
		String vowels = "aeiouAEIOU";
		char[] sarray = s.toCharArray();
		
		int start = 0;
		int end = s.length() - 1;
		
		while(start < end){
			while(start < end && !vowels.contains(String.valueOf(sarray[start]))){
				start++;
			}
			while(start < end && !vowels.contains(String.valueOf(sarray[end]))){
				end--;
			}
			char temps = sarray[start];
			sarray[start] = sarray[end];
			sarray[end] = temps;
			return new String(sarray);
		}
		
		return new String(sarray);
	}
}