#define _CRT_SECURE_NO_WARNINGS

#include <iostream>
#include <vector>

using namespace std;

struct myTree {
    long long leftGap;
    long long rightGap;
};


int main()
{
    FILE* input = fopen("bst.in", "r");
    FILE* output = fopen("bst.out", "w");

    int n;
    myTree tree;
    int temp, parent;
    char position;
    fscanf(input, "%d", &n);

    long long* key = new long long[n];

    fscanf(input, "%d", &temp);
    key[0] = temp;
    vector<myTree> gap;
    tree.leftGap = LONG_MIN;
    tree.rightGap = LONG_MAX;
    gap.push_back(tree);

    for (int i = 1; i < n; i++) {
        fscanf(input, "%d %d %c", &temp, &parent, &position);
        parent--;
        key[i] = temp;
        if (position == 'R') {
            tree.leftGap = key[parent];
            tree.rightGap = gap[parent].rightGap;
            gap.push_back(tree);
        }
        else {
            tree.leftGap = gap[parent].leftGap;
            tree.rightGap = key[parent] - 1;
            gap.push_back(tree);
        }

        if (temp < tree.leftGap || temp > tree.rightGap) {
            fprintf(output, "NO");
            return 0;
        }
    }
    fprintf(output, "YES");
    return 0;
}
