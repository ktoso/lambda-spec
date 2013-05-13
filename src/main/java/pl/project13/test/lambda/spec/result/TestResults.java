package pl.project13.test.lambda.spec.result;

/*
 * #%L
 * lambda-spec
 * %%
 * Copyright (C) 2013 project13.pl
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import pl.project13.test.lambda.util.Color;

import java.util.List;

public class TestResults {

  private final String specSetName;

  private final List<TestResult> results;

  public final long greenTests;
  public final long failedTests;
  public final long erroredTests;


  public TestResults(String specSetName, List<TestResult> results) {
    this.specSetName = specSetName;
    this.results = results;

    this.erroredTests = results.stream().filter(s -> s.getState() == TestState.ERRORED).count();
    this.greenTests = results.stream().filter(s -> s.getState() == TestState.GREEN).count();
    this.failedTests = results.stream().filter(s -> s.getState() == TestState.FAILED).count();
  }

  public void printToConsole() {
    System.out.println(Color.greenIfColorsEnabled(specSetName));

    for (TestResult result : results) {
      System.out.println(result.toColorizedString());
    }
  }

  @Override
  public String toString() {
    return "TestResults{" +
        "numberOfTests=" + (greenTests + failedTests + erroredTests) +
        ", greenTests=" + greenTests +
        ", failedTests=" + failedTests +
        ", erroredTests=" + erroredTests +
        '}';
  }
}
