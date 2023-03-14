SvgUtility Class

The SvgUtility class provides functionality to manipulate SVG files. The following methods are available:
Constructor

private SvgUtility(Path filePath)

    Initializes a new instance of the SvgUtility class with the specified filePath.

fromFile

public static SvgUtility fromFile(String filePath)

    Creates a new instance of the SvgUtility class from the specified file path.
    Returns the created SvgUtility object.

withClass

public SvgUtility withClass(String htmlClass)

    Sets the CSS class attribute of the SVG object in the file to the specified htmlClass value.
    Returns the current SvgUtility object.

withAttribute

public SvgUtility withAttribute(String attribute)

    Sets any additional attribute of the SVG object in the file to the specified attribute value.
    Returns the current SvgUtility object.

withColor

public SvgUtility withColor(String color)

    Sets the fill color value of the SVG object in the file to the specified color value.
    Returns the current SvgUtility object.

exportToFile

public void exportToFile(String filePath) throws IOException 

    Modifies the SVG file as per provided properties and saves it to the specified filePath.
    Throws an IOException in case of any error while writing to file.

parseSvgToString

private static String parseSvgToString(String svgContent, String htmlClass, String attribute)

    Private method for updating the SVG string content with the specified CSS class and additional attribute.
    Returns the updated SVG string.

changeColor

private static String changeColor(String svgString, String color)

    Private method for updating the fill color in the SVG string.
    Returns the updated SVG string.

