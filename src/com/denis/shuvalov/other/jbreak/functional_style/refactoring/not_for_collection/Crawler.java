package com.denis.shuvalov.other.jbreak.functional_style.refactoring.not_for_collection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Crawler {

    //with javaslang

/*    Try<String> getContent(String location) {
        return Try
                .of(() -> new URL(location))
                .filter(url -> "http".equals(url.getProtocol()))
                .flatMap(url -> Try.of(url::openConnection))
                .flatMap(con -> Try.of(con::getInputStream))
                .map(this::readAndClose);
    }*/

    String readContent(String location) {
        try {
            URL url = new URL(location);

            if (!"http".equals(url.getProtocol())) {
                throw new UnsupportedOperationException("Protocol is not http");
            }

            URLConnection urlConnection = url.openConnection();
            try (InputStream in = urlConnection.getInputStream()) {
                return read(in);
            }

        } catch (IOException e) {
            throw new RuntimeException("Error loading location " + location, e);
        }
    }

    private String read(InputStream in) {
        return "";
    }
}
