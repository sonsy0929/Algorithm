#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
const int SZ = 50010;
int N, M, pSum[SZ], dp[4][SZ];
int main() {
    fastio;
    cin >> N;
    for (int i = 1, val; i <= N; i++) {
        cin >> val;
        pSum[i] = pSum[i-1] + val;
    }
    cin >> M;
    for (int i = 1; i <= 3; i++) {
        for (int j = i * M; j <= N; j++) {
            dp[i][j] = max(dp[i][j-1], dp[i-1][j-M] + pSum[j] - pSum[j-M]);
        }
    }
    cout << dp[3][N];
}