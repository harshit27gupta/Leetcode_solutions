class Solution {
    public String largestPalindrome(int n, int k) {
        StringBuilder ans = new StringBuilder();
        if(k == 1) {
            for(int i = 0; i < n; i++) ans.append(9);
        } else if(k == 2) {
            for(int i = 0; i < n; i++) {
                if(i == 0 || i == n-1) ans.append(8);
                else ans.append(9);
            }
        } else if(k == 3) {
            for(int i = 0; i < n; i++) ans.append(9);
        } else if(k == 4) {
            for(int i = 0; i < n; i++) {
                if(i == 0 || i == n-1 || i == 1 || i == n-2) ans.append(8);
                else ans.append(9);
            }
        } else if(k == 5) {
            for(int i = 0; i < n; i++) {
                if(i == 0 || i == n-1) ans.append(5);
                else ans.append(9);
            }
        } else if(k == 6) {
            if(n == 1) return "6";
            else if(n == 2) return "66";
            else if(n == 3) return "888";
            else if(n == 4) return "8778";
            else if(n == 5) return "89898";
            if(n%2==0) {
                for(int i = 0; i < n; i++) {
                    if(i == 0 || i == n-1) ans.append(8);
                    else if(i == n/2-1 || i == n/2) ans.append(7);
                    else ans.append(9);
                }
            } else {
                for(int i = 0; i < n; i++) {
                    if(i == 0 || i == n-1) ans.append(8);
                    else if(i == n/2) ans.append(8);
                    else ans.append(9);
                }
            }
        } else if(k == 7) {
            if(n%2==0) {
                if(n==2) return "77";
                for(int i = 0; i < n; i++) {
                    if(i == n/2 || i == n/2-1) {
                        if(n/2%6==0) {
                            ans.append(9);
                        } else if(n/2%6==1) {
                            ans.append(7);
                        } else if(n/2%6==2) {
                            ans.append(7);
                        } else if(n/2%6==3) {
                            ans.append(9);
                        } else if(n/2%6==4) {
                            ans.append(4);
                        } else if(n/2%6==5) {
                            ans.append(4);
                        }
                    }
                    else ans.append(9);
                }
            } else {
                if(n==1) return "7";
                for(int i = 0; i < n; i++) {
                    if(i == n/2) {
                        if(n/2%6==0) {
                            ans.append(7);
                        } else if(n/2%6==1) {
                            ans.append(5);
                        } else if(n/2%6==2) {
                            ans.append(7);
                        } else if(n/2%6==3) {
                            ans.append(4);
                        } else if(n/2%6==4) {
                            ans.append(6);
                        } else if(n/2%6==5) {
                            ans.append(4);
                        }
                    }
                    else ans.append(9);
                }
            }
        } else if(k == 8) {
            if(n == 1) return "8";
            else if(n == 2) return "88";
            else if(n == 3) return "888";
            else if(n == 4) return "8888";
            for(int i = 0; i < n; i++) {
                if(i == 0 || i == n-1 || i == 1 || i == n-2 || i == 2 || i == n-3) ans.append(8);
                else ans.append(9);
            }
        } else if(k == 9) {
            for(int i = 0; i < n; i++) ans.append(9);
        }
        return ans.toString();
    }
}