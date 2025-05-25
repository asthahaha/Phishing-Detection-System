public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        
        int k = 1; 
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 4, 4, 5}; 
        int k = removeDuplicates(nums);
        
        System.out.println("Unique elements count: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}