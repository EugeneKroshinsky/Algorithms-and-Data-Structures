#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <vector>
#include <fstream>
#include <stack>

using namespace std;

int findSet(int x, vector<int> &parent) {
    if (parent[x] == x) {
        return x;
    }
    parent[x] = findSet(parent[x], parent);
    return parent[x];
}

void unionSet(int x, int y, vector<int> &size, vector<int> &parent) {
    int rootX = findSet(x, parent);
    int rootY = findSet(y, parent);
    if (rootX != rootY) {
        if (size[rootX] < size[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
        }
        else {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
}

int main() {
    ofstream out("output.txt");
    ifstream in("input.txt");
    vector <int> parent(100001), size(100001, 1);
    
    int n, m, q;

    in >> n;
    in >> m;
    in >> q;

    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }

    vector<vector<int>> roads(100001);
    for (int i = 0; i < m; i++) {
        int u, v;
        in >> u >> v;
        roads[i] = vector<int>{ u - 1 , v - 1 };
    }


    vector<bool> isRoadnumber(100001);
    vector<int> roadNumber(100001);
    for (int i = q - 1; i >= 0; i--) {
        int temp;
        in >> temp;
        roadNumber[i] = temp - 1;
        isRoadnumber[temp - 1] = true;
    }

    for (int i = 0; i < m; i++) {
        if (!isRoadnumber[i]) {
            unionSet(roads[i][0], roads[i][1], size, parent);
        }
    }
    
 


    stack<int> result;
    for (int i = 0; i < q; i++) {
        int index = findSet(1, parent);
        if (size[index] == n) {
            result.push(1);
        }
        else {
            result.push(0);
        }
        unionSet(roads[roadNumber[i]][0], roads[roadNumber[i]][1], size, parent);
    }

    while (!result.empty()) {
        out << result.top();
        result.pop();
    }
    out.close();
    in.close();
    return 0;
}
