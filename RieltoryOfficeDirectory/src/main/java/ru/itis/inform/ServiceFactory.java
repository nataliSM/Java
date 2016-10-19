package ru.itis.inform;

import ru.itis.inform.services.*;

/**
 * Created by Natalia on 09.10.16.
 */
public class ServiceFactory {
    private static ServiceFactory ourInstance = new ServiceFactory();

    public static ServiceFactory getInstance() {

        return ourInstance;
    }

    public LoginService getLoginService ()
    {
        return new LoginServiceImpl();

    }    private ServiceFactory() {
    }

    public DataBaseConnectionServices getDataBaseConnectionServices(){

        return new DataBaseConnectionServicesImpl();
    }

    public RegistrationService getRegistrationService(){
        return new RegistrationServiceImpl();
    }
}
