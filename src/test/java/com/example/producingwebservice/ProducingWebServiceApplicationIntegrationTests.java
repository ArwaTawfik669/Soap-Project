/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.producingwebservice;

import io.spring.guides.gs_producing_web_service.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigInteger;


@RunWith(MockitoJUnitRunner.class)
public class ProducingWebServiceApplicationIntegrationTests {
    @InjectMocks
    private UserRepository userRepository = new UserRepository();


    @BeforeEach
    void setUp() {
        this.userRepository
                = new UserRepository();
        this.userRepository.initData();
    }

    @Test
    public void testGetByID() {
        this.userRepository
                = new UserRepository();
        this.userRepository.initData();
        User u = userRepository.findUser(BigInteger.valueOf(1));
        Assert.assertEquals("Arwa", u.getName());
        Assert.assertEquals("Benha", u.getAddress());
    }


}
