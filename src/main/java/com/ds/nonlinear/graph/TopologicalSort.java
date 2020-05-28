package com.ds.nonlinear.graph;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalSort {

    public static List<Integer> sort(List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, Integer> dependencyCountMap = jobs.stream().collect(Collectors.toMap(job -> job, job -> 0));
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (Integer dep[] : deps) {
            dependencyCountMap.put(dep[1], dependencyCountMap.get(dep[1]) + 1);
            if (graph.containsKey(dep[0])) {
                graph.get(dep[0]).add(dep[1]);
            } else {
                List<Integer> neighbours = new ArrayList<>();
                neighbours.add(dep[1]);
                graph.put(dep[0], neighbours);
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();

        for (Map.Entry<Integer, Integer> job : dependencyCountMap.entrySet()) {
            if (job.getValue() == 0) {
                queue.add(job.getKey());
            }
        }

        List<Integer> output = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer job = queue.removeFirst();

            if (graph.containsKey(job)) {
                for (Integer neighbour : graph.get(job)) {
                    dependencyCountMap.put(neighbour, dependencyCountMap.get(neighbour) - 1);
                    if (dependencyCountMap.get(neighbour) == 0) {
                        queue.add(neighbour);
                    }
                }
            }
            output.add(job);
        }

        return output.size() == jobs.size() ? output : Collections.emptyList();
    }

}
