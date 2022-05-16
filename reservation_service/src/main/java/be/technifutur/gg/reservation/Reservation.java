package be.technifutur.gg.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
public class Reservation {

    private UUID ref = UUID.randomUUID();
    private int nbNuit;
    private Status status;

    public static enum Status{
        DEMANDE,
        FACTURE
    }


}
