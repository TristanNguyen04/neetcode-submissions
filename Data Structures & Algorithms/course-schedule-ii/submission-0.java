class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        List<Integer> order = new ArrayList<>();
        int[] result = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                boolean hasCycle = dfs(adj, i, visited, path, order);

                if(hasCycle){
                    return new int[] {};
                }
            }
        }

        for(int i = 0; i < numCourses; i++){
            result[i] = order.get(numCourses - 1 - i);
        }

        return result;
    }

    private boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, boolean[] path, List<Integer> order){
        visited[node] = true;
        path[node] = true;

        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                boolean hasCycle = dfs(adj, neighbour, visited, path, order);
                
                if(hasCycle){
                    return true;
                }
            } else if(path[neighbour] == true){
                return true;
            }
        }

        path[node] = false;
        order.add(node);

        return false;
    }
}
