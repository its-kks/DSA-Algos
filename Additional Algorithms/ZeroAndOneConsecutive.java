public class ZeroAndOneConsecutive {
    public static void main(String args[]){
        Solution temp=new Solution();
        System.out.println(temp.maxSubStr("101000001111"));
    }
}
class Solution {
    public int maxSubStr(String str) {
        if(str.charAt(str.length()-1)=='0'){
            str+='1';
        }
        else{
            str+='0';
        }
        int countZero = 0;
        int countOne = 0;
        char firstCount = 'n';
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (countZero == 0 && countOne == 0) {
                firstCount = str.charAt(i);
            }
            if (countZero > 0 && countOne > 0 && str.charAt(i) != firstCount) {
                // count next allowed
                if (str.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
                continue;
            } else if (countZero == 0 || countOne == 0) {
                if (str.charAt(i) == '0') {
                    countZero++;
                } else {
                    countOne++;
                }
                continue;
            } else {
                // reset and add to ans
                i--;
                if (countZero != countOne) {
                    if (countZero > countOne) {
                        // countZero big
                        if (firstCount != '0') {
                            i -= countZero - countOne;
                        }
                        else{
                            ans=-1;
                            return ans;
                        }

                    } else {
                        // count one big
                        if (firstCount != '1') {
                            i -= countOne - countZero;
                        }
                        else{
                            ans=-1;
                            return ans;
                        }
                    }
                }
                ans++;
                    countZero = 0;
                    countOne = 0;
                }
            }
        if(countZero>=1 && countOne>=1){
            ans=-1;
        }
        return ans;
    }
}