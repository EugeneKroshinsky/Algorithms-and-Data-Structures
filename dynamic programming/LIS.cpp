#include <iostream>
#include <fstream>

int main()
{
    std::ifstream fin("input.txt");
    std::ofstream fout("output.txt");

    int n;
    fin >> n;
    int* arr = new int[n];
    for (int i = 0; i < n; i++)
    {
        fin >> arr[i];
    }

    int* sub = new int[n];
    sub[0] = arr[0];
    int count = 1;
    for (int i = 1; i < n; i++) {
        int temp = std::upper_bound(sub, sub + count, arr[i]) - sub;
        if (arr[i] == sub[temp - 1]) 
        {
            continue;
        }
        if (temp == count)
        {
            sub[temp] = arr[i];
            count++;
        }
        else if (arr[i] < sub[temp])
        {
            sub[temp] = arr[i];
        }
    }
    fout << count;

    fin.close();
    fout.close();
    return 0;
}
