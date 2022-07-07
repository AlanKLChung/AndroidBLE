package acitr.ac.ble.BleOperator;

import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public abstract class BleRun10DeviceConnect extends BleRun09OnConnectState{


    //======================================================================================================================================================
    protected boolean DeviceConnectFun(BluetoothDevice BluetoothDeviceObj) {
        try {

            if (ActivityCompat.checkSelfPermission(this.ContextObj, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
            this.BluetoothGattObj = BluetoothDeviceObj.connectGatt(this, false, mGattDevice01Callback);
            if (this.BluetoothGattObj == null){

                return false;
            }
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

    //======================================================================================================================================================
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //======================================================================================================================================================
    protected final BluetoothGattCallback mGattDevice01Callback = new BluetoothGattCallback() {
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (onConnectionStateChangeProcessFun(gatt, status, newState) == false){

            }
        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {
            if (onServicesDiscoveredProcessFun(gatt,status) == false){

            }
        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        @Override
        public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
            if (onCharacteristicReadProcessFun(gatt,characteristic,status) == false){

            }
        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            if (onCharacteristicChangedProcessFun(gatt,characteristic) == false){

            }
        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        @Override
        public void onPhyUpdate(BluetoothGatt gatt, int txPhy, int rxPhy, int status) {

        }
        //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    };
    //======================================================================================================================================================
    //======================================================================================================================================================
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
