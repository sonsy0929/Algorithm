#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
using ll = long long;
const int SZ = 100010;
const int ANSMAX = 1e9;
const ll INF = 1e18;
struct Edge {
    int v;
    ll cost;
    bool operator<(const Edge& oth) const {
        return cost > oth.cost;
    }
};
int N, M; ll C;
vector<Edge> adj[SZ];
bool dijk(int start, int end, int value) {
    priority_queue<Edge> pq;
    vector<ll> dist(SZ);
    fill(all(dist), INF);
    dist[start] = 0;
    pq.push({start, 0});
    while (!pq.empty()) {
        auto [curr, cost] = pq.top();
        pq.pop();
        if (cost > dist[curr]) continue;
        for (auto [next, w] : adj[curr]) {
            if (w > value) continue;
            if (dist[next] > dist[curr] + w) {
                dist[next] = dist[curr] + w;
                pq.push({next, dist[next]});
            }
        }
    }
    return dist[end] <= C;
}
int main() {
    fastio;
    int start, end;
    cin >> N >> M >> start >> end >> C;
    for (int i = 1, u, v, w; i <= M; i++) {
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        adj[v].push_back({u, w});
    }
    int lo = 0, hi = ANSMAX + 10;
    while (lo + 1 < hi) {
        int mid = (lo + hi) / 2;
        if (dijk(start, end, mid)) hi = mid;
        else lo = mid;
    }
    if (hi > ANSMAX) cout << -1;
    else cout << hi;
}