package solution;

/**
 * @author Sophie Song
 * @since 2017/6/8
 */
public class NextPermutation {

    public static void main(String[] args){
        NextPermutation test = new NextPermutation();
        int[] nums = new int[]{1, 5, 1};

        test.nextPermutation(nums);

        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return;
        }

        int index = n - 1;
        while(index > 0) {
            if(nums[index-1] < nums[index]) {
                break;
            }
            index--;
        }

        if(index == 0) {
            swap(nums, 0, n-1);
            return;
        }else{
            int val = nums[index-1];
            int j = n-1;

            while(j >= index) {
                if(nums[j] > val) {
                    break;
                }
                j--;
            }
            swap(nums, index-1, j);
            reverseSort(nums, index, n-1);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverseSort(int[] nums, int start, int end) {
        if(start > end) {
            return;
        }

        for(int i = start; i<=(start + end)/2; i++) {
            swap(nums, i, end - (i - start));
        }
    }
}
