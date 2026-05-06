package dp;

import java.util.ArrayList;
import java.util.List;

interface Observer {
	public void update(String videoTitle);
}

interface Subject {

	public void subscribe(Observer observer);

	public void unsubscribe(Observer observer);

	public void notifyObservers(String videoTitle);
}

class YouTubeChannel implements Subject {
	private List<Observer> subscribers = new ArrayList<Observer>();
	private String channelName;

	public YouTubeChannel(String channelName) {

		this.channelName = channelName;
	}

	@Override
	public void subscribe(Observer observer) {
		subscribers.add(observer);
		System.out.println(observer + " subscribed to " + channelName);
	}

	@Override
	public void unsubscribe(Observer observer) {
		subscribers.remove(observer);
		System.out.println(observer + " unsubscribed to " + channelName);
	}

	@Override
	public void notifyObservers(String videoTitle) {
		for (Observer subscriber : subscribers) {
			subscriber.update(videoTitle);
		}
	}

	public void uploadVideo(String videoTitle) {
		System.out.println(" New Video Uploaded " + videoTitle);
		notifyObservers(videoTitle);
	}

	@Override
	public String toString() {
		return "YouTubeChannel [subscribers=" + subscribers + ", channelName=" + channelName + "]";
	}

}

class Subscriber implements Observer {
	private String name;

	public Subscriber(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update(String videoTitle) {
		System.out.println(name + " received a notification for video " + videoTitle);

	}

	@Override
	public String toString() {
		return "Subscriber [name=" + name + "]";
	}

}

public class ObserverDp {

	public static void main(String[] args) {
		YouTubeChannel techChannel = new YouTubeChannel("0726 Channel");

		Observer sub1 = new Subscriber("Naveen");
		Observer sub2 = new Subscriber("Sri");
		Observer sub3 = new Subscriber("Ram");

		techChannel.subscribe(sub1);
		techChannel.subscribe(sub2);
		techChannel.subscribe(sub3);

		techChannel.uploadVideo("Design Pattern...");
		
		
		
		techChannel.unsubscribe(sub3);
		
		
		techChannel.uploadVideo("Observer pattern Explained...");

	}

}