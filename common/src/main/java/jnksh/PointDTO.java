package jnksh;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class PointDTO {

        private double lat;
        private double lon;
        private String autoId;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }

        public String getAutoId() {
            return autoId;
        }

        public void setAutoId(String autoId) {
            this.autoId = autoId;
        }

        public String toJson() throws JsonProcessingException {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        }

        public PointDTO fromJson(final String str) throws IOException {
            ObjectMapper mapper =new ObjectMapper();
            PointDTO point = mapper.readValue(str, PointDTO.class);
            return point;
        }
        @Override
        public String toString() {
            return "PointDTO{" +
                    "lat=" + lat +
                    ", lon=" + lon +
                    ", autoId='" + autoId + '\'' +
                    '}';
        }
    }

