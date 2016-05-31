package csheets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A "global" (singleton) class with the application settings.
 *
 * @author Paulo Gandra Sousa
 */
public final class AppSettings {

    private final Properties applicationProperties = new Properties();
    // private final static String PROPERTIES_RESOURCE =
    // "eapli/ecafeteria/ecafeteria.properties";
    private final static String PROPERTIES_RESOURCE = "cleansheets.properties";
    private final static String REPOSITORY_FACTORY_KEY = "persistence.repositoryFactory";

    // use lazy holder idiom
    // https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
    private static class LazyHolder {

        public static final AppSettings INSTANCE = new AppSettings();
    }

    public static AppSettings instance() {
        return LazyHolder.INSTANCE;
    }

    private AppSettings() {
        loadProperties();
    }

    private void loadProperties() {
        InputStream propertiesStream = null;
        try {
            // propertiesStream = new FileInputStream(PROPERTIES_FILENAME);
            propertiesStream = AppSettings.class.getClassLoader().
                    getResourceAsStream(PROPERTIES_RESOURCE);
            if (propertiesStream != null) {
                this.applicationProperties.load(propertiesStream);
            } else {
                throw new FileNotFoundException(
                        "property file '" + PROPERTIES_RESOURCE + "' not found in the classpath");
            }
        } catch (final IOException exio) {
            setDefaultProperties();

            Logger.getLogger(AppSettings.class.getName()).
                    log(Level.SEVERE, null, exio);
        } finally {
            if (propertiesStream != null) {
                try {
                    propertiesStream.close();
                } catch (final IOException ex) {
                    Logger.getLogger(AppSettings.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setDefaultProperties() {
        this.applicationProperties.setProperty(REPOSITORY_FACTORY_KEY,
                "eapli.ecafeteria.persistence.jpa.JpaRepositoryFactory");
    }

    public String getRepositoryFactory() {
        return this.applicationProperties.getProperty(REPOSITORY_FACTORY_KEY);
    }
}
