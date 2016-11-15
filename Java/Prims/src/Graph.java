import java.io.*;

public class Graph {

    private int size;
    private String[] vertexString;
    private Node []key;
    private boolean[] visited;
    private int[][] dist;
    private int[] parent;
    private int[] count;
    private PriorityQueue Q;
    private Node[] adj;

    Graph(String[] input_vertex, String[] input) throws IOException
    {

        size=input_vertex.length;
        Q= new HeapPriorityQueue(size);

        adj = new Node[size];
        vertexString = input_vertex;
        visited =new boolean[size];
        dist = new int[size][size];
        parent = new int[size];
        count = new int[size];
        for(int i =0;i<size;i++){
            count[i]=0;
            for(int j=0;j<size;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i =0;i<input.length;i++){
            String w = input[i].substring(0,1);
            String v =input[i].substring(1,2);
            Integer distance = Integer.valueOf(input[i].substring(2));
            saveWeight(w, v, distance.intValue());
        }

    }

    public void prims(String _firstVertex) {

        int firstIndex = index(_firstVertex);
        int u = firstIndex; //첫번째 인덱스를 방문인덱스로 설정
        Node u_node;

        Node[] key = new Node[size];
        for(int i=0;i<size;i++){
            key[i] = new Node(i,null,Integer.MAX_VALUE);
        }

        key[u].setDist(0);

        for(int i=0;i<size;i++){
            Q.insert(key[i]);
        }
//       System.out.println("u(,"+vertexString[u]+")=0");
        int weigthSum=0;
        Node v_node;
        while (!Q.empty()) {
            u_node = Q.extract_min();
            u = u_node.getIndex();
            if (visited[u])
                continue;
            visited[u] = true;
            System.out.println("visit " + vertexString[u]);
            PriorityQueue backup = new HeapPriorityQueue(size);
            while(!Q.empty()){
                v_node = Q.extract_min();
                int v = v_node.getIndex();
                if(notConnected(u, v)){
                    backup.insert(v_node);
                }else{
                    if (weight(u, v) < key[v].getDist()) {
                        key[v].setDist(weight(u, v));
                        key[v].setEdge(u);
                        parent[v] = u;
                        backup.insert(key[v]);
                    }else {
                        backup.insert(v_node);
                    }
                }
            }
            Q = backup;
        }
        for(int i =0;i<size;i++){
            System.out.println(vertexString[i]+"-"+vertexString[key[i].getEdge()]+" : "+ key[i].getDist());
            weigthSum+=key[i].getDist();
        }
        System.out.println("total sum : "+ weigthSum);
    }

    private boolean notConnected(int u, int v) {
        return weight(u,v)==-1;
    }

    public void saveWeight(String v, String w, int weight) {
        Node vNode = adj[index(v)];
        Node wNode = adj[index(w)];
        if (vNode == null) {
            adj[index(v)] = new Node(index(w), null, weight);
        } else {
            vNode.setNext(new Node(index(w), vNode.getNext(), weight));
        }

        if (wNode == null) {
            adj[index(w)] = new Node(index(v), null, weight);
        } else {
            wNode.setNext(new Node(index(v), wNode.getNext(), weight));
        }


    }
    public int weight(int i ,int j){
        Node p = adj[i];
        while(p !=null){
            if(p.getIndex()==j){
                return p.getDist();
            }
            p=p.getNext();
        }
        return -1;
    }


    private int index(String v){
        for(int i=0;i<size;i++)
        {
            if(vertexString[i].equals(v)) return i;
        }
        return -1;
    }

}