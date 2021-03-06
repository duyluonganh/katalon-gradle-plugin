package com.katalon.gradle.plugin.list;

import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;

import java.util.List;

public class ListTestSuitesTask extends DefaultTask {
  @TaskAction
  void scanTestSuites() {
    Project project = this.getProject();
    String rootPath = project.getRootDir().getAbsolutePath();
    Scanner scanner = new Scanner();
    try {
      List<TestSuite> testSuites = scanner.scanTestSuites(rootPath);
      testSuites.forEach(suite -> {
        System.out.println(suite.getPath());
      });
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }
}
