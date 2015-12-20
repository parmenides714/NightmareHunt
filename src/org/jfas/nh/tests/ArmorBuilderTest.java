package org.jfas.nh.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import org.jfas.nh.builders.ArmorBuilder;
import org.jfas.nh.player.Armor;
import org.junit.Test;

public class ArmorBuilderTest {

	private static final String ROBES = "Robes";
	private static final String LEATHER = "Leather";
	private static final String PLATE = "Plate";

	@Test
	public void validateArmorCreation() {
		List<Armor> armorList = null;

		try {
			armorList = ArmorBuilder.buildAllArmor();
		} catch (Exception e) {
			e.printStackTrace();
			fail("An exception occured while building the armor");
		}

		assertEquals(armorList.size(), 3);

		Armor robes = armorList.get(0);
		assertEquals(robes.getName(), ROBES);

		Armor leather = armorList.get(1);
		assertEquals(leather.getName(), LEATHER);

		Armor plate = armorList.get(2);
		assertEquals(plate.getName(), PLATE);
	}
}
