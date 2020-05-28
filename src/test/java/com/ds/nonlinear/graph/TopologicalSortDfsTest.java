package com.ds.nonlinear.graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class TopologicalSortDfsTest {

    @Test
    public void test() {
        List<Integer> jobs = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        Integer[][] depsArray = new Integer[][]{{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};
        List<Integer[]> deps = new ArrayList<>();
        fillDeps(depsArray, deps);

        List<Integer> order = TopologicalSortDfs.getOrderedJobs(jobs, deps);
        List<Integer> expectedOutput = Arrays.asList(4, 1, 3, 2);
        assertEquals(order, expectedOutput);
    }

    private void fillDeps(Integer[][] depsArray, List<Integer[]> deps) {
        Collections.addAll(deps, depsArray);
    }

}