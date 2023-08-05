package booking.service;


import booking.payload.BusDto;

import java.util.List;

public interface BusService {
    

    BusDto createBus(BusDto busDto);

    List<BusDto> getAllBus();

    BusDto getBusById(Long id);

    BusDto updateBusById(BusDto busDto, Long id);

    void deleteBusById(Long id);
}
