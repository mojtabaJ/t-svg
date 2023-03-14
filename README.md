
I apologize for the confusion. Here's a possible Markdown format for a README file for the `SvgUtility` class:

SvgUtility
==========

The `SvgUtility` class is a tool designed to simplify and streamline the process of handling SVG files. It contains several static methods for parsing SVG files to strings, changing colors, classes, and attributes in SVG files, adding styles and exporting SVG files to a file path.

Installation
------------

To use the `SvgUtility` class, you can simply include the `SvgUtility.java` file in your project's source code.

Usage
-----

Here are some examples of how to use the `SvgUtility` class:

### Parsing an SVG file to a string

Copy code

```java 
String svgString = SvgUtility.parseSvgToString("path/to/file.svg");
```

This method parses an SVG file to a string and adds a class and an attribute to the `<svg>` tag.

### Changing the color of an SVG

Copy code
```java 
String newSvgString = SvgUtility.changeColor(svgString, "#FF0000");
```

This method replaces the `fill` attribute in the SVG string with the specified color value.

### Changing the class of an SVG

Copy code
```java 
String newSvgString = SvgUtility.changeClass(svgString, "new-class");
```

This method replaces the `class` attribute with a new class value in the SVG string.

### Adding a class to an SVG

Copy code
```java 
String newSvgString = SvgUtility.addClass(svgString, "new-class");
```

This method adds a new class value to the existing class attribute in the SVG string.

### Adding an attribute to an SVG

Copy code
```java 
String newSvgString = SvgUtility.addAttribute(svgString, "height=\"100%\"");
```

This method adds a new attribute to the opening `<svg>` tag in the SVG string.

### Adding a style to an SVG

Copy code
```java 
String newSvgString = SvgUtility.addStyle(svgString, "background-color: #FF0000;");
```

This method adds a new style to the existing style attribute or creates a new style attribute in the opening `<svg>` tag in the SVG string.

### Exporting an SVG file

Copy code
```java 
SvgUtility.exportSvgToFile(newSvgString, "path/to/newfile.svg");
```

This method exports the modified SVG string to a file at the specified file path.

Author and version
------------------

This `SvgUtility` class was created by Mojtaba Jalambadani and is currently at version 1.0.

