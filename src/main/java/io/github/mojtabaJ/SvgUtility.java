package io.github.mojtabaJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
The SvgUtility class is a tool designed to handle SVG files.
It contains several static methods for parsing SVG files to strings,
changing colors, classes, and attributes in SVG files, adding styles and exporting SVG files to a file path.
These methods have been created to simplify and streamline the process of modifying and handling SVG files.
Author: Mojtaba Jalambadani
Version: 1.0
*/
public class SvgUtility {

    /**
     * This method parses the contents of an SVG file at the specified path and returns it as a string.
     * @param svgFile: a string representing the file path of the SVG file to be parsed
     * @throws IOException if an error occurs while reading the SVG file
     */
    public static String parseSvgToString(String svgFile) throws IOException {
        return parseSvgToString(svgFile, "", "");
    }

    /**
     * This method parses the contents of an SVG file at the specified path and returns it as a string.
     * If the optional htmlClass and/or attribute parameters are provided, they will be added or updated in the SVG string.
     * If htmlClass is null or empty, no class attribute will be added/modified.
     * If attribute is null, no extra attribute will be added.
     *
     * @param svgFile: a string representing the file path of the SVG file to be parsed
     * @param htmlClass: an optional string representing a CSS class to be added or updated in the SVG string
     * @param attribute: an optional string representing an extra attribute to be added in the SVG string
     * @return the parsed SVG string with optional class and/or attribute added/modified
     * @throws IOException if an error occurs while reading the SVG file
     */
    public static String parseSvgToString(String svgFile, String htmlClass, String attribute) throws IOException {
        if(htmlClass == null){
            htmlClass = "";
        }
        if(attribute == null) {
            attribute = "";
        }
        StringBuilder svgContent = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(svgFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                svgContent.append(line);
            }
        }

        String svgString = svgContent.toString();
        int svgStart = svgString.indexOf("<svg");
        int classStart = svgString.indexOf("class=");
        int classEnd = svgString.indexOf("\"", classStart + 7);

        if (classStart < 0 || classEnd < 0) {
            svgString = svgString.substring(0, svgStart + 4) + " class=\"" + htmlClass + "\" " + attribute + " " + svgString.substring(svgStart + 4);
        } else {
            svgString = svgString.substring(0, classStart + 7) + htmlClass + " " + attribute + " " + svgString.substring(classEnd);
        }

        return svgString;
    }


    /**
     * changeColor() method replaces the fill attribute in the SVG string with the specified color value.
     * If the fill attribute is absent, this method will add it with a default color value.
     * It then returns the modified SVG string.
     *
     * @param svgString: a string representing the SVG file contents
     * @param color: a string representing the new color value to replace or update the fill attribute
     * @return the modified SVG string as a single string
     */
    public static String changeColor(String svgString, String color) {
        String newSvgString = svgString;
        String fillAttribute = "fill=\"";
        String defaultColor = "#000000"; // Default color to use if fill attribute is missing
        int fillIndex = newSvgString.indexOf(fillAttribute);

        // If fill attribute is missing, add it with default color
        if (fillIndex < 0) {
            newSvgString = newSvgString.replace("<svg", "<svg fill=\"" + defaultColor + "\"");
            fillIndex = newSvgString.indexOf(fillAttribute);
        }

        // Replace fill attribute with new color
        int endIndex = newSvgString.indexOf("\"", fillIndex + fillAttribute.length());
        newSvgString = newSvgString.substring(0, fillIndex + fillAttribute.length()) + color + newSvgString.substring(endIndex);

        return newSvgString;
    }

    /**
     * changeClass() method replaces the class attribute with a new class value in the SVG string.
     * It then returns the modified SVG string.
     *
     * @param svgString: a string representing the SVG file contents
     * @param newClass: a string representing the new class value to replace the existing class attribute
     * @return the modified SVG string as a single string
     */
    public static String changeClass(String svgString, String newClass) {
        return svgString.replaceAll("class=\".*?\"", "class=\"" + newClass + "\"");
    }

    /**
     * addClass() method adds a new class value to the existing class attribute in the SVG string.
     * If the class attribute does not exist, it will be created with the new class value.
     * If the new class value is null or empty, this method will return the unmodified SVG string.
     * It then returns the modified SVG string.
     *
     * @param svgString: a string representing the SVG file contents
     * @param newClass: a string representing the new class value to append to the existing class attribute or create a new class attribute
     * @return the modified SVG string as a single string
     */
    public static String addClass(String svgString, String newClass) {
        // Check if the newClass parameter is null or empty
        if (newClass == null || newClass.isEmpty()) {
            return svgString;
        }

        // Define the regular expression to find the class attribute
        Pattern pattern = Pattern.compile("class\\s*=\\s*[\'\"]([^\'\"]*)[\'\"]");

        // Find the class attribute in the SVG string
        Matcher matcher = pattern.matcher(svgString);
        if (matcher.find()) {
            // If the class attribute already exists, append the new class to it
            String currentClass = matcher.group(1);
            if (!currentClass.contains(newClass)) {
                currentClass += " " + newClass;
                svgString = svgString.replace(matcher.group(), "class=\"" + currentClass + "\"");
            }
        } else {
            // If the class attribute does not exist, add it to the opening <svg> tag
            svgString = svgString.replace("<svg", "<svg class=\"" + newClass + "\"");
        }

        return svgString;
    }

    /**
     * addAttribute() method adds a new attribute to the opening <svg> tag in the SVG string.
     * It then returns the modified SVG string.
     *
     * @param svgString: a string representing the SVG file contents
     * @param newAttribute: a string representing the new attribute to be added to the opening <svg> tag
     * @return the modified SVG string as a single string
     */
    public static String addAttribute(String svgString, String newAttribute) {
        int svgEnd = svgString.indexOf(">");
        return svgString.substring(0, svgEnd) + " " + newAttribute + svgString.substring(svgEnd);
    }

    /**
     * addStyle() method adds a new style to the existing style attribute or creates a new style attribute
     * in the opening <svg> tag in the SVG string.
     * It then returns the modified SVG string.
     *
     * @param svgString: a string representing the SVG file contents
     * @param newStyle: a string representing the new style to be added to the existing or new style attribute
     * @return the modified SVG string as a single string
     */
    public static String addStyle(String svgString, String newStyle) {
        int svgEnd = svgString.indexOf(">");

        // Check if style attribute exists
        int styleIndex = svgString.indexOf("style=");
        if (styleIndex < 0) {
            // Style attribute does not exist, add it to the opening <svg> tag
            svgString = svgString.substring(0, svgEnd) + " style=\"" + newStyle + "\"" + svgString.substring(svgEnd);
        } else {
            // Style attribute exists, add new style to existing style attribute
            int styleEndIndex = svgString.indexOf("\"", styleIndex + 7);
            String currentStyle = svgString.substring(styleIndex + 7, styleEndIndex);
            String newStyleValue = currentStyle.isEmpty() ? newStyle : currentStyle + ";" + newStyle;
            svgString = svgString.substring(0, styleIndex + 7) + newStyleValue + svgString.substring(styleEndIndex);
        }

        return svgString;
    }

    /**
     * exportSvgToFile() method exports the modified SVG string to a file at the specified file path.
     * It then returns nothing but throws an IOException if an issue occurs while writing to the file.
     *
     * @param svgString: a string representing the modified SVG file contents to be exported to a file
     * @param filePath: a string representing the file path at which to save the modified SVG file
     * @throws IOException if there is an error while writing to the file
     */
    public static void exportSvgToFile(String svgString, String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(svgString);
        }
    }

}