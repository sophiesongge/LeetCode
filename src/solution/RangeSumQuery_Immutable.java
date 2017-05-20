package solution;
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
		int[] nums;
		
	    public RangeSum(int[] nums) {
	        for(int i=1; i<nums.length; i++) {
	        	nums[i] = nums[i-1] + nums[i];
			}
			this.nums = nums;
	    }

	    public int sumRange(int i, int j) {
			if(i == 0) {
				return this.nums[j];
			}else {
				return this.nums[j] - this.nums[i-1];
			}
	    }
	}
}