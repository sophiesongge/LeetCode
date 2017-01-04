public class NthInteger{
	public static void main(String[] args){
		NthInteger test = new NthInteger();
		System.out.println(test.findNthDigit1(100000000));
	}
	
	
	//This method will give a TLE
	public int findNthDigit1(int n) {
        int counter = 0;
        int pointer = 1;
        int results = 1;
        
        while(pointer <= n){
            String current = String.valueOf(pointer);
            int length = current.length();
            for(int j = 0; j<length; j++){
                if(counter == n){
                    break;
                }
                results = Character.getNumericValue(current.charAt(j));
                counter = counter + 1;
            }
            pointer++;
        }
        return results;
    }
	
	//Right answer
	public int findNthDigit(int n){
		
		
		return 0;
	}
	
}