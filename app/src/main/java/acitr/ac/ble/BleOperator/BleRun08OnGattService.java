package acitr.ac.ble.BleOperator;

import android.Manifest;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.List;

public abstract class BleRun08OnGattService extends BleRun06OnGattDescriptor {

    protected boolean DiscoverServicesFun() {

        try {
            if (BluetoothGattObj != null) {
                if (ActivityCompat.checkSelfPermission(this.ContextObj, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
                if (BluetoothGattObj.discoverServices() == true) {
                    return true;
                }

            }
            //--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        } catch (Exception ex) {

        }
        return false;
    }

    protected boolean onServicesDiscoveredProcessFun(BluetoothGatt gatt, int status) {
        try {
            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            if (status == BluetoothGatt.GATT_SUCCESS) {

                List<BluetoothGattService> getServiceList = gatt.getServices();
                if (getServiceList == null) {

                    return false;
                }
                //--------------------------------------------------------------------------------------------------------------------------
                // --------------------------------------------------------------
                if (getServiceList.size() == 0) {

                    return false;
                }
                //------------------------------------------------------------------------------------------------------------------------------
                // ----------------------------------------------------------


                for (BluetoothGattService BluetoothGattServiceObj : getServiceList) {

                    String GattServiceUDID = BluetoothGattServiceObj.getUuid().toString();






                        List<BluetoothGattCharacteristic> getCharacteristicsList = BluetoothGattServiceObj.getCharacteristics();
                        //-----------------------------------------------------------------------------------------------------------------------------------------
                        if (getCharacteristicsList == null || getCharacteristicsList.size() == 0) {


                            return false;


                        }


                    }
                }



            //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            return true;
        } catch (Exception ex) {

        }
        return false;
    }


}
