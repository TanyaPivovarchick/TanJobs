package by.bsuir;

import by.bsuir.controller.TestController;
import by.bsuir.entity.*;
import by.bsuir.service.DocumentService;
import by.bsuir.viewModel.*;
import by.bsuir.viewModel.JobVacancy;
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


        AspirantResume resume = new AspirantResume(
                "кпцукпцукп", 123f, "123", "123",
                "123", "вавпаывапы", new java.sql.Date(1998, 2, 1), "123", "123", "123",
                "123", "123", "123", "true", "true", "123"
                ,"123dfffffffff00000fffffffffffffffffffffffffffffffffffffffffffff");

        JobVacancy jobVacancy = new JobVacancy("123", "123", new java.sql.Date(1998, 2, 1),
                "123", "123", "123",
                "123", "123", "123", "123");

        Aspirant aspirant = new Aspirant("123", "123", "123", "123",
                "123", new java.sql.Date(1998, 2, 1), "123", "123", "123",
                "123", "123", "123");

        AspirantInvitation invitation = new AspirantInvitation(new java.sql.Date(1998, 2, 1), "укпцукпцукп",
                "123", "123", "123", "123", "123",
                "123", "123", "123");

        DocumentService documentService = (DocumentService) ctx.getBean("DocumentService");
        documentService.createPdf("1.pdf", resume);
        documentService.createXls("1.xls", resume);
        documentService.createCsv("1.csv", resume);
    }
}

