package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            SvgUtilityBuilder builder = new SvgUtilityBuilder();
            String svgString = builder
                    .setSvgFile("C:\\Users\\Mojtaba\\IdeaProjects\\tsvg\\t-svg\\src\\main\\java\\org\\example\\svg\\audible.svg")
                    .addColor("#FF0000")
                    .addClass("happ")
                    .addClass("moj")
                    .addClass("morrr")
                    .addNewAttribute("baz='321321321'")
                    .addNewStyle("opacity: 0.5; stroke: #00FF00;")
                    .addFilePath("C:\\Users\\Mojtaba\\IdeaProjects\\tsvg\\t-svg\\src\\main\\java\\org\\example\\svg\\001.svg")
                    .build();

            System.out.println("SVG file successfully modified and exported");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }




}