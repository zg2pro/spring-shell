/*
 * Copyright 2017 the original author or authors.
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

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Tests for the {@link PromptResolver}.
 *
 * @author Gregory Anne
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PromptResolverTest.Config.class)
public class PromptResolverTest {

    @Autowired
    private PromptResolver promptResolver;

    @Test
    public void testCommandYes() throws Exception {
        //TODO
    }

    @Configuration
    static class Config {

        @Bean
        public PromptResolver promptResolver() {
            return new PromptResolver(null);
        }

    }

}
