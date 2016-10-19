package ru.itis.inform.services;

import java.sql.Connection;

/**
 * Created by Natalia on 09.10.16.
 */
public interface DataBaseConnectionServices {
    Connection getConnection();
}
