package com.czy.server;

import android.os.RemoteException;
import android.util.Log;

public class ServiceBinder extends IPersonService.Stub {
    @Override
    public void save(Person person) throws RemoteException {
        Log.i("PersonService", person.getId()+"="+ person.getName());

    }
}
