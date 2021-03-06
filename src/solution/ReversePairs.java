package solution;

/**
 * @author Sophie Song
 * @since 2017/5/5
 * https://leetcode.com/problems/reverse-pairs/#/description
 */
public class ReversePairs {
    //第一个方法采用了Binary Search Tree。但是这个Tree不是balanced，所以在最坏情况下它的复杂多是O(n^2)，过不了测试，会有一个TLE
/*

    private class Node {
        int val;
        int count; //以当前节点为根节点的子树种大于等于val的元素的数量
        Node left;
        Node right;

        public Node(int val){
            this.val = val;
            this.count = 1;
        }
    }

    private Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
        }else if (val == root.val) {
            root.count++;
        }else if (val < root.val){
            root.left = insert(root.left, val);
        }else{
            root.count++;
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int search(Node root, long val) {
        if(root == null){
            return 0;
        }else if(val == root.val) {
            return root.count;
        }else if(val < root.val) {
            return root.count + search(root.left, val);
        }else{
            return search(root.right, val);
        }
    }

    public int reversePairs(int[] nums) {
        int result = 0;
        Node root = null;

        for(int i : nums) {
            result = result + search(root, 2L*i + 1L);
            root = insert(root, i);
        }
        return result;
    }

    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();

        int[] nums = new int[]{1,3,2,3,1};
        System.out.println(test.reversePairs(nums));

        nums = new int[]{2,4,3,5,1};
        System.out.println(test.reversePairs(nums));

    }
*/

//第二个方法是MergeSort, 这个mergesort不是很好理解
/*
    private int mergeSort(int[] A, int start, int end) {
        if(start >= end) {
            return 0;
        }

        int mid = start + (end - start)/2;

        int count = mergeSort(A, start, mid) + mergeSort(A, mid+1, end);

        for(int left = start, right = mid+1; left <= mid; left++) {
            while(right <= end && A[left]/2.0 > A[right]) {
                right++;
            }
            count = count + right - (mid + 1);
        }
        Arrays.sort(A, start, end+1);
        return count;
    }

    public int reversePairs(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }


    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();

        int[] nums = new int[]{1, 3, 2, 3, 1};

        System.out.println(test.reversePairs(nums));

        nums = new int[]{2,4,3,5,1};
        System.out.println(test.reversePairs(nums));

    }*/

//这个方法还是MergeSort，这个好理解很多


    private void merge(int[] nums, int start, int mid, int end) {
        int[] helper = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            helper[i] = nums[i];
        }

        int left = start;
        int right = mid + 1;
        int index = start;

        while(left <= mid && right <= end) {
            if(helper[left] < helper[right]) {
                nums[index++] = helper[left++];
            }else{
                nums[index++] = helper[right++];
            }
        }

        while(left <= mid) {
            nums[index++] = helper[left++];
        }
    }

    private int mergeSort(int[] nums, int start, int end) {
        if(start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid+1, end);

        for(int left = start, right = mid+1; left<=mid; left++) {
            while(right <= end && nums[left]/2.0 > nums[right]) {
                right++;
            }
            count = count + right - (mid + 1);
        }
        merge(nums, start, mid, end);

        return count;
    }


    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        ReversePairs test = new ReversePairs();

        int[] nums = new int[]{1, 3, 2, 3, 1};

        System.out.println(test.reversePairs(nums));

        nums = new int[]{2,4,3,5,1};
        System.out.println(test.reversePairs(nums));

    }
}
