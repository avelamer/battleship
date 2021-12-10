// AUTHORS

// ALEX VELA MERRIEN

// SAMUEL PEREZ SANDONATO

import java.util.Scanner;

public class BattleshipAlexSamuel {
	
	// VARIABLE THAT SETS THE BOARD LENGHT
	static int mapLength;
	// SYMBOL CHANGER
	static String water,hit,sunk;
	static boolean symbolsselected;
	// TWO PLAYER MODE
	static boolean twoPlayerMode;
	static int player = 1;
	
	// LETTERS PRINTED ON TOP OF THE BOARD
	static String[] topLetters = new String [] {"A","B","C","D","E","F","G","H","I","J"};
	
	// ARRAYS
	
	// BASIC - PLAYER 1
	static int[][] infoShips = new int [10][10];
	static int[][] shootedQuadrants = new int [10][10];
	static String[][] infoMapa = new String [10] [10];
	// PLAYER 2
	static int[][] infoShipsP2 = new int [10][10];
	static int[][] shootedQuadrantsP2 = new int [10][10];
	static String[][] infoMapaP2 = new String [10] [10];

	// SCANNER
	static Scanner input = new Scanner(System.in);
	
	// RANDOM COORDINATES FOR SHIPS
	
	// BASIC - PLAYER 1
	static int shipH3X , shipH3Y; // VARIABLES FOR SHIP LENGTH 3 HORIZONTAL   1
	static int shipV3X , shipV3Y; // VARIABLES FOR SHIP LENGTH 3 VERTICAL     2
	static int shipH2X , shipH2Y; // VARIABLES FOR SHIP LENGTH 2 HORIZONTAL   3
	static int shipV2X , shipV2Y; // VARIABLES FOR SHIP LENGTH 2 VERTICAL     4
	// PLAYER 2
	static int shipH3XP2 , shipH3YP2; // VARIABLES FOR SHIP LENGTH 3 HORIZONTAL   1
	static int shipV3XP2 , shipV3YP2; // VARIABLES FOR SHIP LENGTH 3 VERTICAL     2
	static int shipH2XP2 , shipH2YP2; // VARIABLES FOR SHIP LENGTH 2 HORIZONTAL   3
	static int shipV2XP2 , shipV2YP2; // VARIABLES FOR SHIP LENGTH 2 VERTICAL     4

	// REMAINING PARTS FOR THE SHIPS
	
	// BASIC - PLAYER 1
	static int remainingQuadrants1 = 3;
	static int remainingQuadrants2 = 3;
	static int remainingQuadrants3 = 2;
	static int remainingQuadrants4 = 2;
	// PLAYER 2
	static int remainingQuadrants1P2 = 3;
	static int remainingQuadrants2P2 = 3;
	static int remainingQuadrants3P2 = 2;
	static int remainingQuadrants4P2 = 2;
	
	// INFO VARIABLES
	
	// BASIC - PLAYER 1
	static int sunkShips = 0;
	static int shootsFired = 0;
	// PLAYER 2
	static int sunkShipsP2 = 0;
	static int shootsFiredP2 = 0;
	
	static int playedGames = 1;
	
