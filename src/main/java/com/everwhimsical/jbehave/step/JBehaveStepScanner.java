package com.everwhimsical.jbehave.step;

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

/**
 * Utility class to find all steps and duplicate steps.<br><br> All Steps:
 * <pre>
 *
 * &#064;org.junit.Before
 * public void verifySteps() {
 *      JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
 *      "com.everwhimsical.jbehave.step.classes.clean");
 *      List-&lt;JBehaveStepInfo-&gt; allSteps = jBehaveStepScanner.getAllSteps();
 *      allSteps.forEach(System.out::println);
 * }
 * </pre>
 * Duplicate Steps:
 * <pre>
 * &#064;org.junit.Before
 * public void verifySteps() {
 *      JBehaveStepScanner jBehaveStepScanner = new JBehaveStepScanner(
 *      "com.everwhimsical.jbehave.step.classes.clean",
 *      "com.everwhimsical.jbehave.step.classes.duplicate");
 *      List-&lt;JBehaveStepInfo-&gt; duplicateSteps = jBehaveStepScanner.getDuplicateSteps();
 *      if (duplicateSteps.size() -&gt; 0) {
 *          Assert.fail("Duplicate steps found");
 *      }
 * }
 * </pre>
 */
public class JBehaveStepScanner {

    private final String[] packageNames;

    /**
     * Construct JBehaveStepScanner using package names.
     *
     * @param packageNames package names of step classes as varargs.
     */
    public JBehaveStepScanner(String... packageNames) {
        this.packageNames = packageNames;
    }

    /**
     * Scans all the steps and returns duplicate steps in specified packages.
     *
     * @return List of duplicate {@link JBehaveStepInfo} object.
     */
    public List<JBehaveStepInfo> getDuplicateSteps() {
        List<JBehaveStepInfo> allSteps = getAllSteps();
        return allSteps.stream()
            .filter(step -> Collections.frequency(allSteps, step) > 1).collect(Collectors.toList());
    }

    /**
     * Scans all the steps in specified packages.
     *
     * @return List of {@link JBehaveStepInfo} object.
     */
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
