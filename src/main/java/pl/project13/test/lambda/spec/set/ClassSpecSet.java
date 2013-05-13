package pl.project13.test.lambda.spec.set;

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

import pl.project13.test.lambda.RegisteredSpec;
import pl.project13.test.lambda.spec.body.ClassSpecBody;
import pl.project13.test.lambda.spec.body.MarkAsPending;
import pl.project13.test.lambda.specset.PendingSpec;
import pl.project13.test.lambda.specset.RegisteredClassSpec;
import pl.project13.test.lambda.specset.RunnableLambdaSpec;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static pl.project13.test.lambda.reflection.Reflection.newInstanceOf;

public class ClassSpecSet<T> extends RunnableLambdaSpec {

  private final Class<T> classUnderTest;

  private List<RegisteredSpec> tests = new CopyOnWriteArrayList<>();

  public ClassSpecSet(Class<T> classUnderTest) {
    this.classUnderTest = classUnderTest;
  }

  public RegisteredSpec should(String doWhat, ClassSpecBody<T> body) {
    T instance = newInstanceOf(classUnderTest);

    RegisteredClassSpec<T> spec = new RegisteredClassSpec<>(doWhat, body, instance);
    tests.add(spec);

    return spec;
  }

  public RegisteredSpec should(String doWhat, @SuppressWarnings("UnusedParameters") MarkAsPending body) {
    RegisteredSpec spec = new PendingSpec(doWhat);
    tests.add(spec);

    return spec;
  }

  @Override
  protected List<RegisteredSpec> allTests() {
    return tests;
  }

  @Override
  protected String describe() {
    return classUnderTest.getSimpleName();
  }

}
