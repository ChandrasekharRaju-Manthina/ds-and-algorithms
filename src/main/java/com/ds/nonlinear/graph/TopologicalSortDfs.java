package com.ds.nonlinear.graph;

import java.util.*;

public class TopologicalSortDfs {

    public static List<Integer> getOrderedJobs(List<Integer> jobs, List<Integer[]> deps) {
        // uses depth first search
        JobGraph jobGraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    private static List<Integer> getOrderedJobs(JobGraph jobGraph) {
        List<JobNode> jobNodes = new ArrayList<>(jobGraph.jobNodes.values());
        List<Integer> output = new ArrayList<>();
        while(!jobNodes.isEmpty()) {
            JobNode jobNode = jobNodes.remove(jobNodes.size()-1);
            boolean hasCycle = depthFirstSearch(jobNode, output);
            if(hasCycle) {
                return Collections.emptyList();
            }
        }

        return output;
    }

    private static boolean depthFirstSearch(JobNode jobNode, List<Integer> output) {
        if(jobNode.visited) {
            return false;
        }

        if(jobNode.visiting) {
            return true;
        }

        jobNode.visiting = true;
        for(JobNode prerequisite: jobNode.prerequisites) {
            boolean hasCycle = depthFirstSearch(prerequisite, output);
            if(hasCycle) {
                return true;
            }
        }

        output.add(jobNode.job);
        jobNode.visiting = false;
        jobNode.visited = true;

        return false;
    }

    private static JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobGraph = new JobGraph(jobs);
        deps.forEach(jobGraph::addDependency);
        return jobGraph;
    }

    private static class JobGraph {
        private Map<Integer, JobNode> jobNodes;

        JobGraph(List<Integer> jobs) {
            jobNodes = new HashMap<>();
            jobs.forEach(this::addJobNode);
        }

        private void addJobNode(int job) {
            jobNodes.put(job, new JobNode(job));
        }

        void addDependency(Integer dep[]) {
            JobNode jobNode = jobNodes.get(dep[1]);

            jobNode.prerequisites.add(jobNodes.get(dep[0]));
        }

    }

    private static class JobNode {
        private int job;
        private List<JobNode> prerequisites;
        private boolean visiting;
        private boolean visited;

        JobNode(int job) {
            this.job = job;
            prerequisites = new ArrayList<>();
        }
    }

}
