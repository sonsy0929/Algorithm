#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
using ll = long long;
const int SZ = 100010;
ll N, M;
vector<ll> times;
bool f(ll param) {
    ll cnt = 0;
    for (ll time : times) {
        cnt += param / time;
    }
    return cnt >= M;
}
int main() {
    fastio;
    cin >> N >> M;
    for (int i = 0, time; i < N; i++) {
        cin >> time;
        times.push_back(time);
    }
    sort(all(times));
    ll lo = 0, hi = times.back() * M;
    while (lo + 1 < hi) {
        ll mid = (lo + hi) / 2;
        if (f(mid)) hi = mid;
        else lo = mid;
    }
    cout << hi;
}