package solution;

/**
 * @author Sophie Song
 * @since 2017/5/10
 */
public class test {

    public void merge(int[] nums, int start, int mid, int end) {
        int[] temps = new int[nums.length];

        for(int i=0; i<nums.length; i++) {
            temps[i] = nums[i];
        }

        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;

        while(leftIndex <= mid && rightIndex <= end) {
            if(temps[leftIndex] <= temps[rightIndex]) {
                nums[index++] = temps[leftIndex++];
            }else {
                nums[index++] = temps[rightIndex++];
            }
        }

        while(leftIndex <= mid) {
            nums[index++] = temps[leftIndex++];
        }
    }

    public void sort(int[] nums, int start, int end) {
        if(start < end) {
            int mid = start + (end - start)/2;
            sort(nums, start, mid);
            sort(nums, mid+1, end);
            merge(nums, start, mid, end);
        }
    }

    public void mergeSort(int[] nums) {
        sort(nums, 0, nums.length-1);
    }

    public static void main(String[] args){

        System.out.println("!!!! " + (3 + (4-3)/2));

        int n = 100;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = n-i-1;
            System.out.print(arr[i]+" ");
        }

        test t = new test();

        System.out.println();

        t.mergeSort(arr);

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }
}
