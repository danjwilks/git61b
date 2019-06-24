public class UnionFind {


    private int[] array;
    private int size;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {

        size = n;
        array = new int[size];

        for (int i = 0; i<n; i++){
            array[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        if (vertex >= size || vertex < 0){
            throw new IllegalArgumentException("vertex is not a valid index");
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {

        int size = Math.abs(array[find(v1)]);

        return size;
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {

        int child = array[v1];
        if (child < 0){
            return child;
        }

        int parent = array[child];

        return parent;
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        if (find(v1) == find(v2)){
            return true;
        }
        return false;
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {

        if (!connected(v1, v2)){

            if (sizeOf(v1) > sizeOf(v2)){

                updateArray(v1,v2);

            } else {

                updateArray(v2,v1);

            }
        }
    }

    /** v1 size is bigger
     * updates size and updates the roots */
    private void updateArray(int v1, int v2){

        updateSize(v1, sizeOf(v2));

        int v2Root = find(v2);
        array[v2Root] = find(v1);

    }

    /** updates the root value of v1*/
    private void updateSize(int v1, int plusSize){

        int root = find(v1);

        array[root] = array[root] - plusSize;

    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    // TODO
    public int find(int vertex) {

        int root = vertex;

        while(array[root] >= 0){
            root = Math.abs(parent(root));
        }

        return root;

    }

}
