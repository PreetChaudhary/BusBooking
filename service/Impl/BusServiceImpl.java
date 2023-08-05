package booking.service.Impl;

import booking.Repository.BusRepository;
import booking.entities.Bus;
import booking.exception.ResourceNotFoundException;
import booking.payload.BusDto;
import booking.service.BusService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private ModelMapper mapper;



    @Override
    public BusDto createBus(BusDto busDto) {
        //convert Dto to Entity
      Bus bus = mapToEntity(busDto);
        Bus newBus = busRepository.save(bus);

        //convert Entity to Dto

      BusDto busResponse =  mapToDto(newBus);

        return busResponse;
    }

    private BusDto mapToDto(Bus newBus) {
        BusDto dto = mapper.map(newBus, BusDto.class);
        return dto;
    }

    @Override
    public List<BusDto> getAllBus() {
        List<Bus> bus = busRepository.findAll();
        return bus.stream().map(buses->mapToDto(buses)).collect(Collectors.toList());
    }

    @Override
    public BusDto getBusById(Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bus Not found"));
        return mapToDto(bus);
    }

    @Override
    public BusDto updateBusById(BusDto busDto, Long id) {
        Bus bus = busRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bus is updated")
        );
        bus.setBusName(busDto.getBusName());
        bus.setBusType(busDto.getBusType());
        bus.setDeparture(busDto.getDeparture());
        bus.setArrival(busDto.getArrival());
        bus.setRouteFrom(busDto.getRouteFrom());
        bus.setRouteTo(busDto.getRouteTo());
        bus.setTotalSeats(busDto.getTotalSeats());

        Bus updatedBus = busRepository.save(bus);

        return mapToDto(updatedBus);
    }

    @Override
    public void deleteBusById(Long id) {
        busRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("bus is deleted...")
        );
        busRepository.deleteById(id);
    }









    private Bus mapToEntity(BusDto busDto) {
        Bus bus = mapper.map(busDto, Bus.class);
        return bus;

}
}
