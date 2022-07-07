package acitr.ac.ble.BleOperator;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

public abstract class BleRun10DeviceSearch extends BleRun10DeviceConnect {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private boolean DeviceScanStartFun() {
        try {
            if (mScanning == true) {
                mScanning = false;

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
                BluetoothAdapterObj.stopLeScan(mLeScanCallback);

            }
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

    //======================================================================================================================================================
    protected boolean DeviceScanFun(final boolean enable) {
        try {
            if (enable == true) {


                //-------------------------------------------------------------------------------------------------------------------------------------------------------
                // Stops scanning after a pre-defined scan period.
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DeviceScanStartFun();

                    }
                }, SCAN_PERIOD);
                //-------------------------------------------------------------------------------------------------------------------------------------------------------

                mScanning = true;

                if (ActivityCompat.checkSelfPermission(this.ContextObj, Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {

                    return false;
                }
                this.BluetoothAdapterObj.startDiscovery();
                this.BluetoothAdapterObj.startLeScan(mLeScanCallback);
                this.FoundDeviceList.clear();
                //-------------------------------------------------------------------------------------------------------------------------------------------------------

                //-------------------------------------------------------------------------------------------------------------------------------------------------------
            } else {
                mScanning = false;
                BluetoothAdapterObj.stopLeScan(mLeScanCallback);
            }
            return true;
        } catch (Exception ex) {

        }
        return false;
    }

    //========================================================================================================================================
    private boolean DeviceFoundProcessFun(BluetoothDevice device, int PowerSignal, byte[] scanRecord) {
        try {
            String MacAddress = device.getAddress();
            if (ActivityCompat.checkSelfPermission(this.ContextObj, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
            String DeviceName = device.getName();


            if (FoundDeviceList.containsKey(MacAddress) == false) {
                FoundDeviceList.put(MacAddress, device);

            }
            //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
    //=====================================================================================================================================================
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, final int PowerSignal, final byte[] scanRecord) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    DeviceFoundProcessFun(device, PowerSignal, scanRecord);
                }
            });
        }
    };
    //=====================================================================================================================================================
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
