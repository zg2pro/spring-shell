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
import java.lang.reflect.InvocationTargetException;
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

    @ShellMethod(value = "reply yes to the last command")
    public String yes() throws IOException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        List<String> previousCmd = Arrays.asList(this.jLineHistory.get(this.jLineHistory.last()).split(" "));
        previousCmd.add("--no-prompt");
        return ExecHelper.exec(false, previousCmd.toArray(new String[previousCmd.size()]));
//        Map<String, Object> beans = appContext.getBeansWithAnnotation(ShellComponent.class);
//        Method toInvoke = null;
//        Object beanToInvoke = null;
//        for (Map.Entry<String, Object> bean : beans.entrySet()) {
//            Class zz = bean.getValue().getClass();
//            for (Method m : zz.getMethods()) {
//                String[] specifiedKeys = new String[]{m.getName()};
//                if (m.isAnnotationPresent(ShellMethod.class)) {
//                    ShellMethod sm = m.getDeclaredAnnotation(ShellMethod.class);
//                    if (sm.key() != null && sm.key().length > 0) {
//                        specifiedKeys = sm.key();
//                    }
//                    Arrays.sort(specifiedKeys);
//                    if (Arrays.binarySearch(specifiedKeys, previousCmdName) > -1){
//                        toInvoke = m;
//                        beanToInvoke = bean.getValue();
//                    }
//                }
//            }
//        }
//        if (toInvoke != null){
//            toInvoke.invoke(beanToInvoke, previousArgs);
//        }
    }

    @ShellMethod(value = "reply y")
    public String y() throws IOException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        return yes();
    }

    @ShellMethod(value = "reply no to the last command")
    public String no() throws IOException {
        List<String> previousCmd = Arrays.asList(this.jLineHistory.get(this.jLineHistory.last()).split(" "));
        previousCmd.add("--no-prompt"); 
        previousCmd.add("no");
        return ExecHelper.exec(false, previousCmd.toArray(new String[previousCmd.size()]));
    }

    @ShellMethod(value = "reply n")
    public String n() throws IOException {
        return no();
    }

}
