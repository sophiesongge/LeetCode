public class RangeSumQuery_Mutable{
	
	static class RangeSum{
		int[] nums;
		int[] BIT;
		int n;
		
		public static void main(String[] args){
			int[] num = new int[10];
			for(int i=0; i<10; i++){
				num[i] = i + 1;
			}
			RangeSum rs = new RangeSum(num);
			
			//rs.update(0, 1);
			
			System.out.println("!!!!!!");
			for(int i=1; i<=rs.n; i++){
				System.out.print(rs.BIT[i] + " ");
			}
			System.out.println("\n"+"~~~~~~~");
			
			System.out.println(rs.getSum(9));
		}
		
		public RangeSum(int[] nums){
			this.nums = nums;
			this.n = nums.length;
			this.BIT = new int[n+1];
			initiateBIT();
		}
		
		public int lowestBit(int x){
			return x & -x;
		}
		
		public void initiateBIT(){
			for(int i=1; i<=n; i++){
				this.BIT[i] = 0;
				for(int j = i; j > i - lowestBit(i); j--){
					this.BIT[i] = this.BIT[i] + nums[j-1];
				}
			}
		} 
		
		//每次都只有后继节点会根据当前节点的变化而变化， 所以步长是i + lowestBit(i)
		public void update(int index, int val){
			for(int i = index + 1; i <= this.n; i = i + lowestBit(i)){
				this.BIT[i] = this.BIT[i] + val;
			}
		}
		
		//和为所有前驱节点相加， 所以步长是i - lowestBit(i)
		public int getSum(int k){
			int sum = 0;
			for(int i = k + 1; i > 0; i = i - lowestBit(i)){
				sum = sum + this.BIT[i];
			}
			return sum;
		}
		
		public int getRangeSum(int i, int j){
			return getSum(j) - getSum(i);
		}
	}
}