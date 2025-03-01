class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        int [][] dp=new int [n+1][m+1];
        for(int i=0;i<n+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<m+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        int i=str1.length();
        int j=str2.length();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>=dp[i][j]){
                sb.append(str1.charAt(i-1));
                i--;
            }
            else{
                sb.append(str2.charAt(j-1));
                j--;
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        sb.reverse();
        return sb.toString();

        
    }

    // public static int lcs(String s,String t,int s1,int s2){
    //     if(s1==s.length() || s2==t.length()) return 0;

    //     if(s.charAt(s1)==t.charAt(s2)){
    //         return 1+lcs(s,t,s1+1,s2+1);
    //     }
    //     else{
    //         return Math.max(lcs(s,t,s1+1,s2),lcs(s,t,s1,s2+1));
    //     }
    // }
}