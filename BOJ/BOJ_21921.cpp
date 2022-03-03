#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
const int SZ = 250010;
int N, X, V[SZ];
int main() {
    fastio;
    cin >> N >> X;
    for (int i = 1; i <= N; i++) {
        cin >> V[i];
    }
    int mx = 0, sum = 0, dup = 0;
    for (int i = 1; i <= N; i++) {
        sum += V[i];
        if (i > X) sum -= V[i - X];
        if (mx < sum) mx = sum, dup = 1;
        else if (mx == sum) dup++;
    }
    if (mx == 0) cout << "SAD";
    else cout << mx << "\n" << dup;
}