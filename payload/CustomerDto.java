package booking.payload;

import lombok.Data;

@Data
public class CustomerDto {
    private Long Id;

    private String firstName;
    private String lastName;
    private String address;
    private int mobile;
}
