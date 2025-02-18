class Solution {
    void reverse(int i,int[] nums){
        int j=nums.length-1;
        while(i<j){
            int t=nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind=-1;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                ind=i-1;
                break;
            }
        }
        if(ind!=-1){
            for(int i=nums.length-1;i>ind;i--){
                if(nums[i]>nums[ind]){
                    int temp=nums[i];
                    nums[i]=nums[ind];
                    nums[ind]=temp;
                    break;
                }
            }
        }
        reverse(ind+1,nums);
    }
}