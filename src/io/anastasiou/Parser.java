package io.anastasiou;

import org.json.*;

public class Parser {
    private String json;

    public Parser(String json) {
        this.json = json;
    }

    public class Location {
        private Double lat;
        private Double lng;

        public Location(Double lat, Double lng) {
            this.lat = lat;
            this.lng = lng;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }

    public Location getLocation() {
        Double lat = new JSONObject(this.json)
                .getJSONArray("items")
                .getJSONObject(0)
                .getJSONObject("position")
                .getDouble("lat");

        Double lng = new JSONObject(this.json)
                .getJSONArray("items")
                .getJSONObject(0)
                .getJSONObject("position")
                .getDouble("lng");

        return new Location(lat, lng);
    }
}
