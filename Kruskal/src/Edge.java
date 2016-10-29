public class Edge implements Comparable<Edge>{

	int i;
	int j;
	int weight;
	Edge(int _i, int _j, int _weight)
	{
		this.i=_i;
		this.j=_j;
		this.weight=_weight;
	}
	
	@Override
	public int compareTo(Edge _edge) {
		// TODO Auto-generated method stub
		if(this.weight > _edge.weight){
			return 1;
		}else if(this.weight < _edge.weight){
			return -1;
		}
		return 0;
	}
}
