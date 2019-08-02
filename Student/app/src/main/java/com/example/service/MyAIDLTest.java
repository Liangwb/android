/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package com.example.service;
public interface MyAIDLTest extends android.os.IInterface
{
  /** Default implementation for MyAIDLTest. */
  public static class Default implements com.example.service.MyAIDLTest
  {
    @Override public int add(int arg1, int arg2) throws android.os.RemoteException
    {
      return 0;
    }
    @Override public java.lang.String inStudentInfo(com.example.service.Student student) throws android.os.RemoteException
    {
      return null;
    }
    //代表student值由客户端输入

    @Override public java.lang.String outStudentInfo(com.example.service.Student student) throws android.os.RemoteException
    {
      return null;
    }
    //代表student值由服务端设置

    @Override public java.lang.String inOutStudentInfo(com.example.service.Student student) throws android.os.RemoteException
    {
      return null;
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements com.example.service.MyAIDLTest
  {
    private static final java.lang.String DESCRIPTOR = "com.example.service.MyAIDLTest";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.example.service.MyAIDLTest interface,
     * generating a proxy if needed.
     */
    public static com.example.service.MyAIDLTest asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof com.example.service.MyAIDLTest))) {
        return ((com.example.service.MyAIDLTest)iin);
      }
      return new com.example.service.MyAIDLTest.Stub.Proxy(obj);
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
        case TRANSACTION_add:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _result = this.add(_arg0, _arg1);
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        case TRANSACTION_inStudentInfo:
        {
          data.enforceInterface(descriptor);
          com.example.service.Student _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.example.service.Student.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          java.lang.String _result = this.inStudentInfo(_arg0);
          reply.writeNoException();
          reply.writeString(_result);
          return true;
        }
        case TRANSACTION_outStudentInfo:
        {
          data.enforceInterface(descriptor);
          com.example.service.Student _arg0;
          _arg0 = new com.example.service.Student();
          java.lang.String _result = this.outStudentInfo(_arg0);
          reply.writeNoException();
          reply.writeString(_result);
          if ((_arg0!=null)) {
            reply.writeInt(1);
            _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          return true;
        }
        case TRANSACTION_inOutStudentInfo:
        {
          data.enforceInterface(descriptor);
          com.example.service.Student _arg0;
          if ((0!=data.readInt())) {
            _arg0 = com.example.service.Student.CREATOR.createFromParcel(data);
          }
          else {
            _arg0 = null;
          }
          java.lang.String _result = this.inOutStudentInfo(_arg0);
          reply.writeNoException();
          reply.writeString(_result);
          if ((_arg0!=null)) {
            reply.writeInt(1);
            _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
          }
          else {
            reply.writeInt(0);
          }
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements com.example.service.MyAIDLTest
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
      @Override public int add(int arg1, int arg2) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(arg1);
          _data.writeInt(arg2);
          boolean _status = mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().add(arg1, arg2);
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
      @Override public java.lang.String inStudentInfo(com.example.service.Student student) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((student!=null)) {
            _data.writeInt(1);
            student.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_inStudentInfo, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().inStudentInfo(student);
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
      //代表student值由客户端输入

      @Override public java.lang.String outStudentInfo(com.example.service.Student student) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_outStudentInfo, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().outStudentInfo(student);
          }
          _reply.readException();
          _result = _reply.readString();
          if ((0!=_reply.readInt())) {
            student.readFromParcel(_reply);
          }
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      //代表student值由服务端设置

      @Override public java.lang.String inOutStudentInfo(com.example.service.Student student) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        java.lang.String _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          if ((student!=null)) {
            _data.writeInt(1);
            student.writeToParcel(_data, 0);
          }
          else {
            _data.writeInt(0);
          }
          boolean _status = mRemote.transact(Stub.TRANSACTION_inOutStudentInfo, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().inOutStudentInfo(student);
          }
          _reply.readException();
          _result = _reply.readString();
          if ((0!=_reply.readInt())) {
            student.readFromParcel(_reply);
          }
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.example.service.MyAIDLTest sDefaultImpl;
    }
    static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_inStudentInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_outStudentInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    static final int TRANSACTION_inOutStudentInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
    public static boolean setDefaultImpl(com.example.service.MyAIDLTest impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.example.service.MyAIDLTest getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public int add(int arg1, int arg2) throws android.os.RemoteException;
  public java.lang.String inStudentInfo(com.example.service.Student student) throws android.os.RemoteException;
  //代表student值由客户端输入

  public java.lang.String outStudentInfo(com.example.service.Student student) throws android.os.RemoteException;
  //代表student值由服务端设置

  public java.lang.String inOutStudentInfo(com.example.service.Student student) throws android.os.RemoteException;
}
