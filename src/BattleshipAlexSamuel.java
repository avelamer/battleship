// AUTHORS

// ALEX VELA MERRIEN

// SAMUEL PEREZ SANDONATO

import java.util.Scanner;

public class BattleshipAlexSamuel {

	
	static int[] beginingNumbers = new int []  {1,2,3,4,5}; 
	static int[][] infoShips = new int [5][5];
	static int[][] shootedQuadrants = new int [5][5];
	static String[][] infoMapa = new String [5] [5];

	static Scanner input = new Scanner(System.in);
	
	static int shipH3X , shipH3Y; // VARIABLES FOR SHIP LENGTH 3 HORIZONTAL   1
	static int shipV3X , shipV3Y; // VARIABLES FOR SHIP LENGTH 3 VERTICAL     2
	static int shipH2X , shipH2Y; // VARIABLES FOR SHIP LENGTH 2 HORIZONTAL   3
	static int shipV2X , shipV2Y; // VARIABLES FOR SHIP LENGTH 2 VERTICAL     4
	
	static int remainingQuadrants1 = 3;
	static int remainingQuadrants2 = 3;
	static int remainingQuadrants3 = 2;
	static int remainingQuadrants4 = 2;
	
	static int sunkShips = 0;
	static int shootsFired = 0;
	static int playedGames = 1;
	
	
		public static void main (String [] Args) {
			
			// TREMENDO JUEGAZO DE ALEX Y SAMUEL:
			
			//initialize();
			
			//start();
			
			//shipGeneration();
			
			//updateMap();
			
			//end();
		}
		public static void initialize () {
			
			for (int i = 0; i< shootedQuadrants.length; i++) {
				
				for (int j = 0; j< shootedQuadrants.length; j++) {
					
					shootedQuadrants[i][j] = 0;
					infoShips[i][j] = 0;
					infoMapa[i][j] = " ";
				}
			}
		}
		public static void start () {
			
			
			

			// ESTA PARTE SE ENCARGA DE MOSTRAR EN PANTALLA EL INICIO DEL JUEGO		
			// Y  DE PREGUNTAR AL JUGADOR EN QUE MODO DE JUEGO QUIERE JUGAR	   
			
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
	 
	
			   
	 System.out.println("\n"
				+ "\n \n \n \tPlease select a gamemode: \n  \ta) Basic mode\n  \tb) Advanced mode\n");	  
			  	  
			  
			  
			
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
			shipH3X = (int) (Math.random() * 3);
			shipH3Y = (int) (Math.random() * 5);
			
			// THE SHIP IS CREATED TO THE RIGHT FROM THE CENTER OF THE SHIP
			infoShips[shipH3Y][shipH3X]     = 1;
			infoShips[shipH3Y][shipH3X + 1] = 1;
			infoShips[shipH3Y][shipH3X + 2] = 1;
			
			// SHIP LENGTH 3 VERTICAL
			
			// A LOOP IS CREATED TO CREATE NEW COORDINATES POR THE SHIP CENTER UNTIL ANY COORDINATES OF THE SHIP DOES NOT
			// COINCIDE WITH ANY OTHER COORDINATES OF PREVIUSLY CREATED SHIPS
			while (!valid) {
				
				// THE RANDOM COORDINATES ARE GENERATED
				shipV3X = (int) (Math.random() * 5);
				shipV3Y = (int) (Math.random() * 3);
				
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
				shipH2X = (int) (Math.random() * 4);
				shipH2Y = (int) (Math.random() * 5);
				
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
				shipV2X = (int) (Math.random() * 5);
				shipV2Y = (int) (Math.random() * 4);
				
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

		}
		public static void updateMap () {
			
			// ESTA PARTE SE ENCARGA DE ACTUALIZAR EL MAPA DE JUEGO
			// BASICAMENTE HARA LOS PRINT DEL ARRAY
			// AGUA: 0 TOCADO: # HUNDIDO: X
			String inf = "\t|_____|_____|_____|_____|_____|";
			String sup = "\t|     |     |     |     |     |";
			String top = "\t_______________________________";
			String topLetters = "\t   A     B     C     D     E   ";
			
						// 			EJEMPLO TABLERO
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
			
			System.out.println(topLetters);
			System.out.println(top);
			
			for (int i = 0; i<infoMapa.length; i++) {
				
				System.out.println(sup);
				System.out.print("      "+beginingNumbers[i]+" ");
				
			
				for (int j=0; j<infoMapa[i].length; j++) {
								
					System.out.print("|  " + infoMapa[i][j] + "  ");
					
				}
				System.out.println("|");
				System.out.println(inf);
				
			}
			System.out.println("\n\tShots fired: " + shootsFired);
			System.out.println("\tShips sunk: " + sunkShips);
			
			if (sunkShips <= 3) {
				
				newCoordinates();
			}
			else {
				
				end();
			}
		}
		public static void newCoordinates() {
			
			int X = 0,Y;
			String coordinates;

						
			System.out.print("\n\t(REMINDER) SINTAX IS: POSX,POSY \n"
						    +"\tInsert the coordinates: \n\t");
							
			coordinates = input.nextLine();
			
			while(!coordinates.startsWith("A")  && !coordinates.startsWith("B")  && !coordinates.startsWith("C")  && !coordinates.startsWith("D")  && !coordinates.startsWith("E") && !coordinates.startsWith("a")  && !coordinates.startsWith("b")  && !coordinates.startsWith("c")  && !coordinates.startsWith("d")  && !coordinates.startsWith("e") || coordinates.charAt(1) != ',' || Character.getNumericValue(coordinates.charAt(2)) < 1 || Character.getNumericValue(coordinates.charAt(2)) > 5 || coordinates.length() > 3) {

					System.out.print("\n\tThe coordinates could not be found, please try again");
					System.out.print("\n\t(REMINDER) SINTAX IS: POSX,POSY \n"
									+"\tInsert the coordinates: \n\t");
					
					coordinates = input.nextLine();
			}
				if(coordinates.startsWith("A") || coordinates.startsWith("a")){
					X = 1;
				}
				else if(coordinates.startsWith("B") || coordinates.startsWith("b")){
					X = 2;
				}
				else if(coordinates.startsWith("C") || coordinates.startsWith("c")){
					X = 3;
				}
				else if(coordinates.startsWith("D") || coordinates.startsWith("d")){
					X = 4;
				}
				else if(coordinates.startsWith("E") || coordinates.startsWith("e")){
					X = 5;
				}
			
			Y = Character.getNumericValue(coordinates.charAt(2));
			
			
			shootAt(X,Y);
		}
		public static void shootAt (int x, int y) {
			
			// ESTA PARTE SE ENCARGA DE PEDIR LAS COORDENADAS Y ACTUALIZAR EL ARRAY CON LOS
			// CALCULOS CORRESPONDIENTES Y CONTADORES (DISPAROS, BARCOS HUNDIDOS...)
			// SYNTAXIS PARA INTRODUCIR COORDENADAS: (posx, poxy) 
			// SI LAS COORDENADAS NO SON VÃLIDAS VOLVER A PREGUNTAR
			// SI SON VALIDAS ACTUALIZAR ARRAY Y LLAMAR A UpdateMap()
			

			
			if (shootedQuadrants[x-1][y-1] == 0) {
				
				shootedQuadrants[x-1][y-1] = 1;
				shootsFired += 1;
				
				switch (infoShips[y-1][x-1]) {
			
					case 0: 
				 
						infoMapa[y-1][x-1] = "0";
						System.out.println("\tWhat a shame, it's water :(\n");
						break;
					case 1:
				
						remainingQuadrants1 -= 1;
				
						if (remainingQuadrants1 >0) {
					
							infoMapa[y-1][x-1] = "#";
							System.out.println("\tWow, you hit a ship :)\n");
						}
						else {
					
							infoMapa[shipH3Y][shipH3X] = "X";
							infoMapa[shipH3Y][shipH3X + 1] = "X";
							infoMapa[shipH3Y][shipH3X + 2] = "X";
							System.out.println("\tAmazing!!! You sunk a ship!\n");
							sunkShips += 1;
					
						}
						break;
					case 2:
					
						remainingQuadrants2 -= 1;
				
						if (remainingQuadrants2 >0) {
					
							infoMapa[y-1][x-1] = "#";
							System.out.println("\tWow, you hit a ship :)\n");
						}
						else {
					
							infoMapa[shipV3Y][shipV3X] = "X";
							infoMapa[shipV3Y + 1][shipV3X] = "X";
							infoMapa[shipV3Y + 2][shipV3X] = "X";
							System.out.println("\tAmazing!!! You sunk a ship!\n");
							sunkShips += 1;
					
						}
						break;
					case 3:
					
						remainingQuadrants3 -= 1;
				
						if (remainingQuadrants3 >0) {
					
							infoMapa[y-1][x-1] = "#";
							System.out.println("\tWow, you hit a ship :)\n");
						}
						else {
					
							infoMapa[shipH2Y][shipH2X] = "X";
							infoMapa[shipH2Y][shipH2X + 1] = "X";
							System.out.println("\tAmazing!!! You sunk a ship!\n");
							sunkShips += 1;
					
						}
						break;
					case 4:
					
						remainingQuadrants4 -= 1;
				
						if (remainingQuadrants4 >0) {
					
							infoMapa[y-1][x-1] = "#";
							System.out.println("\tWow, you hit a ship :)\n");
						}
						else {
					
							infoMapa[shipV2Y][shipV2X] = "X";
							infoMapa[shipV2Y + 1][shipV2X] = "X";
							System.out.println("\tAmazing!!! You sunk a ship!\n");
							sunkShips += 1;
					
						}
						break;
					
					default: System.out.println("\tERROR");
				}
			}
			else {
				
				System.out.println("\tYou have already shooted at this cuadrant.");
				newCoordinates();
				
			}
					
			updateMap();
		}
		public static void end () {
			
			// CUANDO EL JUEGO TERMINA ESTA PARTE SE ENCARGA DE MOSTRAR LA INFO DE
			// LA PARTIDA, LAS PARTIDAS JUGADAS Y PREGUNTAR SI SE QUIERE VOLVER A JUGAR
			// SI SE QUIERE VOLVER A JUGAR LLAMAR A restart()
			boolean valid = false;
			String answer;
			
			System.out.println("\tThe game is over!");
			System.out.println("\t"+ playedGames + " Game played");
			do {
				System.out.println("\tDo you want to play again? (Y/N)");
				answer = input.nextLine();

			} while (!(answer.equalsIgnoreCase("Y") || answer.equalsIgnoreCase("N")));
			
			if (answer.equalsIgnoreCase("Y")) {
				restart();
			}
			else {
				System.exit(-1);
			}
		}
		public static void restart () {
			
			// SI SE QUIERE VOLVER A JUGAR HAY QUE REINICIAR TODAS LAS VARIABLES Y VOLVER A LANZAR EL JUEGO
			
			playedGames += 1;
			sunkShips = 0;
			shootsFired = 0;
			
			initialize();
			shipGeneration();
			updateMap();
		}
}





