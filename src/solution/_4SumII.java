package solution;

import java.util.HashMap;
import java.util.Map;

public class _4SumII{
	
	public static void main(String[] args) {
		int[] A = new int[]{1, 2};
		int[] B = new int[]{-2,-1};
		int[] C = new int[]{-1, 2};
		int[] D = new int[]{0, 2};
		
		_4SumII test = new _4SumII();
		
		System.out.println(test.fourSumCount1(A, B, C, D));
		
		
	}
	
	//这道题被归类为binary search，但是其实我并没有想到binary search的方法，我觉得这个HashMap的方法并不是binary search
	
	//HashMap方法
	public int fourSumCount1(int[] A, int[] B, int[] C, int[] D){
		
		Map<Integer, Integer> map = new HashMap();
		
		for(int i=0; i<C.length; i++){
			for(int j=0; j<D.length; j++){
				int sum = C[i] + D[j];
				if(!map.containsKey(sum)){
					map.put(sum, 1);
				}else{
					map.put(sum, map.get(sum)+1);
				}
			}
		}
		
		int count = 0;
		
		for(int i=0; i<A.length; i++){
			for(int j=0; j<B.length; j++){
				int sum = -1 * (A[i] + B[j]);
				if(map.containsKey(sum)){
					count = count + map.get(sum);
				}
			}
		}
		return count;
	}
}