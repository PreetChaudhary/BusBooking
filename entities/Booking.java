package booking.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Booking")
public class Booking {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long Id;
      private int seatFrom;
      private int seatTo;
      private int status;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "bus_id")
      private Bus bus;

      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "customer_id")
      private Customer customer;





}
