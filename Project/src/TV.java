
public class TV {
	int channel = 1;
	int volume = 1;
	boolean on = false;
	
	public TV() {}
	
	public TV(int channel, int volume, boolean on) {
		super();
		this.channel = channel;
		this.volume = volume;
		this.on = on;
	}
	public void turnOn() {
		on = true;
	}
	public void turnOff() {
		on = false;
	}
	public void setChannel(int channel) {
		if (on && channel >= 1 && channel <= 120) {
			this.channel = channel;
		}
	}
	public void setVolume(int volume) {
		if (on && volume >= 0 && volume <= 7) {
			this.volume = volume;
		}
	}
	public void channelDown() {
		this.channel = channel - 1;
	}
	public void channelUp() {
		this.channel = channel + 1;
	}
	public void volumeUp() {
		this.volume = volume + 1;
	}
	public void volumeDown() {
		this.volume = volume - 1;
	}
}