package acitr.ac.ble.BleOperator;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

import java.util.Date;

public abstract class BleRun07OnGattCharacteristic extends BleRun00Operator{

    protected boolean onCharacteristicReadProcessFun(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        try {



            if (status != BluetoothGatt.GATT_SUCCESS) {

                return false;
            }

            String UDIDString = characteristic.getUuid().toString();
            int flag = characteristic.getProperties();
            int format = -1;
            if ((flag & 0x01) != 0) {
                format = BluetoothGattCharacteristic.FORMAT_UINT16;

            } else {
                format = BluetoothGattCharacteristic.FORMAT_UINT8;
            }
            final int heartRate = characteristic.getIntValue(format, 1);



            final byte[] data = characteristic.getValue();
            if (data != null && data.length > 0) {
                final StringBuilder stringBuilder = new StringBuilder(data.length);
                for (byte byteChar : data) {
                    stringBuilder.append(String.format("%02X ", byteChar));
                }

            }
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

    protected boolean onCharacteristicChangedProcessFun(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
        try {


            final byte[] DataBytes = characteristic.getValue();
            if (DataBytes != null && DataBytes.length > 0) {


                final StringBuilder stringBuilder = new StringBuilder(DataBytes.length);
                for (byte byteChar : DataBytes) {
                    stringBuilder.append(String.format("%02X ", byteChar));
                }


            }
            return true;
        } catch (Exception ex) {

        }
        return false;
    }



}
