//using BFS to exam where there is a circle in the graph of course offered
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int require = prerequisites[i][1];
            if(matrix[require][course] == 0 ) indegree[course]++;
            matrix[require][course] = 1;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            count++;
            for(int i = 0; i < numCourses; i++) {
                if(matrix[cur][i] != 0) {
                    if(--indegree[i] == 0)
                        queue.add(i);
                }
            }
        }
        return count == numCourses;
    }
}