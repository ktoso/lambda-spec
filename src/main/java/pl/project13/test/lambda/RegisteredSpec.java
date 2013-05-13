package pl.project13.test.lambda;

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

import pl.project13.test.lambda.spec.result.*;
import pl.project13.test.lambda.specset.PendingSpecException;

public class RegisteredSpec implements RunnableTest {

  private final String doWhat;
  private final Runnable body;

  public RegisteredSpec(String doWhat, Runnable body) {
    this.doWhat = doWhat;
    this.body = body;
  }


  @Override
  public TestResult run() {
    // todo before hook

    try {
      body.run();
    } catch (PendingSpecException e) {
      return new PendingTestResult(doWhat);
    } catch (AssertionError e) {
      return new FailedTestResult(doWhat, e);
    } catch (Exception e) {
      return new ErroredTestResult(doWhat, e);
    }

    // todo after hook

    return new GreenTestResult(doWhat);
  }
}
