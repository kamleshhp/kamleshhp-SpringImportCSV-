package com.javaguides.csv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GOT")
public class GOTENITY {
	
	@Id
	@Column
	
	private String name;
	@Column
	private String year;
	
	@Column
	
    private long battle_number;
	@Column
	private String attacker_king;
	@Column
	private String defender_king;
	@Column
	private String attacker_outcome;
	@Column
	private String battle_type;
	@Column
	private long major_death;
	@Column
	private long major_capture;
	@Column
	private long attacker_size;
	@Column
	private long defender_size;
	@Column
	private String attacker_commander;
	@Column
	private String defender_commander;
	@Column
	private long summer;
	@Column
	private String location;
	@Column
	private String region;
	@Column
	private String note;

	public GOTENITY(String name, String year, long battle_number, String attacker_king, String defender_king,
			String attacker_outcome, String battle_type, long major_death, long major_capture, long attacker_size,
			long defender_size, String attacker_commander, String defender_commander, long summer, String location,
			String region, String note) {
		this.name = name;
		this.year = year;
		this.battle_number = battle_number;
		this.attacker_king = attacker_king;
		this.defender_king = defender_king;
		this.attacker_outcome = attacker_outcome;
		this.battle_type = battle_type;
		this.major_death = major_death;
		this.major_capture = major_capture;
		this.attacker_size = attacker_size;
		this.defender_size = defender_size;
		this.attacker_commander = attacker_commander;
		this.defender_commander = defender_commander;
		this.summer = summer;
		this.location = location;
		this.region = region;
		this.note = note;
	}

	public GOTENITY() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public long getBattle_number() {
		return battle_number;
	}

	public void setBattle_number(long battle_number) {
		this.battle_number = battle_number;
	}

	public String getAttacker_king() {
		return attacker_king;
	}

	public void setAttacker_king(String attacker_king) {
		this.attacker_king = attacker_king;
	}

	public String getDefender_king() {
		return defender_king;
	}

	public void setDefender_king(String defender_king) {
		this.defender_king = defender_king;
	}

	public String getAttacker_outcome() {
		return attacker_outcome;
	}

	public void setAttacker_outcome(String attacker_outcome) {
		this.attacker_outcome = attacker_outcome;
	}

	public String getBattle_type() {
		return battle_type;
	}

	public void setBattle_type(String battle_type) {
		this.battle_type = battle_type;
	}

	public long getMajor_death() {
		return major_death;
	}

	public void setMajor_death(long major_death) {
		this.major_death = major_death;
	}

	public long getMajor_capture() {
		return major_capture;
	}

	public void setMajor_capture(long major_capture) {
		this.major_capture = major_capture;
	}

	public long getAttacker_size() {
		return attacker_size;
	}

	public void setAttacker_size(long attacker_size) {
		this.attacker_size = attacker_size;
	}

	public long getDefender_size() {
		return defender_size;
	}

	public void setDefender_size(long defender_size) {
		this.defender_size = defender_size;
	}

	public String getAttacker_commander() {
		return attacker_commander;
	}

	public void setAttacker_commander(String attacker_commander) {
		this.attacker_commander = attacker_commander;
	}

	public String getDefender_commander() {
		return defender_commander;
	}

	public void setDefender_commander(String defender_commander) {
		this.defender_commander = defender_commander;
	}

	public long getSummer() {
		return summer;
	}

	public void setSummer(long summer) {
		this.summer = summer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "GOTENITY [name=" + name + ", year=" + year + ", battle_number=" + battle_number + ", attacker_king="
				+ attacker_king + ", defender_king=" + defender_king + ", attacker_outcome=" + attacker_outcome
				+ ", battle_type=" + battle_type + ", major_death=" + major_death + ", major_capture=" + major_capture
				+ ", attacker_size=" + attacker_size + ", defender_size=" + defender_size + ", attacker_commander="
				+ attacker_commander + ", defender_commander=" + defender_commander + ", summer=" + summer
				+ ", location=" + location + ", region=" + region + ", note=" + note + "]";
	}
	
	
	
	
	
	

}