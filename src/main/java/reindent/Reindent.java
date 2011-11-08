/**
 * 
 */
package reindent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Taylor Countryman <countryman.taylor@gmail.com>
 */
public class Reindent
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Argument checking
		if(args.length != 2)
		{
			System.err.println("Usage: java reindent.Reindent INFILE OUTFILE");
			System.exit(1);
		}

		// Input file checking
		File inFile = new File(args[0]);
		if(!inFile.isFile() || !inFile.canRead() || inFile.length() <= 0)
		{
			System.err.println("reindent: " + inFile.getName() + ": Must be a readable file with content");
			System.exit(1);
		}
		
		File outFile = new File(args[1]);
		try
		{
			outFile.createNewFile();
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
		if(!outFile.canWrite())
		{
			System.err.println("reindent: " + outFile.getName() + ": Cannot write to file");
			System.exit(1);
		}

		// Setup scanner
		Scanner inScanner = null;
		try
		{
			inScanner = new Scanner(inFile);
			
			// Read file line by line
			String line;
			while(inScanner.hasNextLine())
			{
				line = inScanner.nextLine();
				int numSpaces = 0;
				while(numSpaces < line.length() && line.charAt(numSpaces) == ' ')
					++numSpaces;
				String formattedLine = "";
				int numTabs = numSpaces / 2;
				for(int i = 0; i < numTabs; ++i)
					formattedLine += '\t';
				formattedLine += line.substring(numSpaces);
				System.out.println(formattedLine);
			}
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException(e);			
		}
		finally
		{
			if(inScanner != null)
				inScanner.close();
		}
		
	}
}
