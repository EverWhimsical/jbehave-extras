package com.everwhimsical.jbehave;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

public class JBehaveStepScanner {

    private final String[] packageNames;

    public JBehaveStepScanner(String... packageNames) {
        this.packageNames = packageNames;
    }

    public List<JBehaveStepInfo> getDuplicateSteps() {
        List<JBehaveStepInfo> allSteps = getAllSteps();
        return allSteps.stream()
            .filter(step -> Collections.frequency(allSteps, step) > 1).collect(Collectors.toList());
    }

    public List<JBehaveStepInfo> getAllSteps() {
        Reflections reflections = new Reflections(packageNames, new MethodAnnotationsScanner());
        Set<Method> givenSet = reflections.getMethodsAnnotatedWith(Given.class);
        Set<Method> whenSet = reflections.getMethodsAnnotatedWith(When.class);
        Set<Method> thenSet = reflections.getMethodsAnnotatedWith(Then.class);

        List<JBehaveStepInfo> jBehaveStepInfoList = new ArrayList<>();

        for (Method given : givenSet) {
            String annotation = Given.class.getSimpleName();
            String value = given.getAnnotation(Given.class).value();

            JBehaveStepInfo info = new JBehaveStepInfo(annotation, value,
                given.getDeclaringClass().getCanonicalName(), given.getName());
            jBehaveStepInfoList.add(info);
        }
        for (Method when : whenSet) {
            String annotation = When.class.getSimpleName();
            String value = when.getAnnotation(When.class).value();

            JBehaveStepInfo info = new JBehaveStepInfo(annotation, value,
                when.getDeclaringClass().getCanonicalName(), when.getName());
            jBehaveStepInfoList.add(info);
        }
        for (Method then : thenSet) {
            String annotation = Then.class.getSimpleName();
            String value = then.getAnnotation(Then.class).value();

            JBehaveStepInfo info = new JBehaveStepInfo(annotation, value,
                then.getDeclaringClass().getCanonicalName(), then.getName());
            jBehaveStepInfoList.add(info);
        }

        return jBehaveStepInfoList;
    }
}
