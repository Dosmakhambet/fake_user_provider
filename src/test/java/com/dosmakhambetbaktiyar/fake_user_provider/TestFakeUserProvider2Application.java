package com.dosmakhambetbaktiyar.fake_user_provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestFakeUserProvider2Application {

    public static void main(String[] args) {
        SpringApplication.from(FakeUserProvider2Application::main).with(TestFakeUserProvider2Application.class).run(args);
    }

}
