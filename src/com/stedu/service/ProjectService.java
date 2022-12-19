package com.stedu.service;

import com.stedu.bean.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    void add(Project project, List<Integer> eids);
    void del(Integer pid);
}
