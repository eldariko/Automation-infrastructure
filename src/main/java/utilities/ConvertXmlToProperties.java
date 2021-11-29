package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConvertXmlToProperties {
    private static final Properties props = new Properties();

    public static void initPropertyFile() {
        try (InputStream input =
                     new FileInputStream(System.getProperty("user.dir") + "\\prop.xml")) {
            // loads from XML into a properties file
            props.loadFromXML(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static Properties getProps() {
        return props;
    }

}

