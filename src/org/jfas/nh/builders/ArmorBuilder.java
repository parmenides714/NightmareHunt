package org.jfas.nh.builders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.jfas.nh.player.Armor;
import org.json.JSONArray;
import org.json.JSONObject;

public class ArmorBuilder {
	private static final String DATA_FILE = "resources/armor.json";
	private static final String ARMOR_TRACK = "armorTrack";
	private static final String CRITICAL = "critical";

	public static List<Armor> buildAllArmor() throws Exception {
		List<Armor> armorList = new ArrayList<Armor>();

		try {
			String source = IOUtils.toString(new FileInputStream(DATA_FILE));
			JSONObject json = new JSONObject(source);

			for (String armorName : json.keySet()) {
				JSONObject armorJSON = json.getJSONObject(armorName);
				armorList.add(buildArmor(armorName, armorJSON));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return armorList;
	}

	private static Armor buildArmor(String armorName, JSONObject json) {
		int critical = json.getInt(CRITICAL);
		JSONArray armorTrackJSON = json.getJSONArray(ARMOR_TRACK);
		int trackLength = armorTrackJSON.length();

		int[] armorTrack = new int[trackLength];
		for (int index = 0; index < trackLength; index++) {
			armorTrack[index] = armorTrackJSON.getInt(index);
		}

		return new Armor(armorName, armorTrack, critical);
	}
}
