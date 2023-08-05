package booking.service.Impl;

import booking.Repository.BookingRepository;
import booking.Repository.BusRepository;
import booking.entities.Booking;
import booking.entities.Bus;
import booking.exception.ResourceNotFoundException;
import booking.payload.BookingDto;
import booking.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private BusRepository busRepository;

    @Override
    public BookingDto createBooking(long busId, BookingDto bookingDto) {
        //convert dto to entity
        Booking booking = mapToEntity(bookingDto);

        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFoundException("booking not created with the use of busid")
        );
        booking.setBus(bus);
        //convert entity to Dto
        Booking newBooking = bookingRepository.save(booking);

        return mapToDto(newBooking);
    }



    private BookingDto mapToDto(Booking newBooking) {
        BookingDto bookingDto = mapper.map(newBooking, BookingDto.class);
        return  bookingDto;

    }

    private Booking mapToEntity(BookingDto bookingDto) {
        Booking booking = mapper.map(bookingDto, Booking.class);
        return booking;
    }


}
