/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.service;
// Declare any non-default types here with import statements

public interface Cal extends android.os.IInterface
{
  /** Default implementation for Cal. */
  public static class Default implements com.example.service.Cal
  {
    //cal value of num!

    @Override public int foctorial(int num) throws android.os.RemoteException
    {
      return 0;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.service.Cal
  {
    private static final java.lang.String DESCRIPTOR = "com.example.service.Cal";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.service.Cal interface,
     * generating a proxy if needed.
     */
    public static com.example.service.Cal asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.service.Cal))) {
        return ((com.example.service.Cal)iin);
      }
      return new com.example.service.Cal.Stub.Proxy(obj);
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
        case TRANSACTION_foctorial:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _result = this.foctorial(_arg0);
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.service.Cal
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
      //cal value of num!

      @Override public int foctorial(int num) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(num);
          boolean _status = mRemote.transact(Stub.TRANSACTION_foctorial, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().foctorial(num);
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.example.service.Cal sDefaultImpl;
    }
    static final int TRANSACTION_foctorial = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(com.example.service.Cal impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.example.service.Cal getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  //cal value of num!

  public int foctorial(int num) throws android.os.RemoteException;
}
