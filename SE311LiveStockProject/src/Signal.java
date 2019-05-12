interface Signal{
	public  double sendLocation(double location);
}
//This the  "Target" class, BluetoothSignal. 
//Our device is manufactured for to be used with ZigbeeSignal.
abstract class BluetoothSignal implements Signal {
	public abstract double sendLocation(double location);
}
//This is the "Adaptee" class, ZigbeeSignal
class ZigbeeSignal implements Signal{
	public double sendLocation(double location){
		return location;
	}
}
//This is the "Adapter" class. BluetoothToZigbeeConnector.
//We need a connector so our signal works.
class BluetoothToZigbeeConnector extends BluetoothSignal {
	private ZigbeeSignal _zigbeeSignal;
	public BluetoothToZigbeeConnector(ZigbeeSignal zigbeeSignal){
		this._zigbeeSignal=zigbeeSignal;
	}
	public double sendLocation(double location){
		return _zigbeeSignal.sendLocation(location);
	}
}