class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(!visited[i]){
                boolean hasCycle = dfs(adj, i, visited, path);
                if(hasCycle){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int node, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                boolean hasCycle = dfs(adj, neighbor, visited, path);
                if(hasCycle){
                    return true;
                }
            } else if(path[neighbor]){
                return true;
            }
        }

        path[node] = false;
        return false;
    }
}
