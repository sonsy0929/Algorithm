#include <bits/stdc++.h>
#define fastio ios::sync_with_stdio(false), cin.tie(0)
#define x first
#define y second
#define all(v) v.begin(), v.end()
using namespace std;
bool isNumber(char c) {
    return c >= '0' && c <= '9';
}
int main() {
    fastio;
    string S, T, out;
    cin >> S >> T;
    for (char c : S) {
        if (isNumber(c)) continue;
        out += c;
    }
    if (out.find(T) == string::npos) cout << "0";
    else cout << "1";
}