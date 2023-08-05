package booking.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "buses")
public class Bus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String busName;
    private String routeFrom;
    private String routeTo;
    private String busType;
    private Date departure;
    private Date arrival;
    private int totalSeats;
    private int fare;

@OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<Booking> booking = new ArrayList<>();


}
