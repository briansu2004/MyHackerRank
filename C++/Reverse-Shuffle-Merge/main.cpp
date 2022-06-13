#include <bits/stdc++.h>

using namespace std;

/*
 * Complete the 'reverseShuffleMerge' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

string reverseShuffleMerge(string str)
{
    int n = str.size();

    // initializing arrays
    int unused[26] = {0};
    int used[26] = {0};
    int required[26] = {0};
    char res[100000];
    int j = 0;

    // filling array mapping char freq
    for (int i = 0; i < n; i++)
    {
        unused[str[i] - 'a']++;
    }
    for (int i = 0; i < 26; i++)
    {
        required[i] = unused[i] / 2;
    }

    // last character
    char ch = str[n - 1];
    int ch_position = ch - 'a'; // index present in above arrays
    res[j++] = ch;
    unused[ch_position]--;
    used[ch_position]++;

    // rest of char
    // add ---- req is smaller than pres
    //  ch smaller
    // ch bigger

    for (int i = n - 2; i >= 0; i--)
    {
        ch = str[i];
        ch_position = ch - 'a';
        // to add or not
        if (used[ch_position] < required[ch_position])
        {
            // add char
            if (ch > res[j - 1])
            {
                res[j++] = ch;
                unused[ch_position]--;
                used[ch_position]++;
            }
            else
            {
                // check bigger ele -- we re
                // pop

                while (j > 0 && ch < res[j - 1] && used[res[j - 1] - 'a'] - 1 + unused[res[j - 1] - 'a'] >= required[res[j - 1] - 'a'])
                {
                    used[res[--j] - 'a']--;
                }
                res[j++] = ch;
                unused[ch_position]--;
                used[ch_position]++;
            }
        }
        else
        { // rejecting / discarding the perticulr char
            unused[ch_position]--;
        }
    }

    string r = "";
    for (int i = 0; i < n / 2; i++)
    {
        r += res[i];
    }
    return r;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string s;
    getline(cin, s);

    string result = reverseShuffleMerge(s);

    fout << result << "\n";

    fout.close();

    return 0;
}
