class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        // Topological Sorting algo using BFS
        // First we have to find indegree
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            for(int j=0; j<graph.get(i).size(); j++){
                indegree[graph.get(i).get(j)]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int i=0; i<graph.get(node).size(); i++){
                indegree[graph.get(node).get(i)]--;
                if(indegree[graph.get(node).get(i)] == 0){
                    q.add(graph.get(node).get(i));
                }
            }
        }
        if(ans.size()!=numCourses) return false;
        return true;
    }
}