		public static void main (String [] Args) {
			
			start();

			initialize();
			
			shipGeneration();
			
			updateMap();
			
			newCoordinates();
			
		}
		public static void initialize () {
			
			//RESET OF THE ARRAYS FOR 1ST PLAYER
			for (int i = 0; i< shootedQuadrants.length; i++) {
				
				for (int j = 0; j< shootedQuadrants.length; j++) {
					
					shootedQuadrants[i][j] = 0;
					infoShips[i][j] = 0;
					infoMapa[i][j] = " ";
				}
			}
			//RESET OF THE ARRAYS FOR 2ND PLAYER
			if (twoPlayerMode) {
				
				for (int i = 0; i< shootedQuadrantsP2.length; i++) {
					
					for (int j = 0; j< shootedQuadrantsP2.length; j++) {
						
						shootedQuadrantsP2[i][j] = 0;
						infoShipsP2[i][j] = 0;
						infoMapaP2[i][j] = " ";
					}
				}
			}	
		}
		public static void start () {
			  
			
			System.out.print("    _______       _________    ___________   ___________                  __________    __________                 ___________      _________ \n"
					+ "   |       |     |         |        |             |        |             |             |             |         |        |          |         |\n"
					+ "   |       |     |         |        |             |        |             |             |             |         |        |          |         |\n"
					+ "   |       |     |         |        |             |        |             |             |             |         |        |          |         |\n"
					+ "   |_______|_    |_________|        |             |        |             |_________    |_________    |_________|        |          |_________|\n"
					+ "   |         |   |         |        |             |        |             |                       |   |         |        |          |          \n"
					+ "   |         |   |         |        |             |        |             |                       |   |         |        |          |          \n"
					+ "   |         |   |         |        |             |        |             |                       |   |         |        |          |          \n"
					+ "   |_________|   |         |        |             |        |__________   |__________   __________|   |         |   _____|_____     |          \n"
					+ "                                                                                                                                       \n"
					+ "                                                                                                                                       \n"
					+ "                                                                                                                                       \n"
					+ "                                                                                                                                       \n"
					+ "                                                                   $o                                                                  \n"
					+ "                                                                   $                                                                   \n"
					+ "                                                                  $$$      .oo..                                                       \n"
					+ "                          __                                       $       $$$$$$$                                                     \n"
                  + "                          \\ \\_____                             .ooooooo.   $$!!!!!                                                     \n"
					+ "                       ###[  _____>                          .'.........'. $$!!!!!      o$$oo.                                         \n"
					+ "                          /_/                   $          .o'  oooooo   '.$$!!!!!      $$!!!!!                                        \n"
					+ "                                             ..o$ooo...    $                '!!''!.     $$!!!!!                                        \n"
					+ "                                             $    ..  '''oo$$$$$$$$$$$$$.    '    'oo.  $$!!!!!                                        \n"
					+ "                                             !.......      '''..$$ $$ $$$   ..        '.$$!!''!                                        \n"
					+ "                                             !!$$$!!!!!!!!oooo......   '''  $$ $$ :o           'oo.                                    \n"
					+ "            __                              !!$$$!!!$$!$$!!!!!!!!!!oo.....     ' ''  o$$o .      ''oo..                                \n"
                  + "            \\ \\_____                        !!!$$!!!!!!!!!!!!!!!!!!!!!!!!!!!!ooooo..      'o  oo..    $                                \n"
					+ "         ###[  _____>                        '!!$$!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!oooooo..  ''   ,$                                \n"
					+ "            /_/                               '!!$!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!oooo..$$                                \n"
					+ "                                              !!$!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!$'                                 \n"	
					+ "                                               '$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$!!!!!!!!!!!!!!!!!!,                                \n"
					+ "                                           .....$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$.....                           \n"
					+ "                    ,.-~*´¨¯¨`*•~-.¸,.-~*´¨¯¨*•~-.¸,.-~*´¨¯¨`*•~-.¸,.-*´¨¯¨`*•~-.¸,.-~*´¨¯¨`*•~.¸,.-~*´¨¯¨`*•~-.¸,.-~*´¨¨`*•~-.¸       \n"
				    );	
			System.out.println();
			// LOCAL VARIABLES FOR THE LOOPING AND CONDITIONAL MANAGEMENT
			String response = "";
			int userInput = 0;
			String symbolsresponse = "";
			// WE CREATE A LOOP WHICH ALLOWS THE USER TO PLAY THE NORMAL OR THE ADVANCED MODE; IN THE FIRST CASE THE MAP LENGTH IS SET TO 5 AUTOMATICALLY 
			// IN THE SECOND CASE THE USER CAN SELECT THE DIMENSIONS OF THE MAP (5 UP TO 10). MOREOVER, THE USER CAN ALSO SELECT THE NUMBER OF PLAYERS (1 OR 2)
			// AND CHOOSE BETWEEN THE ORIGINAL SYMBOLOGY FOR WATER, HIT AND SUNK, OR A COSTUMIZED ONE, SELECTED BY HIMSELF.
		
			// LOOP TO CHECK THAT THE USER SELECTS A CORRECT OPTION (A OR B)	
			while (!response.equalsIgnoreCase("a") && !response.equalsIgnoreCase("b")) {
		
				System.out.print("\n"
						+ "\n \n \n \tPlease select a gamemode: \n  \ta) Basic mode\n  \tb) Advanced mode \n\t");	  
				response = input.next();
	
				if(response.equalsIgnoreCase("a")) {
				
					mapLength = 5;
				}
				// ADVANCED MODE SELECTED; THEN WE CREATE THE LOOPS AND CONDITIONALS SO HE CAN CHOOSE DIMENSIONS, NUMBER OF PLAERS AND SYMBOLOGY
				else if (response.equalsIgnoreCase("b"))  {
					//DIMENSION SELECTION WITH LOOP TO CHECK THAT THE USER ENTERS A VALID DIMENSION
					while (!(userInput >= 5 && userInput <= 10)) {
				
						System.out.print("\n"
								+ "\tIntroduce the size for the map (n x n) from 5 to 10: ");	  
						userInput = input.nextInt();
				
						if (userInput >= 5 && userInput <= 10) {
					
							mapLength = userInput;
						}
						else {
					
							System.out.print("\n\tInput not valid");
						}
					}
					// NUMBER OF PLAYERS SELECTION WITH LOOP TO CHECK THAT THE USER INTRODUCES A VALID NUMBER OF PLAYERS
					while (!(userInput == 1) && !(userInput == 2)) {
				
						System.out.print("\n"
								+ "\tIntroduce the number of players (1 or 2):  ");	  
						userInput = input.nextInt();
				
						if (userInput == 1) {
					
							twoPlayerMode = false;
						}
						else if (userInput == 2) {
					
							twoPlayerMode = true;
					
						}
						else {
					
							System.out.println("\n\tInput not valid");
		
						}
					}
					// SYMBOLOGY SELECTION WITH LOOP TO CHECK THAT THE USER INTRODUCES A VALID SYMBOLOGY
					while (!symbolsresponse.equalsIgnoreCase("original") && !symbolsresponse.equalsIgnoreCase("costumized")) {
						System.out.print("\n"
									+ "\tSelect the wanted symbols for water, hit, sunk (original or costumized): ");
						symbolsresponse = input.next();
				
						if (symbolsresponse.equalsIgnoreCase("original")) {
							symbolsselected = false;
						}
						else if (symbolsresponse.equalsIgnoreCase("costumized")) {
							symbolsselected = true;
							// WATER SYMBOL SELECTION
							System.out.print("\n"
									+ "\tSelect the symbol for water (use just one character): ");
							water = input.next();
							while(water.length() > 1) {
								System.out.print("\n\tThe symbol entered has a bigger size than allowed");
								System.out.print("\n"
									+ "\tSelect the symbol for water (use just one character): ");
							water = input.next();
							}
							// HIT SYMBOL SELECTION
							System.out.print("\n"
										+ "\tSelect the symbol for hit (use just one character): ");
							hit = input.next();
							while(hit.length() > 1) {
								System.out.print("\n\tThe symbol entered has a bigger size than allowed");
								System.out.print("\n"
											+ "\tSelect the symbol for hit (use just one character): ");
								hit = input.next();
							}
							// SUNK SYMBOL SELECTION
							System.out.print("\n"
										+ "\tSelect the symbol for sunk (use just one character): ");
							sunk = input.next();
							while(sunk.length() > 1) {
								System.out.print("\n\tThe symbol entered has a bigger size than allowed");
								System.out.print("\n"
										+ "\tSelect the symbol for sunk (use just one character): ");
								sunk = input.next();
							}
						}
						// NOT VALID
						else {
					
						System.out.println("\n\tInput not valid");
						}
					}
				}
				else {
			
				System.out.print("\n\tInput not valid");
				}	
			}
		}

