#include <bits/stdc++.h>
using namespace std;
const int SZ = 17;
int N, wolfs[SZ], dp[1 << SZ];
bool visited[1 << SZ];
struct node {
    int left, right;
    node() {}
    node(int l, int r) : left(l), right(r) {}
} tree[SZ];
int f(int state) {
    int& ret = dp[state];
    if (ret != -1) return ret;
    ret = 0;
    int wolf = 0;
    for (int i = 0; i < N; i++) {
        if (state & (1 << i)) {
            ret += !wolfs[i];
            wolf += wolfs[i];
        }
    }
    if (wolf >= ret) return 0;
    for (int i = 0; i < N; i++) {
        if (~state & (1 << i)) continue;
        auto [l, r] = tree[i];
        if (l) ret = max(ret, f(state | (1 << l)));
        if (r) ret = max(ret, f(state | (1 << r)));
    }
    return ret;
}
int solution(vector<int> info, vector<vector<int>> edges) {
    N = info.size();
    for (int i = 0; i < N; i++) {
        wolfs[i] = info[i];
    }
    memset(dp, -1, sizeof(dp));
    for (auto edge : edges) {
        int u = edge[0], v = edge[1];
        if (tree[u].left == 0) tree[u].left = v;
        else tree[u].right = v;
    }
    return f(1);
}