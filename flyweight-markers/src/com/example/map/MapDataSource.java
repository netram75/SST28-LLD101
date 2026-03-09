package com.example.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates a list of markers with random positions and styles.
 * After Flyweight refactor, styles are obtained from MarkerStyleFactory
 * so identical style configurations share the same instance.
 */
public class MapDataSource {

    private static final String[] SHAPES = {"PIN", "CIRCLE", "SQUARE"};
    private static final String[] COLORS = {"RED", "BLUE", "GREEN", "YELLOW"};
    private static final int[] SIZES = {10, 12, 14, 16};

    private final Random rand = new Random();

    // Flyweight factory
    private final MarkerStyleFactory styleFactory = new MarkerStyleFactory();

    public List<MapMarker> loadMarkers(int count) {

        List<MapMarker> markers = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            double lat = -90 + rand.nextDouble() * 180;
            double lng = -180 + rand.nextDouble() * 360;

            String label = "M" + i;

            String shape = SHAPES[rand.nextInt(SHAPES.length)];
            String color = COLORS[rand.nextInt(COLORS.length)];
            int size = SIZES[rand.nextInt(SIZES.length)];
            boolean filled = rand.nextBoolean();

            // Get shared style from factory (Flyweight)
            MarkerStyle style = styleFactory.get(shape, color, size, filled);

            markers.add(new MapMarker(lat, lng, label, style));
        }

        return markers;
    }
}