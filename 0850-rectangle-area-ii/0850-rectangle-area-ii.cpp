const int MOD = 1000000007;

class Solution {
public:
    int rectangleArea(vector<vector<int>>& recs) {
        long long res = 0;
        
        while (!recs.empty()) {
            vector<vector<int>> tmp;
            //cout<<recs[0][0]<<" "<<recs[0][1]<<" "<<recs[0][2]<<" "<<recs[0][3]<<endl;
            res += (long long)(recs[0][2] - recs[0][0])*(recs[0][3] - recs[0][1]);
            res %= MOD;
            for (int j = 1; j < recs.size(); j++) {
                int x1 = max(recs[0][0], recs[j][0]);
                int x2 = min(recs[0][2], recs[j][2]);
                int y1 = max(recs[0][1], recs[j][1]);
                int y2 = min(recs[0][3], recs[j][3]);
                if (y2 > y1 and x2 > x1) {
                    if (recs[j][3] > recs[0][3]) {
                        x1 = max(recs[0][0], recs[j][0]);
                        x2 = min(recs[0][2], recs[j][2]);
                        tmp.push_back({x1, recs[0][3], x2, recs[j][3]});
                    }
                    if (recs[j][1] < recs[0][1]) {
                        x1 = max(recs[0][0], recs[j][0]);
                        x2 = min(recs[0][2], recs[j][2]);
                        tmp.push_back({x1, recs[j][1], x2, recs[0][1]});
                    }
                    if (recs[j][0] < recs[0][0]) {
                        tmp.push_back({recs[j][0], recs[j][1], recs[0][0], recs[j][3]});
                    }
                    if (recs[j][2] > recs[0][2]) {
                        tmp.push_back({recs[0][2], recs[j][1], recs[j][2], recs[j][3]});
                    }
                } else {
                    tmp.push_back(recs[j]);
                }
            }
            recs = tmp;
        }
        return res;
    }
};