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

public class FailedTestResult implements TestResult {

  private final String doWhat;
  private final Throwable thrown;

  public FailedTestResult(String doWhat, Throwable thrown) {
    this.doWhat = doWhat;
    this.thrown = thrown;
  }

  @Override
  public TestState getState() {
    return TestState.FAILED;
  }

  @Override
  public String toColorizedString() {
    return Color.redIfColorsEnabled(String.format("  - should %s - %s: %s", doWhat, thrown.getClass().getSimpleName(), thrown.getMessage()));
  }

}
