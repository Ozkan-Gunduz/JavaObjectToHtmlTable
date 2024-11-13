# TableBuilder - Java HTML Table Generator

A simple Java library to generate stylish HTML tables from custom Java objects. The tables can be styled with custom colors, and certain fields can be excluded from the table using a builder pattern.

## Features ✨

- Convert Java objects to stylish HTML tables.
- Exclude fields from the table with a builder pattern.
- Stylish table design using a custom color palette.
- Compatible with Java 17+.

## Example Usage 📚

### 1. Add Dependency

You can include this project as a Maven dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>tablebuilder</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2. Create Objects and Build the Table

Create your custom objects and use the `TableBuilder` class to generate an HTML table.

```java
package org.example;

import java.util.List;

public class ExampleUsage {
    public static void main(String[] args) {
        // Example object list
        List<TestObject> data = List.of(
                new TestObject("112223", "99999"),
                new TestObject("223344", "88888")
        );

        // Build the HTML table
        TableBuilder tableBuilder = new TableBuilder();
        String htmlTable = tableBuilder.addObjects(data).build();

        System.out.println(htmlTable);  // Print the generated HTML table
    }

    // Sample object class to demonstrate usage
    public static class TestObject {
        private String accountNo;
        private String contract;

        public TestObject(String accountNo, String contract) {
            this.accountNo = accountNo;
            this.contract = contract;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public String getContract() {
            return contract;
        }
    }
}
```

### 3. Customizing the Table

You can customize the table further by excluding specific fields from being displayed or by adding a custom style.

#### Exclude Fields

To exclude fields from the table, simply use the `excludeField` method.

```java
package org.example;

import java.util.List;

public class ExampleUsage {
    public static void main(String[] args) {
        // Example object list
        List<TestObject> data = List.of(
                new TestObject("112223", "99999"),
                new TestObject("223344", "88888")
        );

        // Build the HTML table excluding the 'contract' field
        TableBuilder tableBuilder = new TableBuilder();
        String htmlTable = tableBuilder.addObjects(data)
                                      .excludeField("contract")
                                      .build();

        System.out.println(htmlTable);  // Print the generated HTML table
    }

    // Sample object class to demonstrate usage
    public static class TestObject {
        private String accountNo;
        private String contract;

        public TestObject(String accountNo, String contract) {
            this.accountNo = accountNo;
            this.contract = contract;
        }

        public String getAccountNo() {
            return accountNo;
        }

        public String getContract() {
            return contract;
        }
    }
}
```
### Features Breakdown 🛠️

- **Object to HTML Table Conversion**: Convert any Java object or list of objects into a neatly formatted HTML table.
- **Field Exclusion**: Exclude specific fields from appearing in the table (e.g., sensitive data or unnecessary fields).
- **Customizable Styles**: Customize the table’s appearance by modifying CSS styles (e.g., change colors, borders, text alignment).
- **Builder Pattern**: Use the builder pattern to add objects, exclude fields, and generate the HTML table in a clean and intuitive way.
- **Flexible Data Handling**: Supports both single objects and lists of objects, making it versatile for various data scenarios.
- **Simple Integration**: Easily integrate the `TableBuilder` class into your Java project to generate HTML tables as needed.

#### Additional Features

- **Dynamic Column Generation**: Automatically generates table columns based on the object's fields.
- **Error Handling**: Gracefully handles reflection-related errors (e.g., `IllegalAccessException`), ensuring robustness.
- **Compatibility**: Works with Java 17 and supports any object type as long as it has publicly accessible fields.

With this library, you can quickly turn Java object data into a beautiful, responsive HTML table ready to be embedded in emails, reports, or web pages.


### License 📜

This project is licensed under the **MIT License** - see the LICENSE file for details.

Made with ❤️ by **Ozkan Gunduz**


