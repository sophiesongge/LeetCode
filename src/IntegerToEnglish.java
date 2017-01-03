public class IntegerToEnglish{
	
	private String[] LESS10 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private String[] LESS20 = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"};
    private String[] TENS = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0){
            return "Zero";
        }
        return helper(num);
    }
    
    public String helper(int num){
        String words = "";
        if(num < 10){
            words = LESS10[num];
        }else if(num < 20){
            words = LESS20[num%10];
        }else if(num < 100){
            words =  TENS[num/10] + " " + helper(num%10);
        }else if(num < 1000){
            words = helper(num/100) + " Hundred " + helper(num%100);
        }else if(num < 1000000){
            words = helper(num/1000)+" Thousand "+helper(num%1000);
        }else if(num < 1000000000){
            words = helper(num/1000000)+" Million "+helper(num%1000000);
        }else{
            words = helper(num/1000000000)+" Billion "+helper(num%1000000000);
        }
        return words.trim();
    }
}