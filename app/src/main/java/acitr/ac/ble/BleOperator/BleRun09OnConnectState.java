package acitr.ac.ble.BleOperator;

import android.Manifest;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothProfile;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public abstract  class BleRun09OnConnectState extends BleRun08OnGattService{

    //======================================================================================================================================================
    protected boolean onConnectionStateChangeProcessFun(BluetoothGatt gatt, int status, int newState) {
        try {
            String MacAddress = gatt.getDevice().getAddress();
            if (ActivityCompat.checkSelfPermission(this.ContextObj, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {

                return false;
            }
            String DeviceName = gatt.getDevice().getName();

            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            if (newState == BluetoothProfile.STATE_CONNECTED) {


                //----------------------------------------------------------------------------------------------------------------------------------
            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {

                //----------------------------------------------------------------------------------------------------------------------------------
            } else if (newState == BluetoothProfile.STATE_CONNECTING) {

                //----------------------------------------------------------------------------------------------------------------------------------
            } else if (newState == BluetoothProfile.STATE_DISCONNECTING) {

                //----------------------------------------------------------------------------------------------------------------------------------
            } else {

            }
            return true;
        } catch (Exception ex) {

        }
        return false;
    }
    //======================================================================================================================================================
}
