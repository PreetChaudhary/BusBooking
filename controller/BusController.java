package booking.controller;

import booking.payload.BusDto;
import booking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")

public class BusController {

    @Autowired
    private BusService busService;



    //http://localhost:8080/api/bus
    @PostMapping
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
        BusDto dto = busService.createBus(busDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<BusDto> getAllBus() {
        return busService.getAllBus();
    }

    //http://localhost:8080/api/bus/id
    @GetMapping("/{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(busService.getBusById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusDto> updateBusById(@RequestBody BusDto busDto, @PathVariable("id") Long id) {
        BusDto busResponse = busService.updateBusById(busDto, id);

        return ResponseEntity.ok(busResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBusById(@PathVariable("id") Long id) {

        busService.deleteBusById(id);
        return new ResponseEntity<String>("Bus is Deleted!!..", HttpStatus.OK);

    }
}
