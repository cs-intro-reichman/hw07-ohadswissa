

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		/*readDictionary tester
		for (int i = 0; i < 3000; i++)
		{
			System.out.println(dictionary[i]);
		}*/
		/*existInDictionary tester
		System.out.println(existInDictionary("account", dictionary));*/
		breakHashTag(hashTag, dictionary);
	}
/**takes all 3000 wotds and stores them in an array*/
	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
        In in = new In(fileName);
        for (int i = 0; i < 3000; i++)
        {
        	dictionary[i] = in.readString();
        }
		return dictionary;
	}
/**gets a string and an array and gives back true/false if the string is part of the dictionary*/ 
	public static boolean existInDictionary(String word, String []dictionary) {
		boolean inside = false;
		for (int i = 0; i < dictionary.length ;i++)
		{
			if (word.equals(dictionary[i])) 
			{
				inside = true;
			}
		}
		return inside;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
        hashtag = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) 
        {
        	String partial = hashtag.substring(0,i);
        	if (existInDictionary(partial,dictionary))
        	{
        		System.out.println(partial);
        		breakHashTag(hashtag.substring(i),dictionary);
        		return;
        	}
        }
       
    }

}
