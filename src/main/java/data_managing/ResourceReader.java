package data_managing;

import data_managing.exceptions.ResourceReadFailedException;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

public class ResourceReader {
    private ResourceReader() {
    }

    public static String getResourceAsString(final String pathWithinResFolder) {
        InputStream resourceStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(pathWithinResFolder);

        if (Objects.isNull(resourceStream)) {
            throw new ResourceReadFailedException("Resource not found: " + pathWithinResFolder);
        }
        try (Scanner scanner = new Scanner(resourceStream, StandardCharsets.UTF_8.name())) {
            LoggerSupplier.getLogger().debug(String.format("Reading resource: %s", pathWithinResFolder));
            return scanner.useDelimiter("\\A").next();
        }
    }
}
