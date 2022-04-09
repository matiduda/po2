import java.io.PrintStream;

public abstract class Wpis {
	abstract void opis(PrintStream out);
	abstract int compare(Wpis w);
	abstract Adres getAddress();
}
