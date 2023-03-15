Summary
=======

The `SvgUtility` and `SvgUtilityBuilder` classes provide a convenient and streamlined way to create, parse, and modify SVG files in Java. `SvgUtility` allows for the manipulation of SVG files with methods such as parsing SVG files to strings, changing colors, classes, and attributes in SVG files, adding styles, and exporting SVG files to a file path. `SvgUtilityBuilder` implements the builder pattern by allowing for the modification of various parameters using builder methods, which are then used in the appropriate methods of `SvgUtility` to modify the SVG file.

SvgUtility
==========

The `SvgUtility` class provides a set of static methods for parsing, modifying, and exporting SVG files in Java. Some of the key features and methods of `SvgUtility` include:

*   The ability to parse an SVG file to a string using the `parseSvgToString()` method.
*   The ability to change the fill color of an SVG using the `changeColor()` method.
*   The ability to change the class of an SVG using the `changeClass()` method.
*   The ability to add a new class to an SVG using the `addClass()` method.
*   The ability to add a new attribute to the opening <svg> tag using the `addAttribute()` method.
*   The ability to add a new style to the existing style attribute or create a new style attribute using the `addStyle()` method.
*   The ability to export an SVG file to a file path using the `exportSvgToFile()` method.

SvgUtilityBuilder
=================

The `SvgUtilityBuilder` class provides a way to modify an SVG file using a set of builder methods before building and returning the modified SVG as a string. Some key features and methods of `SvgUtilityBuilder` include:

*   The ability to set the SVG file to be used by `SvgUtility` methods with the `setSvgFile()` method.
*   The ability to set the HTML class to be used by `SvgUtility` methods with the `setHtmlClass()` method.
*   The ability to add a new attribute to the opening <svg> tag using the `setAttribute()` method.
*   The ability to change the fill color of an SVG using the `addColor()` method.
*   The ability to set a new CSS class for the SVG using the `addNewClass()` method.
*   The ability to add a new attribute to the opening <svg> tag using the `addNewAttribute()` method.
*   The ability to add a new style to the existing style attribute or create a new style attribute using the `addNewStyle()` method.
*   The ability to export the modified SVG file to a file path using the `addFilePath()` method.
*   The ability to add a new CSS class to the SVG using the `addClass()` method.

Overall, both `SvgUtility` and `SvgUtilityBuilder` provide a comprehensive set of tools for working with SVG files in Java, making it easier to manipulate and create SVG files in code.


Examples
========

### Modifying an SVG File with SvgUtilityBuilder
This example uses the `SvgUtilityBuilder` to create a modified SVG file with various modifications. It sets the SVG file to be modified, adds an HTML

```java
try {
    String modifiedSvg = new SvgUtilityBuilder()
            .setSvgFile("example.svg")
            .setHtmlClass("my-class")
            .addNewAttribute("viewBox=\"0 0 100 100\"")
            .addColor("#FF0000")
            .addNewClass("new-class")
            .addNewStyle("stroke: black;")
            .build();
    System.out.println(modifiedSvg);
} catch (IOException e) {
    e.printStackTrace();
}
```


### Parsing an SVG File to a String
This example uses the `parseSvgToString()` method to read an SVG file at "example.svg", add a "class" attribute with the value "my-class", and add additional attributes `width` and `height` to the opening `<svg>` tag.


```java

try {
    String svgString = SvgUtility.parseSvgToString("example.svg");
    System.out.println(svgString);
} catch (IOException e) {
    e.printStackTrace();
}
```

### Changing the Fill Color of an SVG
This example uses the `changeColor()` method to change the fill color of an SVG file at "example.svg" to red (#FF0000).

```java
try {
    String svgString = SvgUtility.changeColor("example.svg", "#FF0000");
    System.out.println(svgString);
} catch (IOException e) {
    e.printStackTrace();
}
```


### Adding a New CSS Class to an SVG
This example uses the `addClass()` method to add a new CSS class "my-class" to an SVG file at "example.svg".
```java
try {
    String svgString = SvgUtility.addClass("example.svg", "my-class");
    System.out.println(svgString);
} catch (IOException e) {
    e.printStackTrace();
}
```
