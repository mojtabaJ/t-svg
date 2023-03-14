package io.github.mojtabaJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The SvgUtilityBuilder class provides a convenient way to construct and modify SVG files using the SvgUtility class.
 * It implements the builder pattern, allowing you to set various parameters for the SvgUtility methods and then
 * create the modified SVG file using the build() method.
 * Author: Mojtaba Jalambadani
 * Version: 1.0
 */
public class SvgUtilityBuilder {

    // Fields to store the parameters for the SvgUtility methods
    private String svgFile;
    private String htmlClass;
    private String attribute;
    private String color;
    private String newClass;
    private String newAttribute;
    private String newStyle;
    private String filePath;
    private List<String> addClasses;

    /**
     * Sets the SVG file to be used by the SvgUtility methods.
     *
     * @param svgFile a string representing the file path of the SVG to be used
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder setSvgFile(String svgFile) {
        this.svgFile = svgFile;
        return this;
    }

    /**
     * Sets the HTML class to be used by the SvgUtility methods.
     *
     * @param htmlClass a string representing the HTML class to be set
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder setHtmlClass(String htmlClass) {
        this.htmlClass = htmlClass;
        return this;
    }

    /**
     * Sets the additional attribute to be added to the opening <svg> tag by the SvgUtility methods.
     *
     * @param attribute a string representing the new attribute to be added
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder setAttribute(String attribute) {
        this.attribute = attribute;
        return this;
    }

    /**
     * Adds a new fill color to the SVG by calling the SvgUtility.changeColor() method.
     *
     * @param color a string representing the new fill color to be set
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder addColor(String color) {
        this.color = color;
        return this;
    }

    /**
     * Sets a new CSS class for the SVG by calling the SvgUtility.changeClass() method.
     * This method replaces the existing "class" attribute with the new class value.
     *
     * @param newClass a string representing the new class value to replace the existing "class" attribute
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder addNewClass(String newClass) {
        this.newClass = newClass;
        return this;
    }


    /**
     * Adds a new attribute to the opening <svg> tag by calling the SvgUtility.addAttribute() method.
     *
     * @param newAttribute a string representing the new attribute to be added
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder addNewAttribute(String newAttribute) {
        this.newAttribute = newAttribute;
        return this;
    }



    /**
     * Adds a new style to the SVG by calling the SvgUtility.addStyle() method.
     *
     * @param newStyle a string representing the new style to be added
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder addNewStyle(String newStyle) {
        this.newStyle = newStyle;
        return this;
    }

    /**
     * Sets the file path for exporting the modified SVG file by calling the SvgUtility.exportSvgToFile() method.
     *
     * @param filePath a string representing the file path to export the modified SVG file to
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder addFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    /**
     * Adds a new CSS class to the SVG by calling the SvgUtility.addClass() method.
     * This method can be called multiple times to add multiple classes.
     *
     * @param newClass a string representing the new class to be added
     * @return the SvgUtilityBuilder instance for method chaining
     */
    public SvgUtilityBuilder addClass(String newClass) {
        if (addClasses == null) {
            addClasses = new ArrayList<>();
        }
        addClasses.add(newClass);
        return this;
    }


    /**
     * Builds and returns the modified SVG file as a string by calling the appropriate SvgUtility methods
     * based on the parameters set by the builder methods.
     *
     * @return a string representing the modified SVG file, or null if the file has been exported to a file
     * @throws IOException if there is an error exporting the modified SVG file to a file
     */
    public String build() throws IOException {
        String svgString = SvgUtility.parseSvgToString(svgFile, htmlClass, attribute);
        if (color != null) {
            svgString = SvgUtility.changeColor(svgString, color);
        }
        if (addClasses != null) {
            for (String newClass : addClasses) {
                svgString = SvgUtility.addClass(svgString, newClass);
            }
        }
        if (newAttribute != null) {
            svgString = SvgUtility.addAttribute(svgString, newAttribute);
        }
        if (newStyle != null) {
            svgString = SvgUtility.addStyle(svgString, newStyle);
        }

        if (filePath != null) {
            SvgUtility.exportSvgToFile(svgString, filePath);
            return null;
        }
        return svgString;
    }
}
