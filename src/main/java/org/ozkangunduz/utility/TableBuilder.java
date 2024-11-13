package org.ozkangunduz.utility;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableBuilder {
    private final List<Object> objects = new ArrayList<>();
    private final List<String> excludedFields = new ArrayList<>();

    public TableBuilder addObject(Object object) {
        objects.add(object);
        return this;
    }

    public TableBuilder addObjects(List<?> objectList) {
        objects.addAll(objectList);
        return this;
    }

    public TableBuilder excludeField(String fieldName) {
        excludedFields.add(fieldName);
        return this;
    }

    public String build() {
        if (objects.isEmpty()) {
            return "<p>No data to display</p>";
        }

        StringBuilder html = new StringBuilder("<style>")
                .append("table { width: 100%; border-collapse: collapse; font-family: 'Arial', sans-serif; font-size: 16px; }")
                .append("th, td { padding: 12px; border: 1px solid #4A628A; text-align: left; color: #2E4053; }")
                .append("th { background-color: #7AB2D3; color: #FFFFFF; font-weight: bold; }")
                .append("tr:nth-child(even) { background-color: #B9E5E8; }")
                .append("tr:nth-child(odd) { background-color: #DFF2EB; }")
                .append("</style><table>");

        Object firstObject = objects.get(0);
        Field[] fields = firstObject.getClass().getDeclaredFields();

        // Header Row
        html.append("<tr>");
        for (Field field : fields) {
            if (!excludedFields.contains(field.getName())) {
                html.append("<th>").append(capitalize(field.getName())).append("</th>");
            }
        }
        html.append("</tr>");

        // Data Rows
        for (Object obj : objects) {
            html.append("<tr>");
            for (Field field : fields) {
                if (!excludedFields.contains(field.getName())) {
                    field.setAccessible(true);
                    try {
                        html.append("<td>").append(field.get(obj)).append("</td>");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            html.append("</tr>");
        }

        html.append("</table>");
        return html.toString();
    }

    // Helper method to capitalize the first letter of a field name for display
    private String capitalize(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }


}
