package com.example.advanced.abstractEx;

abstract class Player{ //추상클래스(미완성클래스)
	abstract void play(int pos);
	abstract void stop();
	//추상메서드(선언부만 있고, 구현부{}가없는 메서드)
}

//추상클래스는 상속을 통해 완성해야 객체 생성가능
class AudioPlayer extends Player{

	@Override
	void play(int pos) {
		System.out.println(pos+"위치부터 play합니다");
	}

	@Override
	void stop() {
		System.out.println("재생을 멈춥니다");
	}
}

public class PlayerTest {
	
	public static void main(String[] args) {
		//AudioPlayer ap = new AudioPlayer();
		//다형성으로 Player도 가능 audioPlayer는 player를 상속받았기 때문에 가능
		Player ap = new AudioPlayer();
		ap.play(100);
		ap.stop();
	}

}
