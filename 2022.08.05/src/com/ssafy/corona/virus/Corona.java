package com.ssafy.corona.virus;

import java.util.Objects;

public class Corona extends Virus{
	public int spreadSpeed;

	public Corona(String name, int level, int spreadSpeed) {
		setName(name);
		setLevel(level);
		setSpreadSpeed(spreadSpeed);
	}
	
	public int getSpreadSpeed() {
		return spreadSpeed;
	}
	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}	
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()).append("\t")
		  .append(getSpreadSpeed());
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Corona) {
			Corona tmp = (Corona) o;
			if(this.getLevel() == tmp.getLevel() && this.getName().equals(tmp.getName()) && this.getSpreadSpeed() == tmp.getSpreadSpeed()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getName(), this.getLevel(), this.getSpreadSpeed());
	}
}