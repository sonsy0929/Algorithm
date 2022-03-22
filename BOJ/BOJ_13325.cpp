#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
const int SZ = 1 << 21;
int K, eCount, edges[SZ], dp[SZ], eSum[SZ];
int f(int curr) {
    if (curr * 2 >= eCount) return dp[curr] = 0;
    int& ret = dp[curr];
    if (ret != -1) return ret;
    int l = curr * 2, r = curr * 2 + 1;
    ret = max(f(l) + edges[l], f(r) + edges[r]);
    eSum[curr] = eSum[l] + eSum[r] + (dp[curr] - dp[l]) + (dp[curr] - dp[r]);
    return ret;
}
int main() {
    fastio;
    cin >> K;
    eCount = 1 << (K + 1);
    for (int i = 2; i < eCount; i++) {
        cin >> edges[i];
    }
    memset(dp, -1, sizeof(dp));
    f(1);
    cout << eSum[1];
}