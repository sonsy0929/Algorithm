#include <bits/stdc++.h>
using namespace std;
const int INF = 1e8;
const int SZ = 210;
int solution(int n, int s, int a, int b, vector<vector<int>> edges) {
    int dist[SZ][SZ];
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (i != j) dist[i][j] = INF;
            else dist[i][j] = 0;
        }
    }
    for (auto edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];    
        dist[u][v] = dist[v][u] = w; 
    }
    for (int k = 1; k <= n; k++) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
    int answer = INF;
    for (int i = 1; i <= n; i++) {
        answer = min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
    }
    return answer;
}