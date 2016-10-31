#include <vector>

using namespace std;
const int MIN =  numeric_limits<int>::min();


int fastMaxSum(const vector<int>& A)
{
    int N = A.size(), ret = MIN, psum=0;
    for(int i =0;i<N;++i)
    {
        psum=max(psum,0)+A[i];
        ret = max(psum,ret);
    }
    return ret;
}
