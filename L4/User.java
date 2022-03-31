import java.util.prefs.*;

public class User {

	// Preference key
	private static final String FRUIT = "";

	public void savePreference(String favoriteFruit) {
		Preferences prefs = Preferences.userNodeForPackage(User.class);

		prefs.put(FRUIT, favoriteFruit);
	}

	public String readPreference() {
		Preferences prefs = Preferences.userNodeForPackage(User.class);

		return prefs.get(FRUIT, "");
	}
}
