package booking.payload;

import lombok.Data;

import java.util.Date;

@Data
public class BusDto {

   private Long Id;

   private String busName;
   private String routeFrom;
   private String routeTo;
   private String busType;
   private Date departure;
   private Date arrival;
   private int totalSeats;
   private int fare;
}
