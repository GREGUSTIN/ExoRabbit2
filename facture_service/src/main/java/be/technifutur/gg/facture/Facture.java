package be.technifutur.gg.facture;

import lombok.Data;

import java.util.UUID;

@Data
public class Facture {

    private double prix;
    private UUID reservation_ref;
}