		public static void shipGeneration () {
			
			// THIS SECTION IS IN CHARGE OF THE RANDOM GENERATION OF THE SHIPS
			// THERE ARE 2 SHIPS OF LENGTH 2 AND 3, VERTICAL AND HORIZONTAL
			
			boolean valid = false;
			
			// THE IDEA FOR THE RANDOM SHIP GENERATION IS THAT FOR EVERY SHIP WE GENERATE 2 RANDOM NUMBERS WHICH ARE LIMITED
			// SO THAT THE SHIP DOES NOT GENERATE OUT OF THE MAP LIMITS. THE SHIPS OF LENGTH 3 ARE LIMITED IN AN AREA OF 3 X 5,
			// AND THE SHIPS OF LENGTH 2 ARE LIMITED IN AN AREA OF 4 X 5. THE COORDINATES CREATED BY THIS RANDOM NUMBERS ARE CONSIDERED
			// THE CENTER OF THE SHIPS, WHICH ARE THE TOP COORDINATES FOR THE VERTICAL SHIP AND THE LEFT COORDINATES FOR THE HORIZONTAL
			// SHIPS. AFTER THAT THE REST OF THE SHIP IS GENERATED (TO THE RIGHT IF THE SHIP IS HORIZONTAL AND DOWN IF THE SHIP IS VERTICAL).
			// THE POSITION OF THE SHIPS ARE STORED IN THE ARRAY infoShips. IN THIS ARRAY THE WATER IS REPRESENTED WITH 0 AND THE SHIPS WITH
			// A DIFFERENT NUMBER, UNIQUE FOR EVERY SHIP.
			
			// SHIP LENGTH 3 HORIZONTAL  = 1
			// SHIP LENGTH 3 VERTICAL    = 2
			// SHIP LENGTH 2 HORIZONTAL  = 3
			// SHIP LENGTH 2 VERTICAL    = 4
			
			
			// SHIP LENGTH 3 HORIZONTAL
			
			// THE RANDOM COORDINATES ARE GENERATED
			shipH3X = (int) (Math.random() * (mapLength-2));
			shipH3Y = (int) (Math.random() * mapLength);
			
			// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
			infoShips[shipH3Y][shipH3X]     = 1;
			infoShips[shipH3Y][shipH3X + 1] = 1;
			infoShips[shipH3Y][shipH3X + 2] = 1;
			
			// SHIP LENGTH 3 VERTICAL
			
			// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
			// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
			while (!valid) {
				
				// THE RANDOM COORDINATES ARE GENERATED
				shipV3X = (int) (Math.random() * mapLength);
				shipV3Y = (int) (Math.random() * (mapLength-2));
				
				// WE CHECK IF ANY OF THE POSIBLE COORDINATES OF THIS SHIP COLIDES WITH ANY OTHER SHIP PREVIUSLY CREATED
				if (infoShips[shipV3Y][shipV3X] == 0 && infoShips[shipV3Y + 1][shipV3X] == 0 && infoShips[shipV3Y + 2][shipV3X] == 0) {
					
					// THE SHIP IS CREATED DOWNWARDS FROM THE CENTER OF THE SHIP
					infoShips[shipV3Y]    [shipV3X] = 2;
					infoShips[shipV3Y + 1][shipV3X] = 2;
					infoShips[shipV3Y + 2][shipV3X] = 2;
					
					// THE VARIABLE TO STOP THE LOOP IS CHANGED
					valid = true;
				}
			}
			// THE VARIABLE TO STOP THE LOOP IS CHANGED FOR THE NEXT SHIP
			valid = false;
			
			// SHIP LENGTH 2 HORIZONTAL
			
			// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
			// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
			while (!valid) {
				
				// THE RANDOM COORDINATES ARE GENERATED
				shipH2X = (int) (Math.random() * (mapLength-1));
				shipH2Y = (int) (Math.random() * mapLength);
				
				// WE CHECK IF ANY OF THE POSIBLE COORDINATES OF THIS SHIP COLIDES WITH ANY OTHER SHIP PREVIUSLY CREATED
				if (infoShips[shipH2Y][shipH2X] == 0 && infoShips[shipH2Y][shipH2X + 1] == 0){
					
					// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
					infoShips[shipH2Y][shipH2X]     = 3;
					infoShips[shipH2Y][shipH2X + 1] = 3;
					
					// THE VARIABLE TO STOP THE LOOP IS CHANGED
					valid = true;
				}
			}
			// THE VARIABLE TO STOP THE LOOP IS CHANGED FOR THE NEXT SHIP
			valid = false;
			
			// SHIP LENGTH 2 VERTICAL
			
			// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
			// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
			while (!valid) {
				
				// THE RANDOM COORDINATES ARE GENERATED
				shipV2X = (int) (Math.random() * mapLength);
				shipV2Y = (int) (Math.random() * (mapLength-1));
				
				// WE CHECK IF ANY OF THE POSIBLE COORDINATES OF THIS SHIP COLIDES WITH ANY OTHER SHIP PREVIUSLY CREATED
				if (infoShips[shipV2Y][shipV2X] == 0 && infoShips[shipV2Y+1][shipV2X] == 0){
					
					// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
					infoShips[shipV2Y]    [shipV2X] = 4;
					infoShips[shipV2Y + 1][shipV2X] = 4;
					
					// THE VARIABLE TO STOP THE LOOP IS CHANGED
					valid = true;
				}
			}
			// THE VARIABLE TO STOP THE LOOP IS CHANGED
			valid = false;
								
			
//...................................................................................................................................................
			
			// SECOND PLAYER
			
			
			if (twoPlayerMode) {
				
				// SHIP LENGTH 3 HORIZONTAL
				
				// THE RANDOM COORDINATES ARE GENERATED
				shipH3XP2 = (int) (Math.random() * (mapLength-2));
				shipH3YP2 = (int) (Math.random() * mapLength);
				
				// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
				infoShipsP2[shipH3YP2][shipH3XP2]     = 1;
				infoShipsP2[shipH3YP2][shipH3XP2 + 1] = 1;
				infoShipsP2[shipH3YP2][shipH3XP2 + 2] = 1;
				
				// SHIP LENGTH 3 VERTICAL
				
				// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
				// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
				while (!valid) {
					
					// THE RANDOM COORDINATES ARE GENERATED
					shipV3XP2 = (int) (Math.random() * mapLength);
					shipV3YP2 = (int) (Math.random() * (mapLength-2));
					
					// WE CHECK IF ANY OF THE POSIBLE COORDINATES OF THIS SHIP COLIDES WITH ANY OTHER SHIP PREVIUSLY CREATED
					if (infoShipsP2[shipV3YP2][shipV3XP2] == 0 && infoShipsP2[shipV3YP2 + 1][shipV3XP2] == 0 && infoShipsP2[shipV3YP2 + 2][shipV3XP2] == 0) {
						
						// THE SHIP IS CREATED DOWNWARDS FROM THE CENTER OF THE SHIP
						infoShipsP2[shipV3YP2]    [shipV3XP2] = 2;
						infoShipsP2[shipV3YP2 + 1][shipV3XP2] = 2;
						infoShipsP2[shipV3YP2 + 2][shipV3XP2] = 2;
						
						// THE VARIABLE TO STOP THE LOOP IS CHANGED
						valid = true;
					}
				}
				// THE VARIABLE TO STOP THE LOOP IS CHANGED FOR THE NEXT SHIP
				valid = false;
				
				// SHIP LENGTH 2 HORIZONTAL
				
				// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
				// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
				while (!valid) {
					
					// THE RANDOM COORDINATES ARE GENERATED
					shipH2XP2 = (int) (Math.random() * (mapLength-1));
					shipH2YP2 = (int) (Math.random() * mapLength);
					
					// WE CHECK IF ANY OF THE POSIBLE COORDINATES OF THIS SHIP COLIDES WITH ANY OTHER SHIP PREVIUSLY CREATED
					if (infoShipsP2[shipH2YP2][shipH2XP2] == 0 && infoShipsP2[shipH2YP2][shipH2XP2 + 1] == 0){
						
						// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
						infoShipsP2[shipH2YP2][shipH2XP2]     = 3;
						infoShipsP2[shipH2YP2][shipH2XP2 + 1] = 3;
						
						// THE VARIABLE TO STOP THE LOOP IS CHANGED
						valid = true;
					}
				}
				// THE VARIABLE TO STOP THE LOOP IS CHANGED FOR THE NEXT SHIP
				valid = false;
				
				// SHIP LENGTH 2 VERTICAL
				
				// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
				// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
				while (!valid) {
					
					// THE RANDOM COORDINATES ARE GENERATED
					shipV2XP2 = (int) (Math.random() * mapLength);
					shipV2YP2 = (int) (Math.random() * (mapLength-1));
					
					// WE CHECK IF ANY OF THE POSIBLE COORDINATES OF THIS SHIP COLIDES WITH ANY OTHER SHIP PREVIUSLY CREATED
					if (infoShipsP2[shipV2YP2][shipV2XP2] == 0 && infoShipsP2[shipV2YP2+1][shipV2XP2] == 0){
						
						// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
						infoShipsP2[shipV2YP2]    [shipV2XP2] = 4;
						infoShipsP2[shipV2YP2 + 1][shipV2XP2] = 4;
						
						// THE VARIABLE TO STOP THE LOOP IS CHANGED
						valid = true;
					}
				}
				// THE VARIABLE TO STOP THE LOOP IS CHANGED
				valid = false;
			}
		}
		public static void updateMap () {
			
			// ESTA PARTE SE ENCARGA DE ACTUALIZAR EL MAPA DE JUEGO
			// BASICAMENTE HARA LOS PRINT DEL ARRAY
			// AGUA: 0 TOCADO: # HUNDIDO: X
			String inf = "|_____";
			String sup = "|     ";
			String top = "______";
			
			
			if (twoPlayerMode) {
				
				System.out.println("\n\t"+"Player "+ player + "\n");
			}

						// 			BOARD EXAMPLE
						// 	_______________________________
						//	|     |     |     |     |     |
						//	|  #  |  A  |     |  X  |     |
						//	|_____|_____|_____|_____|_____|
						//	|     |     |     |     |     |
						//	|  #  |     |     |  A  |     |
						//	|_____|_____|_____|_____|_____|
						//	|     |     |     |     |     |
						//	|     |  X  |  #  |     |  #  |
						//	|_____|_____|_____|_____|_____|
						//	|     |     |     |     |     |
						//	|  #  |     |  A  |     |  #  |
						//	|_____|_____|_____|_____|_____|
						//	|     |     |     |     |     |
						//	|     |  X  |     |  X  |  #  |
						//	|_____|_____|_____|_____|_____|
			
			System.out.print("\t"+"   ");
			
			
			// TOP LETTERS
			for (int i = 0; i<mapLength; i++ ) {
				
				System.out.print(topLetters[i]+"     ");
			}
			System.out.print("\n\t");
			
			
			// TOP LINE
			for (int i = 0; i<mapLength; i++ ) {
				
				System.out.print(top);
			}
			System.out.print("_" + "\n\t");
			
			
			// REST OF THE MAP
			for (int i = 0; i<mapLength; i++) {
				
				
				// TOP PART
				for (int z = 0; z<mapLength; z++ ) {
					
					System.out.print(sup);
				}
				System.out.print("|" +"\n");
				
				
				// LEFT NUMBER
				System.out.print("      "+ i +" ");
				
			
				// ROW WITH INFO
				for (int j=0; j<mapLength; j++) {
						
					if (player == 1) {
						
						System.out.print("|  " + infoMapa[i][j] + "  ");
					}
					else {
						
						System.out.print("|  " + infoMapaP2[i][j] + "  ");
					}
				}
				System.out.print("|\n\t");
				
				// BOTTOM PART
				for (int z = 0; z<mapLength; z++ ) {
					
					System.out.print(inf);
				}
				System.out.print("|" +"\n\t");
				
			}
			// STADISTICS INFORMATION (SHOTS AND SHIPS SUNK)
			if (player == 1) {
				
				System.out.println("\n\tShots fired: " + shootsFired);
				System.out.println("\tShips sunk: " + sunkShips);
			}
			else {
				
				System.out.println("\n\tShots fired: " + shootsFiredP2);
				System.out.println("\tShips sunk: " + sunkShipsP2);
			}
		}
		public static void newCoordinates() {
			// THIS SECTION IS IN CHARGE OF THE SELECTION OF THE COORDINATES WHERE TO SHOOT AT
			
			// LOCAL VARIABLES FOR THE MANAGEMENT 
			int X = 0,Y;
			String coordinates;
			boolean validX = true;

			// WE ASK THE USER TO INTRODUCE THE COORDINATES HE WANTS TO SHOOT AT WITH THE FOLLOWING ORDER (LETTER,NUM) FOR (POSX,POSY)
			System.out.print("\n\t(REMINDER) SINTAX IS: POSX,POSY \n"
						    +"\tInsert the coordinates: \n\t");
							
			
			coordinates = input.next();
			
			// WE CREATE THE CONDITIONS THAT RELATE THE LETTER INTRODUCED (NO MATTER ITS CASE) WITH THE POSITION IN THE ARRAY
			if(coordinates.startsWith("A") || coordinates.startsWith("a")){
				X = 0;
			}
			else if(coordinates.startsWith("B") || coordinates.startsWith("b")){
				X = 1;
			}
			else if(coordinates.startsWith("C") || coordinates.startsWith("c")){
				X = 2;
			}
			else if(coordinates.startsWith("D") || coordinates.startsWith("d")){
				X = 3;
			}
			else if(coordinates.startsWith("E") || coordinates.startsWith("e")){
				X = 4;
			}
			else if(coordinates.startsWith("F") || coordinates.startsWith("f")){
				X = 5;
			}
			else if(coordinates.startsWith("G") || coordinates.startsWith("g")){
				X = 6;
			}
			else if(coordinates.startsWith("H") || coordinates.startsWith("h")){
				X = 7;
			}
			else if(coordinates.startsWith("I") || coordinates.startsWith("i")){
				X = 8;
			}
			else if(coordinates.startsWith("J") || coordinates.startsWith("j")){
				X = 9;
			}
			else {
				validX = false;
			}
			
			// THE Y IS THE NUMERIC VALUE AT POS 2 OF THE COORDINATES
			Y = Character.getNumericValue(coordinates.charAt(2));
			
			// WE CREATE A LOOP FOR INVALID INPUTS
			while(!validX || coordinates.charAt(1) != ',' || Y < 0 || Y > mapLength-1 ||X > mapLength-1 ||coordinates.length() > 3) {

					System.out.print("\n\tThe coordinates could not be found, please try again");
					System.out.print("\n\t(REMINDER) SINTAX IS: POSX,POSY \n"
									+"\tInsert the coordinates: \n\t");
					
					coordinates = input.next();
			
					validX = true;
					
				if(coordinates.startsWith("A") || coordinates.startsWith("a")){
					X = 0;
				}
				else if(coordinates.startsWith("B") || coordinates.startsWith("b")){
					X = 1;
				}
				else if(coordinates.startsWith("C") || coordinates.startsWith("c")){
					X = 2;
				}
				else if(coordinates.startsWith("D") || coordinates.startsWith("d")){
					X = 3;
				}
				else if(coordinates.startsWith("E") || coordinates.startsWith("e")){
					X = 4;
				}
				else if(coordinates.startsWith("F") || coordinates.startsWith("f")){
					X = 5;
				}
				else if(coordinates.startsWith("G") || coordinates.startsWith("g")){
					X = 6;
				}
				else if(coordinates.startsWith("H") || coordinates.startsWith("h")){
					X = 7;
				}
				else if(coordinates.startsWith("I") || coordinates.startsWith("i")){
					X = 8;
				}
				else if(coordinates.startsWith("J") || coordinates.startsWith("j")){
					X = 9;
				}
				else {
					validX = false;
				}
				Y = Character.getNumericValue(coordinates.charAt(2));
			}
			// WHEN THE COORDINATES ARE CORRECT AND ARE SEPARED IN DIFERENT VARIABLES WE CALL THE FUNCTION shootAt() WITH THE CORRDINATES AS PARAMETERS
			shootAt(X,Y);
		}
		public static void shootAt (int x, int y) {
			
			// THIS FUNCTION UPDATES THE ARRAYS AND THE VARIABLES AS shoots and sunkShips WITH RESPECT TO THE COORDINATES INTRODUCED AS PARAMETERS
			// IF IT IS PLAYER 1 OR PLAYER 2 TURN ONLY THE CORRESPONDING ARRAYS AND VARIABLES WILL BE UPDATED
			
			if (player == 1) {
				
				if (shootedQuadrants[x][y] == 0) {
					
					// THE CUADRANT IS SET AS SHOOTED AND THE VARIABLE shootsFired is increased by 1
					shootedQuadrants[x][y] = 1;
					shootsFired += 1;
					
					// DEPENDING ON WHAT IS ON THE SHOOTED QUADRANT:
					switch (infoShips[y][x]) {
				
						// WATER
						case 0: 
							
							if(symbolsselected == false) {
							infoMapa[y][x] = "0";
							System.out.println("\tWhat a shame, it's water :(\n");
							break;
							}
							else if(symbolsselected == true) {
							infoMapa[y][x] = water;
							System.out.println("\tWhat a shame, it's water :(\n");
							break;
							}
						
						// SHIP 1
						case 1:
					
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants1 -= 1;
					
							// HIT
							if (remainingQuadrants1 >0) {
								
								if(symbolsselected == false) {
								infoMapa[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapa[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
								
								if(symbolsselected == false) {
								infoMapa[shipH3Y][shipH3X] = "X";
								infoMapa[shipH3Y][shipH3X + 1] = "X";
								infoMapa[shipH3Y][shipH3X + 2] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
								else if(symbolsselected == true) {
								infoMapa[shipH3Y][shipH3X] = sunk;
								infoMapa[shipH3Y][shipH3X + 1] = sunk;
								infoMapa[shipH3Y][shipH3X + 2] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
						
							}
							break;
						
						// SHIP 2
						case 2:
						
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants2 -= 1;
					
							// HIT
							if (remainingQuadrants2 >0) {
								
								if(symbolsselected == false) {
								infoMapa[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapa[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
						
								if(symbolsselected == false) {
								infoMapa[shipV3Y][shipV3X] = "X";
								infoMapa[shipV3Y + 1][shipV3X] = "X";
								infoMapa[shipV3Y + 2][shipV3X] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
								else if(symbolsselected == true) {
								infoMapa[shipV3Y][shipV3X] = sunk;
								infoMapa[shipV3Y + 1][shipV3X] = sunk;
								infoMapa[shipV3Y + 2][shipV3X] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
							}
							break;
						
						// SHIP 3
						case 3:
						
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants3 -= 1;
					
							// HIT
							if (remainingQuadrants3 >0) {
						
								if(symbolsselected == false) {
								infoMapa[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapa[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
						
								if(symbolsselected == false) {
								infoMapa[shipH2Y][shipH2X] = "X";
								infoMapa[shipH2Y][shipH2X + 1] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
								else if(symbolsselected == true) {
								infoMapa[shipH2Y][shipH2X] = sunk;
								infoMapa[shipH2Y][shipH2X + 1] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
						
							}
							break;
						
						// SHIP 4
						case 4:
						
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants4 -= 1;
					
							// HIT
							if (remainingQuadrants4 >0) {
						
								if(symbolsselected == false) {
								infoMapa[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapa[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
								
								if(symbolsselected == false) {
								infoMapa[shipV2Y][shipV2X] = "X";
								infoMapa[shipV2Y + 1][shipV2X] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
								else if(symbolsselected == true) {
								infoMapa[shipV2Y][shipV2X] = sunk;
								infoMapa[shipV2Y + 1][shipV2X] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShips += 1;
								}
						
							}
							break;
						
						default: System.out.println("\tERROR");
					}
				}
				else {
					
					System.out.println("\tYou have already shooted at this cuadrant.");
					newCoordinates();
					
				}
				
			}
			
//.............................................................................................................................................................
			
			// Player 2
			
			
			else {
				
				
				if (shootedQuadrantsP2[x][y] == 0) {
					
					// THE CUADRANT IS SET AS SHOOTED AND THE VARIABLE shootsFired is increased by 1
					shootedQuadrantsP2[x][y] = 1;
					shootsFiredP2 += 1;
					
					// DEPENDING ON WHAT IS ON THE SHOOTED QUADRANT:
					switch (infoShipsP2[y][x]) {
				
						// WATER
						case 0: 
					 
							if(symbolsselected == false) {
							infoMapaP2[y][x] = "0";
							System.out.println("\tWhat a shame, it's water :(\n");
							break;
							}
							else if(symbolsselected == true) {
							infoMapaP2[y][x] = water;
							System.out.println("\tWhat a shame, it's water :(\n");
							break;
							}
							
						// SHIP 1
						case 1:
					
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants1P2 -= 1;
					
							// HIT
							if (remainingQuadrants1P2 >0) {
						
								if(symbolsselected == false) {
								infoMapaP2[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapaP2[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
						
								if(symbolsselected == false) {
								infoMapaP2[shipH3YP2][shipH3XP2] = "X";
								infoMapaP2[shipH3YP2][shipH3XP2 + 1] = "X";
								infoMapaP2[shipH3YP2][shipH3XP2 + 2] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
								else if(symbolsselected == true) {
								infoMapaP2[shipH3YP2][shipH3XP2] = sunk;
								infoMapaP2[shipH3YP2][shipH3XP2 + 1] = sunk;
								infoMapaP2[shipH3YP2][shipH3XP2 + 2] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
							}
							break;
							
						// SHIP 2
						case 2:
						
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants2P2 -= 1;
					
							// HIT
							if (remainingQuadrants2P2 >0) {
						
								if(symbolsselected == false) {
								infoMapaP2[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapaP2[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
						
								if(symbolsselected == false) {
								infoMapaP2[shipV3YP2][shipV3XP2] = "X";
								infoMapaP2[shipV3YP2 + 1][shipV3XP2] = "X";
								infoMapaP2[shipV3YP2 + 2][shipV3XP2] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
								else if(symbolsselected == true) {
								infoMapaP2[shipV3YP2][shipV3XP2] = sunk;
								infoMapaP2[shipV3YP2 + 1][shipV3XP2] = sunk;
								infoMapaP2[shipV3YP2 + 2][shipV3XP2] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
							}
							break;
							
						// SHIP 3
						case 3:
						
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants3P2 -= 1;
					
							// HIT
							if (remainingQuadrants3P2 >0) {
						
								if(symbolsselected == false) {
								infoMapaP2[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapaP2[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
						
								if(symbolsselected == false) {
								infoMapaP2[shipH2YP2][shipH2XP2] = "X";
								infoMapaP2[shipH2YP2][shipH2XP2 + 1] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
								else if(symbolsselected == true) {
								infoMapaP2[shipH2YP2][shipH2XP2] = sunk;
								infoMapaP2[shipH2YP2][shipH2XP2 + 1] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
						
							}
							break;
							
						// SHIP 4
						case 4:
							
							// ONE LESS QUADRANT OF THE SHIP TO BE SUNK
							remainingQuadrants4P2 -= 1;
					
							// HIT
							if (remainingQuadrants4P2 >0) {
						
								if(symbolsselected == false) {
								infoMapaP2[y][x] = "#";
								System.out.println("\tWow, you hit a ship :)\n");
								}
								else if(symbolsselected == true) {
								infoMapaP2[y][x] = hit;
								System.out.println("\tWow, you hit a ship :)\n");
								}
							}
							// SUNK
							else {
						
								if(symbolsselected == false) {
								infoMapaP2[shipV2YP2][shipV2XP2] = "X";
								infoMapaP2[shipV2YP2 + 1][shipV2XP2] = "X";
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
								else if(symbolsselected == true) {
								infoMapaP2[shipV2YP2][shipV2XP2] = sunk;
								infoMapaP2[shipV2YP2 + 1][shipV2XP2] = sunk;
								System.out.println("\tAmazing!!! You sunk a ship!\n");
								sunkShipsP2 += 1;
								}
							}
							break;
						
						default: System.out.println("\tERROR");
					}
				}
				// MESSAGE IF YOU HAVE ALREADY SHOOTED AT THE QUADRANT
				else {
					
					System.out.println("\tYou have already shooted at this cuadrant.");
					newCoordinates();
				}	
			}
		
			// WE CALL updateMap() TO DISPLAY THE MAP WITH THE NEW CHANGES
			updateMap();
			// IF WE ARE IN 2-PLAYER MODE, WE CHANGE THE TURN OF THE PLAYERS
			if (twoPlayerMode) {
				
				if (player == 1) {
					
					player = 2;
				}
				else {
					player = 1;
				}
				// IF WE ARE IN 2-PLAYER MODE WE CALL updateMap() TO DISPLAY THE MAP OF THE OTHER PLAYER
				updateMap();
			}
			// IF ANY OF THE 2 PLAYERS HAVE SUNK ALL THE BOATS THE GAME CONTINUES BY ASKING FOR NEW COORDINATES TO SHOOT AT
			if (sunkShips <= 3 && sunkShipsP2 <= 3) {
				
				newCoordinates();
			}
			// IF ANY OF THE 2 PLAYERS HAS SUNK ALL THE BOAT THE GAME ENDS
			else {
				
				end();
			}
		}
		public static void end () {
			
			// WHEN THE GAME IS END:
			
			String answer;
			
			// WE PRINT THAT THE GAME IS OVER
			System.out.println("\n\tThe game is over!");
			// IF WE ARE IN 2-PLAYER MODE WE DISPLAY WHO IS THE WINNER
			if (twoPlayerMode){
				
				if (sunkShips == 4) {
					
					System.out.println("\n\tThe winner is PLAYER 1");
				}
				else if (sunkShipsP2 == 4) {
					
					System.out.println("\n\tThe winner is PLAYER 2");
				}
			}
			// WE DISPLAY THE NUMBER OF PLAYED GAMES
			System.out.println("\n\t"+ playedGames + " Game played");
			// WE ASK IF THE PLAYER WANTS TO PLAY AGAIN AND CHECK IF THE INPUT IS CORRECT
			do {
				System.out.print("\n\tDo you want to play again? (Y/N) \n\t");
				answer = input.next();

			} while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")));
			
			// IF THE PLAYER WANTS TO PLAY AGAIN, WE CALL THE FUNCTION restart()
			if (answer.equalsIgnoreCase("Y")) {
				restart();
			}
			// IF THE PLAYER DOES NOT WANT TO PLAY AGAIN, WE FINISH THE EXECUTION OF THE GAME
			else {
				System.exit(-1);
			}
		}
		public static void restart () {
			
			// IF THE PLAYER WANTS TO PLAY AGAIN ALL THE VARIABLES ARE RESETED
			
			player = 1;
			playedGames += 1;
			sunkShips = 0;
			shootsFired = 0;
			remainingQuadrants1 = 3;
			remainingQuadrants2 = 3;
			remainingQuadrants3 = 2;
			remainingQuadrants4 = 2;
			sunkShipsP2 = 0;
			shootsFiredP2 = 0;
			remainingQuadrants1P2 = 3;
			remainingQuadrants2P2 = 3;
			remainingQuadrants3P2 = 2;
			remainingQuadrants4P2 = 2;
			
			// WE CALL THE FUNCTION initialize() TO RESET THE ARRAYS
			initialize();
			// WE GENERATE NEW SHIPS
			shipGeneration();
			// WE DISPLAY DE BOARD
			updateMap();
			// WE ASK FOR NEW COORDINATES
			newCoordinates();
		}
}