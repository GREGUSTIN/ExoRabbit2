package be.technifutur.gg.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationFactureDTO {

        private UUID ref;
        private int nbNuit;
        private double prix;


}
