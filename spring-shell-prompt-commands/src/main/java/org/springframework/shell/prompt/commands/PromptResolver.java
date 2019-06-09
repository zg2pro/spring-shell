/*
 * Copyright 2018 the original author or authors.
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
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

class NotYetImplementedException extends RuntimeException {
    
}

/**
 * all the yes/no and 1,2,3 answers implemented here
 * 
 * 
 * @author Gregory Anne
 */
@ShellComponent
public class PromptResolver {

    public interface Command {
    }
    
    private final org.jline.reader.History jLineHistory;

    public PromptResolver(org.jline.reader.History jLineHistory) {
        this.jLineHistory = jLineHistory;
    }

    @ShellMethod(value = "reply yes to the last command")
    public String yes() throws IOException {
        throw new NotYetImplementedException();
    }

    @ShellMethod(value = "reply y")
    public String y() throws IOException {
        return yes();
    }

    @ShellMethod(value = "reply no to the last command")
    public String no() throws IOException {
        throw new NotYetImplementedException();
    }

    @ShellMethod(value = "reply n")
    public String n() throws IOException {
        return no();
    }
    
}
