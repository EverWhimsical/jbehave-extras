package com.everwhimsical.jbehave;

import com.everwhimsical.jbehave.execution.JBehaveExecution;
import com.everwhimsical.jbehave.model.IExecution;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReportBuilder {

    public static void main(String[] args) throws IOException {
        buildSlingshotV1Report();
    }

    private static String readFile(String pathname) throws IOException {

        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int) file.length());

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            return fileContents.toString();
        }
    }

    public static void buildSlingshotV1Report() throws IOException {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        String json = readFile("/Users/barrot/Desktop/report.json");
//        IExecution iExecution = gson.fromJson(json, IExecution.class);
        IExecution iExecution = JBehaveExecution.getExecution();
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setClassForTemplateLoading(ReportBuilder.class, "templates");
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            Map<String, Object> root = new HashMap<>();
            root.put("execution", iExecution);
            root.put("about", iExecution.getAbout());
            root.put("formatDateTime", new FormatDateTimeMethodModel());

            Template template = cfg.getTemplate("index.ftl");
            String outputDirectory = "target/";
            OutputStream fileStream = new FileOutputStream(
                outputDirectory + File.separator + "report.html");
            Writer out = new OutputStreamWriter(fileStream, StandardCharsets.UTF_8);
            template.process(root, out);
            out.close();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException("Report template parsing exception", e);
        }
    }
}
