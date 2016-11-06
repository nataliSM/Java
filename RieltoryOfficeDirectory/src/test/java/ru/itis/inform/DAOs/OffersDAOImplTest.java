package ru.itis.inform.DAOs;

import org.junit.Test;
import ru.itis.inform.factories.RieltoryFactory;
import ru.itis.inform.models.rieltoryModel.Offer;
import ru.itis.inform.models.rieltoryModel.OffersTable;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Natalia on 06.11.16.
 */
public class OffersDAOImplTest {
    @Test
    public void getAllOffersWithParams() throws Exception {
        OffersDAO offersDAO = RieltoryFactory.getInstance().getOffersDAO();
        List<Offer> list = offersDAO.getAllOffersWithParams(2, "хорошее", "есть", "Казань");
        for (Offer offer:list) {
            System.out.println(offer);
        }
        assertNotNull(list);


    }

}