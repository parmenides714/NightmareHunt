package org.jfas.nh.player;

public class Armor {
	private String name;
	private int[] armorTrack;
	private int critical;
	
	public Armor(String name, int[] armorTrack, int critical) {
		this.name = name;
		this.critical = critical;
		this.armorTrack = new int[armorTrack.length];
		
		for(int index = 0; index < armorTrack.length; index++) {
			this.armorTrack[index] = armorTrack[index];
		}
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isCritical(int power) {
		return power >= critical;
	}
	
	public int getWoundCount(int power) {
		int count = 0;
		
		for(int defense : armorTrack) {
			if(power >= defense) {
				count++;
			}
		}
		
		return count;
	}
}
