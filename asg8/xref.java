//xref.java
//Main application
import java.io.*;
import java.util.Scanner;
import static java.lang.System.*;

class xref {

    static void processFile(String filename, boolean debug) throws IOException {
		Scanner scan = new Scanner (new File(filename));
        Tree tree = new Tree();
        for (int linenr = 1; scan.hasNextLine (); ++linenr) {
            for (String word: scan.nextLine().split ("\\W+")) {
               // out.printf ("%s: %d: %s%n", filename, linenr, word);
                tree.insert(word, linenr);
            }
        }
        scan.close();
        if (debug) {
            tree.debug();
        } else {
            tree.output();
        }
    }

    public static void main(String[] args) {
		String filename="";
		boolean debug=false;
		if (args.length==0) {
			auxlib.warn("Usage: java xref -d filename");
			auxlib.exit();
		}
		else if (args.length==2) { //Checks for arguments- two means that debug is enabled and a filename were entered
			if (args[0].equals("-d"))filename = args[1]; // Sets filename to second argument
			debug = true;
		}
		else if (!args[0].equals("-d")) { //If there's only 1 argument and it is not an option, arg is filename
			debug = false;
			filename=args[0];
		}
		else {
			auxlib.warn("You fucked up somewhere. Go fix your command.");
		}
        try {
            processFile(filename, debug);
        }catch (IOException error) {
            auxlib.warn (error.getMessage());
        }
        auxlib.exit();
    }

}

