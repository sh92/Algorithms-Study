#include <vector>
using namespace std;
const int MIN = numeric_limits<int>::min();

int fastMaxSum(const vector<int>& A, int lo, int hi)
{
    if (lo ==hi) return A[lo];
    int mid = (lo+hi)/2;
    int left = MIN, right =MIN, sum=0;
    for(int i =mid;i>=lo;i--)
    {
        sum+=A[i];
        left = max(left,sum);
    }
    sum=0;
    for(int j=mid+1;j<=hi;++j){
        sum+=A[j];
        right=max(right,sum);
    }
    
    int single = max(fastMaxSum(A,lo,mid), fastMaxSum(A,lo,hi));
    return max(left+right,single);
}
