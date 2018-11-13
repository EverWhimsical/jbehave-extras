package com.everwhimsical.jbehave;

import freemarker.ext.beans.StringModel;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.List;

/**
 * A simple Freemarker plugin to convert the zoned date time to required format
 *
 * Usage: - Add the instance of this class into freemarker template root object like:
 * root.put("formatDateTime", new FormatDateTimeMethodModel()); - Then in the template, call
 * ${formatDateTime(zonedDateTime, "dd/MM/yyyy hh:mm:ss a")}
 */
public class FormatDateTimeMethodModel implements TemplateMethodModelEx {

    @Override
    public Object exec(List args) throws TemplateModelException {
        if (args.size() != 2) {
            throw new TemplateModelException("Wrong arguments");
        }
        SimpleScalar t = ((SimpleScalar) args.get(0));
        ZonedDateTime time = ZonedDateTime.parse(t.getAsString());
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern(((SimpleScalar) args.get(1)).getAsString());
        return formatter.format(time);
    }
}
