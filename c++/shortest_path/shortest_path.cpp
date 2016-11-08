int n;
double dist[MAX][MAX];

double shortestPath(vector<int>& path, vector<bool>& visited, double currentLength)
{
    if(path.size()==n)
        return currentLength+dist[path[0]][path.back()];
    double ret =INF;
    
}
