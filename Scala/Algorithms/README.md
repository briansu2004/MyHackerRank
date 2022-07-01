# MyHackerRank

My HackerRank

## z-algorithm / Z Array

 z-algorithm是一种字符串匹配算法，能够实现功能：对字符串S，O(n)地求出S的全体后缀与S自身的最长公共前缀的长度，记录在数组z[]中（z[i]即suffix i与S的最长公共前缀的长度）。

一、算法原理与实现

约定：

字符串S的下标从0开始；

S[i...j]代表字符串S[i]S[i+1]...S[j]；

suffix i代表S的以S[i]开头的后缀，即S[i...strlen(S)-1]。

算法的思路和manacher算法的思路类似，步骤如下：

0.初始令指针i=1，j=1；

1.若j<i，则j=i，比较S[j]与S[j-i]，若相等则j自增继续比较，若不等则停下，此时有z[i]=j-i且S[j]!=S[j-i]；

2.考虑利用S[0...j-i-1]与S[i...j-1]相等这个性质优化z[i+1...j-1]的计算。令指针k从i+1开始向后遍历，若k+z[k-i]<j，则z[k]=z[k-i]，否则停止遍历，令i=k，转步骤1。

这里解释一下步骤2：当k+z[k-i]<j时，由于S[k...k+z[k-i]]=S[k-i...k-i+z[k-i]]，所以suffix k的匹配结果与suffix k-i的匹配结果相同，所以z[k]=z[k-i]。

代码如下：

```c
# include<bits/stdc++.h>

using namespace std;
const int maxn=1e6+10;
int n,z[maxn];
char S[maxn];
void zjz()
{
 z[0]=n;
 int j=1,k;
 for (int i=1;i<n;i=k)
 {
  if (j<i) j=i;
  while (j<n&&S[j]==S[j-i]) j++;
  z[i]=j-i;
  k=i+1;
  while (k+z[k-i]<j)
  {
   z[k]=z[k-i];k++;
  }
 }
}
int main()
{
 scanf("%s",S);
 n=strlen(S);
 zjz();
 for (int i=0;i<n;i++) cout<<z[i]<<" ";
 return 0;
}
```

对时间复杂度的分析：由于指针i与j均以增加量1单调增加，所以指针i与j的移动次数都是O(n)，算法的时间复杂度与指针i与j的移动次数成正比，所以总时间复杂度为O(n)。

二、算法的应用

1.字符串匹配问题：给定一个模板串P和文本串T，问P在T的哪些位置出现。

令字符串S=P+'$'+T，对S跑一遍z-algorithm，z[strlen(P)+1...strlen(P)+strlen(T)]中值为strlen(P)的下标集全体元素减去strlen(P)+1即为所求位置集。

2.dutoj1087：给定2个字符串A和B，问A有多少后缀是B的前缀。

令字符串S=B+'$'+A，对S跑一遍z-algorithm，z[strlen(B)+1...strlen(B)+strlen(A)]中值不为0的元素的个数即为所求答案。

Z 函数（扩展 KMP）
约定：字符串下标以  为起点。
