package by.bsuir;

import by.bsuir.controller.TestController;
import by.bsuir.entity.AspirantAccount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("by.bsuir")
public class TanJobsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringApplication.class);
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(TanJobsApplication.class, args);

        TestController testController = (TestController) ctx.getBean("TestController");

        AspirantAccount aspirantAccount = new AspirantAccount();
        aspirantAccount.setEmail("123");

        testController.register(aspirantAccount);
        System.out.println(testController.getAspirant("123"));
        System.out.println(testController.getAspirant("123").getEmail());
    }
}

