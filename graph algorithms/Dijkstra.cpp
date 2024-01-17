#include <iostream>
#include <fstream>
#include <queue>
#include <vector>


using namespace std;


int main()
{
    ifstream in("input.txt");
    ofstream out("output.txt");
    long long n, m;
    in >> n >> m;
    vector<vector<vector<long long>>> matr(n);
    vector <long long> dist(n, LLONG_MAX);
    for (int i = 0; i < m; i++) {
        long long u, v, w;
        in >> u >> v >> w;
        matr[u - 1].push_back({v - 1, w});
        matr[v - 1].push_back({u - 1, w});
    }

    priority_queue<vector<long long>, vector<vector<long long>>, greater<vector<long long>>> queue;
    dist[0] = 0;
    queue.push({ 0, 0 });
    
    while (!queue.empty())
    {
        long long x = queue.top()[0];
        long long y = queue.top()[1];
        queue.pop();

        if (dist[y] != x) {
            continue;
        }

        for (int i = 0; i < matr[y].size(); i++)
        {
            if (dist[matr[y][i][0]] > dist[y] + matr[y][i][1])
            {
                dist[matr[y][i][0]] = dist[y] + matr[y][i][1];
                queue.push({ dist[matr[y][i][0]], matr[y][i][0]});
            }
        }
    }

    long long result = dist[n - 1] == LLONG_MAX ? -1 : dist[n - 1];
    out << result;

    return 0;
}
