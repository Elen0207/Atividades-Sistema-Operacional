package exerciocio02.controller;

public class ThreadId extends Thread {
    private int id;

	public ThreadId (int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Thread Id: "+id);
	}
}