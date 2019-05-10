interface Signal{
	public  double sendLocation(double location);
}
abstract class BluetoothSignal implements Signal {
	public abstract double sendLocation(double location);
}
class ZigbeeSignal implements Signal{
	public double sendLocation(double location){
		return location;
	}
}
class BluetoothToZigbeeConnector extends BluetoothSignal {
	private ZigbeeSignal _zigbeeSignal;
	public BluetoothToZigbeeConnector(ZigbeeSignal zigbeeSignal){
		this._zigbeeSignal=zigbeeSignal;
	}
	public double sendLocation(double location){
		return _zigbeeSignal.sendLocation(location);
	}

}