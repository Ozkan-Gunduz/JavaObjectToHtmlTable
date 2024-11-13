package org.ozkangunduz;

import org.ozkangunduz.utility.TableBuilder;

import java.util.List;

public class JavaToHTML {
    public static String toHTMLTable(Object object) {
        return new TableBuilder().addObject(object).build();
    }

    public static String toHTMLTable(List<?> objects) {
        return new TableBuilder().addObjects(objects).build();
    }
}