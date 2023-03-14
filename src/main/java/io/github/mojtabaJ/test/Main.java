package io.github.mojtabaJ.test;

import io.github.mojtabaJ.SvgUtilityBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            SvgUtilityBuilder builder = new SvgUtilityBuilder();
            String svgString = builder
                    .setSvgFile( Main.class.getResource("example.svg").getPath())
                    .addColor("#FF0000")
                    .addClass("happ")
                    .addClass("moj")
                    .addClass("morrr")
                    .addNewAttribute("baz='321321321'")
                    .addNewStyle("opacity: 0.5; stroke: #00FF00;")
                    .addFilePath(Main.class.getResource("out-put.svg").getPath())
                    .build();

            System.out.println("SVG file successfully modified and exported");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }




}