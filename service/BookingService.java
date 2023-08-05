package booking.service;

import booking.payload.BookingDto;

public interface BookingService {

    BookingDto createBooking(long busId, BookingDto bookingDto);
}
