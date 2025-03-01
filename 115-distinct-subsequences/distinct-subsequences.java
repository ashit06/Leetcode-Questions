class Solution {
    public int numDistinct(String s, String t) {
        int [][]memo=new int [s.length()+1][t.length()+1];
        for(int [] a:memo){
            Arrays.fill(a,-1);
        }
        return helper(s,t,s.length()-1,t.length()-1,memo);
    }
    public static int helper(String s,String t,int s1,int s2,int [][] memo){
        if(s2<0) return 1;
        if(s1<0) return 0;
        if(memo[s1][s2]!=-1) return memo[s1][s2];
        int ways=0;
        if(s.charAt(s1)==t.charAt(s2)){
            ways+=helper(s,t,s1-1,s2-1,memo);
            ways+=helper(s,t,s1-1,s2,memo);
        }
        else{
            ways+=helper(s,t,s1-1,s2,memo);
        }
        return memo[s1][s2]=ways;
    }
}