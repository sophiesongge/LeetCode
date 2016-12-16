public class RangeSumQuery_Immutable{
	
	public static void main(String[] args){
		int[] nums = new int[100];
		
		for(int i=1; i<=100; i++){
			nums[i-1] = i;
		}
		RangeSum rs = new RangeSum(nums);
		
		System.out.println(rs.sumRange(1, 99));
	}
	
	static class RangeSum{
		int[] sums;
		
	    public RangeSum(int[] nums) {
	        this.sums = new int[nums.length];
	        for(int i=0; i<sums.length; i++){
	        	int sum = 0;
	        	for(int j=0; j<=i; j++){
	        		sum += nums[j];
	        	}
	        	sums[i] = sum;
	        }
	    }

	    public int sumRange(int i, int j) {
	        return sums[j] - sums[i-1];
	    }
	}
}