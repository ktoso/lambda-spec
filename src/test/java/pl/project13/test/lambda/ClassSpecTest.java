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

import org.junit.Test;
import pl.project13.test.lambda.exampleimpl.Adder;
import pl.project13.test.lambda.spec.set.ClassSpecSet;

import static org.fest.assertions.Assertions.assertThat;
import static pl.project13.test.lambda.SpecDSL.describe;

public class ClassSpecTest {

  ClassSpecSet<Adder> it = describe(Adder.class);

  {
    it.should("add two numbers", adder -> {
      // given
      int a = 1;
      int b = 2;

      int expected = 3;

      // when
      int got = adder.add(a, b);

      // then
      assertThat(got).isEqualTo(expected);
    });

    it.should("add a negative number", adder -> {
      // given
      int a = -1;
      int b = 2;

      int expected = 333; // wrong expected here, on purpose

      // when
      int got = adder.add(a, b);

      // then
      assertThat(got).isEqualTo(expected);
    });

    it.should("add imaginary numbers", MarkAs.pending);
  }

  @Test
  public void shouldPassAllTests() throws Exception {
    it.shouldPassAllTests();
  }

}
