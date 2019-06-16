/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.shell.prompt.commands;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jline.reader.History;
import org.jline.utils.ExecHelper;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

class NotYetImplementedException extends RuntimeException {

}

/**
 * all the yes/no and 1,2,3 answers implemented here
 *
 * @author Gregory Anne
 */
@ShellComponent
public class PromptResolver {

    public interface Command {
    }

    private final History jLineHistory;

    public PromptResolver(History jLineHistory) {
        this.jLineHistory = jLineHistory;
    }

    public String executorService(List<String> previousCmd) throws IOException {
        return ExecHelper.exec(false, previousCmd.toArray(new String[previousCmd.size()]));
    }

    @ShellMethod(value = "reply yes to the last command")
    public String yes() throws IOException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        if (this.jLineHistory.size() > 0) {
            List<String> previousCmd = new ArrayList<>(
                    Arrays.asList(
                            this.jLineHistory.get(this.jLineHistory.last()).split(" ")));
            previousCmd.add(" --no-prompt");
            return executorService(previousCmd);
        }
        throw new IllegalStateException("what was the question ?");
    }

    @ShellMethod(value = "reply y")
    public String y() throws IOException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        return yes();
    }

    @ShellMethod(value = "reply no to the last command")
    public String no() throws IOException {
        if (this.jLineHistory.size() > 0) {
            List<String> previousCmd = new ArrayList<>(
                    Arrays.asList(
                            this.jLineHistory.get(this.jLineHistory.last()).split(" ")));
            previousCmd.add(" --no-prompt");
            previousCmd.add("no");
            return executorService(previousCmd);
        }
        throw new IllegalStateException("what was the question ?");
    }

    @ShellMethod(value = "reply n")
    public String n() throws IOException {
        return no();
    }

}
