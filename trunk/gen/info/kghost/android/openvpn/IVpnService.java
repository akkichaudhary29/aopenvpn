/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\var\\work\\aopenvpn\\src\\info\\kghost\\android\\openvpn\\IVpnService.aidl
 */
package info.kghost.android.openvpn;
/**
 * Interface to access a VPN service.
 * {@hide}
 */
public interface IVpnService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements info.kghost.android.openvpn.IVpnService
{
private static final java.lang.String DESCRIPTOR = "info.kghost.android.openvpn.IVpnService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an info.kghost.android.openvpn.IVpnService interface,
 * generating a proxy if needed.
 */
public static info.kghost.android.openvpn.IVpnService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof info.kghost.android.openvpn.IVpnService))) {
return ((info.kghost.android.openvpn.IVpnService)iin);
}
return new info.kghost.android.openvpn.IVpnService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_connect:
{
data.enforceInterface(DESCRIPTOR);
info.kghost.android.openvpn.OpenvpnProfile _arg0;
if ((0!=data.readInt())) {
_arg0 = info.kghost.android.openvpn.OpenvpnProfile.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _result = this.connect(_arg0, _arg1, _arg2);
reply.writeNoException();
reply.writeInt(((_result)?(1):(0)));
return true;
}
case TRANSACTION_disconnect:
{
data.enforceInterface(DESCRIPTOR);
this.disconnect();
reply.writeNoException();
return true;
}
case TRANSACTION_checkStatus:
{
data.enforceInterface(DESCRIPTOR);
info.kghost.android.openvpn.VpnStatus _result = this.checkStatus();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
case TRANSACTION_getLog:
{
data.enforceInterface(DESCRIPTOR);
info.kghost.android.openvpn.LogQueue _result = this.getLog();
reply.writeNoException();
if ((_result!=null)) {
reply.writeInt(1);
_result.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
}
else {
reply.writeInt(0);
}
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements info.kghost.android.openvpn.IVpnService
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
/**
     * Sets up the VPN connection.
     * @param profile the profile object
     */
@Override public boolean connect(info.kghost.android.openvpn.OpenvpnProfile profile, java.lang.String username, java.lang.String password) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
boolean _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((profile!=null)) {
_data.writeInt(1);
profile.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
_data.writeString(username);
_data.writeString(password);
mRemote.transact(Stub.TRANSACTION_connect, _data, _reply, 0);
_reply.readException();
_result = (0!=_reply.readInt());
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Tears down the VPN connection.
     */
@Override public void disconnect() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_disconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
/**
     * Makes the service broadcast the connectivity state.
     */
@Override public info.kghost.android.openvpn.VpnStatus checkStatus() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
info.kghost.android.openvpn.VpnStatus _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_checkStatus, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = info.kghost.android.openvpn.VpnStatus.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
/**
     * Get current/last connection log
     */
@Override public info.kghost.android.openvpn.LogQueue getLog() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
info.kghost.android.openvpn.LogQueue _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getLog, _data, _reply, 0);
_reply.readException();
if ((0!=_reply.readInt())) {
_result = info.kghost.android.openvpn.LogQueue.CREATOR.createFromParcel(_reply);
}
else {
_result = null;
}
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_connect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_disconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_checkStatus = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_getLog = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
/**
     * Sets up the VPN connection.
     * @param profile the profile object
     */
public boolean connect(info.kghost.android.openvpn.OpenvpnProfile profile, java.lang.String username, java.lang.String password) throws android.os.RemoteException;
/**
     * Tears down the VPN connection.
     */
public void disconnect() throws android.os.RemoteException;
/**
     * Makes the service broadcast the connectivity state.
     */
public info.kghost.android.openvpn.VpnStatus checkStatus() throws android.os.RemoteException;
/**
     * Get current/last connection log
     */
public info.kghost.android.openvpn.LogQueue getLog() throws android.os.RemoteException;
}
