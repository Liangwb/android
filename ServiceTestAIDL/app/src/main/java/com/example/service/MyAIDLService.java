/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.service;
// Declare any non-default types here with import statements

public interface MyAIDLService extends android.os.IInterface
{
  /** Default implementation for MyAIDLService. */
  public static class Default implements com.example.service.MyAIDLService
  {
    //获取String数据

    @Override public java.lang.String getString() throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.service.MyAIDLService
  {
    private static final java.lang.String DESCRIPTOR = "com.example.service.MyAIDLService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.service.MyAIDLService interface,
     * generating a proxy if needed.
     */
    public static com.example.service.MyAIDLService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.service.MyAIDLService))) {
        return ((com.example.service.MyAIDLService)iin);
      }
      return new com.example.service.MyAIDLService.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_getString:
        {
          data.enforceInterface(descriptor);
          java.lang.String _result = this.getString();
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.service.MyAIDLService
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      //获取String数据

      @Override public java.lang.String getString() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getString, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getString();
          }
          _reply.readException();
          _result = _reply.readString();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.example.service.MyAIDLService sDefaultImpl;
    }
    static final int TRANSACTION_getString = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.example.service.MyAIDLService impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.example.service.MyAIDLService getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  //获取String数据

  public java.lang.String getString() throws android.os.RemoteException;
}
