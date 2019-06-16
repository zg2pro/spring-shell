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

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creates beans for prompt commands.
 *
 * @author Gregory Anne
 */
@Configuration
public class PromptCommandsAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(PromptResolver.Command.class)
    @ConditionalOnProperty(prefix = "spring.shell.command.prompt", value = "enabled", havingValue = "true", matchIfMissing = true)
    public PromptResolver promptResolver(org.jline.reader.History jLineHistory) {
        return new PromptResolver(jLineHistory);
    }

}
