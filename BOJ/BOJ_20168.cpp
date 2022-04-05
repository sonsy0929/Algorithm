#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
using p = pair<int, int>;
const int INF = 1e9;
int N, M, S, E, C, answer = INF;
bool visited[15];
vector<int> used;
vector<p> edges[15];
void f(int curr, int dist) {
    if (dist > C) return;
    if (curr == E && dist <= C) {
        int maxCost = 0;
        for (int w : used) {
            maxCost = max(maxCost, w);
        }
        answer = min(answer, maxCost);
        return;
    }
    for (auto [next, w] : edges[curr]) {
        if (visited[next]) continue;
        visited[next] = true;
        used.push_back(w);
        f(next, dist + w);
        visited[next] = false;
        used.pop_back();
    }
}
int main() {
    fastio;
    cin >> N >> M >> S >> E >> C;
    for (int i = 1, u, v, w; i <= M; i++) {
        cin >> u >> v >> w;
        edges[u].push_back({v, w});
        edges[v].push_back({u, w});
    }
    f(S, 0);
    if (answer != INF) cout << answer;
    else cout << -1;
}