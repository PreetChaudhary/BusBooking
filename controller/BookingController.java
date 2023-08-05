package booking.controller;

import booking.payload.BookingDto;
import booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    //http://localhost:8080/api/bus/{busId}/bookings
    @PostMapping("/bus/{busId}/bookings")
    public ResponseEntity<BookingDto> createBooking(@PathVariable("busId") long busId, @RequestBody BookingDto bookingDto){
   return new ResponseEntity<>(bookingService.createBooking(busId,bookingDto),HttpStatus.CREATED);
    }

    



}
