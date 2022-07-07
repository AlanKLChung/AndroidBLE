package acitr.ac.ble.BleOperator;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;

import java.util.TreeMap;

public abstract class BleRun00Operator extends ListActivity {

    protected BluetoothAdapter BluetoothAdapterObj = null;
    protected BluetoothManager BluetoothManagerObj = null;
    protected BluetoothGatt BluetoothGattObj = null;

    protected Context ContextObj = null;
    //----------------------------------------------------------------------------------------------------------------------------------------------------------
    protected boolean mScanning = false;
    protected Handler mHandler = null;
    protected static final long SCAN_PERIOD = 8000; // set 5 seconds

    protected TreeMap<String, BluetoothDevice> FoundDeviceList = new TreeMap<String, BluetoothDevice>();


}