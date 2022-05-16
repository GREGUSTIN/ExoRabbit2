package be.technifutur.gg.facture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
public class Reservation {

    private UUID ref;
    private int nbNuit;
    private Status status;


    public static enum Status{
        DEMANDE,
        FACTURE
    }
}
