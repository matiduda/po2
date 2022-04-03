import java.util.prefs.*;

public class User {

	// Preference key
	private static final String LISTPATH = "";
	Preferences prefs;

	User() {
		this.prefs = Preferences.userNodeForPackage(User.class);
	}

	public void savePreference(String listPath) {

		prefs.put(LISTPATH, listPath);
	}

	public String readPreference() {
		Preferences prefs = Preferences.userNodeForPackage(User.class);

		return prefs.get(LISTPATH, "");
	}

	public void removeAll() {
		
		Preferences prefs = Preferences.userNodeForPackage(User.class);

		prefs.remove(LISTPATH);
	}
}
