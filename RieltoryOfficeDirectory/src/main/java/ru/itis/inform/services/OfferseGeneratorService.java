package ru.itis.inform.services;

import ru.itis.inform.models.rieltoryModel.Offer;

import java.util.List;

/**
 * Created by Natalia on 06.11.16.
 */
public interface OfferseGeneratorService {
    public List<Offer> generateOfferces(int numberOfRooms, String condition, String repair, String cityName);
}
