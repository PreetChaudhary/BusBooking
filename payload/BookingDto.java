package booking.payload;

import lombok.Data;

@Data
public class BookingDto {
    private long Id;
    private int seatFrom;
    private int seatTo;
    private int status;
}
