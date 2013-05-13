package pl.project13.test.lambda.util;

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

import pl.project13.test.lambda.options.Options;

public class Color {

  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static String red(Object o) {
    return ANSI_RED + o.toString() + ANSI_RESET;
  }

  public static String yellow(Object o) {
    return ANSI_YELLOW + o.toString() + ANSI_RESET;
  }

  public static String green(Object o) {
    return ANSI_GREEN + o.toString() + ANSI_RESET;
  }

  public static String greenIfColorsEnabled(Object o) {
    if (Options.colorizedOutput()) {
      return green(o.toString());
    } else {
      return o.toString();
    }
  }

  public static String redIfColorsEnabled(Object o) {
    if (Options.colorizedOutput()) {
      return red(o.toString());
    } else {
      return o.toString();
    }
  }

  public static String yellowIfColorsEnabled(Object o) {
    if (Options.colorizedOutput()) {
      return yellow(o.toString());
    } else {
      return o.toString();
    }
  }
}
