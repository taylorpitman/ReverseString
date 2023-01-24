/**********************************************************
 * Program Name   : ReverseString
 * Author         : Taylor Pitman
 * Date           : 12/2/2022
 * Course/Section : CSC 112-301
 * Program Description: takes in a string and reverses each letter
 *	and word using two recursion methods.
 *
 * Methods:
 * -------
 * ReverseString 	- constructor, initializes string
 * buildStack		- builds a stack which each word of sentence
 * reverseLetters 	- switches the orientation of letters in a word
 * reverseWords 	- switches orientation of the words
 **********************************************************/

 import java.util.Stack;

 public class ReverseString
 {
	//class constants

	//class variables
	private String input;		//input from the user
	private char character;		//current character in word/sentence
	private String word;		//current word of the sentence
	private String reverse;     //final reversed sentence
	private String reverseWord; //word that is currently being reversed
	private Stack stack;		// stack holding each word
	private int length;			//length of word or sentence

   /**********************************************************
    * Method Name    : ReverseString
    * Author         : Taylor Pitman
 	* Date           : 12/2/2022
 	* Course/Section : CSC 112-301
    * Method Description: this method initializes the input from user,
    *	and various variable counts and strings used throughout the
    *	program. it also calls the build stack method
    *
    *BEGIN ReverseString
    *	initialize input
    *	initialize length
    *	initialize string variables
    *	initialize stack
    *	call build stack method
    *END ReverseString
    **********************************************************/

    public ReverseString(String string)
    {
		//local constants

		//local variables

		/********************   Start ReverseString method  *****************/

		//initialize input
		input = string;

		//initialize length
		length = 0;

		//initialize string variables
		character = 0;
		word = "";
		reverse = "";
		reverseWord = "";

		//initialize stack
		stack = new Stack();

		//call build stack method
		buildStack();

	}//END ReverseString

   /**********************************************************
    * Method Name    : buildStack
    * Author         : Taylor Pitman
 	* Date           : 12/2/2022
 	* Course/Section : CSC 112-301
    * Method Description: this method figures out how many words
    *	are in the string and puts each word into a stack
    *
    *BEGIN buildArray
	*	IF(length of string is more than one)
	*			FOR(the length of the string)
	*				get character
	*				IF(character is a space)
	*					add space to word
	*					add word to stack
	*					initialize word back to null
	*				ELSE
	*					add character to word
	*				END IF
	*			END FOR
	*		ELSE
	*			get only character
	*			convert character to string
	*			push word onto the stack
	*		END IF
    *END buildArray
    **********************************************************/
  	public void buildStack()
  	{
		//local constants
		char SPACE = ' ';

		//local variables

		/******************** Start buildStack method  *****************/

		//IF(length of string is more than one)
		if(input.length() > 1)
		{
			//FOR(the length of the string)
			for (int i = 0; i < input.length(); i++)
			{

				//get character
				character = input.charAt(i);

				//IF(character is a space)
				if(character == SPACE || i == (input.length() - 1))
				{
					//add space to word
					word += character;

					//add word to stack
					stack.push(word);

					//initialize word back to null
					word = "";
				}
				//ELSE
				else

					//add character to word
					word += character;

				//END IF

			}//END FOR
		}
		//ELSE
		else
		{
			//get only character
			character = input.charAt(0);

			//convert character to string
			word += character;

			//push word onto the stack
			stack.push(word);

		}//END IF

	}//END buildStack

   /**********************************************************
    * Method Name    : reverseLetters
    * Author         : Taylor Pitman
 	* Date           : 12/2/2022
 	* Course/Section : CSC 112-301
    * Method Description: this method takes a word
    *   and reverses the letters until a base case
    *	is reached
    *
    * Recusive Definition:
    * base case: IF(index variable is at -1)
    *				return word
    * recursive case: return ReverseLetters(length - 1)
    *
    *BEGIN reverseLetters
	*	IF(length is 0 or higher)
	*		get character at index length
	*		add character to word
	*		return method
	*	ELSE
	*		return word
	*	END IF
    *END reverseLetters
    **********************************************************/

    public String reverseLetters(int length)
    {
    	//local constants

    	//local variables

		/**************** Start reverseLetters method ****************/

		//IF(length is 0 or higher)
		if(length >= 0)
		{
			//get character at index length
			character = word.charAt(length);

			//add character to word
			reverseWord += character;

			//return method
			return reverseLetters(length - 1);
		}
		//ELSE
		else

			//return word
			return reverseWord;

		//END IF

	}//END reverseLetters

   /**********************************************************
    * Method Name    : reverseWords
    * Author         : Taylor Pitman
 	* Date           : 12/2/2022
 	* Course/Section : CSC 112-301
    * Method Description: this method takes in a stack
    *	of strings and reverses the words until a base
    *	case is reached
    *
    * Recusive Definition:
    * base case: IF(stack is empty)
    *				return string
    * recursive case: return ReverseWords()
    *
    *BEGIN reverseLetters
    *	IF(count is the size of the stack)
    *		return string
    *	ELSE
    *		pop off word
    *		get length of word
    *		call reverse letters method
    *		add reversed word to string
    *		set reversed word to null string
	*		set word to null string
    *		return itself
	*	END IF
    *END reverseLetters
    **********************************************************/
	
	public String reverseWords()
	{
    	//local constants

    	//local variables

		/**************** Start reverseWords method ****************/

    	//IF(count is the size of the stack)
    	if(stack.isEmpty())

    		//return string
    		return reverse;

    	//ELSE
    	else
    	{
    		//pop off word
    		word = "" + stack.pop();

    		//get length of word
    		length = word.length() - 1;

    		//call reverse letters method
    		reverseLetters(length);

    		//add reversed word to string
    		reverse += reverseWord;

    		//set reversed word to null string
    		reverseWord = "";

			//set word to null string
    		word = "";

    		//return itself
    		return reverseWords();

		}//END IF

	}//END reverseWords

 }//END ReverseString
