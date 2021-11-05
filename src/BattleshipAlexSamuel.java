// AUTHORS

// ALEX VELA MERRIEN

// SAMUEL PÉREZ SANDONATO

import java.util.Scanner;

public class BattleshipAlexSamuel {

		public static void main (String [] Args) {
			
			// TREMENDO JUEGAZO DE ALEX Y SAMUEL:
			
			// QUE NO QUITES EL EPICARDO BOBO
			updateMap();
		}
		
		public static void start () {
			
			// ESTA PARTE SE ENCARGA DE MOSTRAR EN PANTALLA EL INICIO DEL JUEGO
			// Y  DE PREGUNTAR AL JUGADOR EN QUE MODO DE JUEGO QUIERE JUGAR
			
			
		}
		public static void shipGeneration () {
			
			// ESTA PARTE SE ENCARGA DE GENERAR LOS BARCOS ALEATORIAMENTE
			// HAY 2 BARCOS DE 2 Y DE 3, HORIZONTALES Y VERTICALES
			
			
		}
		public static void updateMap () {
			
			// ESTA PARTE SE ENCARGA DE ACTUALIZAR EL MAPA DE JUEGO
			// BASICAMENTE HAR� LOS PRINT DEL ARRAY
			// AGUA: 0 TOCADO: # HUNDIDO: X
			
			String [] [] infoMapa = new String [] []  {{"#","A"," ","X"," "},{"#"," "," ","A"," "},{" ","X","#"," ","#"},{"#"," ","A"," ","#"},{" ","X"," ","X","#"}};
			String inf = "\t|_____|_____|_____|_____|_____|";
			String sup = "\t|     |     |     |     |     |";
			String top = "\t_______________________________";
			
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
			
			
			System.out.println(top);
			
			for (int i = 0; i<infoMapa.length; i++) {
				
				System.out.print(sup);
				System.out.print("\n\t");
				for (int j=0; j<infoMapa[i].length; j++) {
								
					
					System.out.print("|  " + infoMapa[i][j] + "  ");
					
				}
				System.out.println("|");
				System.out.println(inf);
			}
		}
		public static void shootAt (int x, int y) {
			
			// ESTA PARTE SE ENCARGA DE PEDIR LAS COORDENADAS Y ACTUALIZAR EL ARRAY CON LOS
			// CALCULOS CORRESPONDIENTES Y CONTADORES (DISPAROS, BARCOS HUNDIDOS...)
			// SYNTAXIS PARA INTRODUCIR COORDENADAS: (posx, poxy) 
			// SI LAS COORDENADAS NO SON V�LIDAS VOLVER A PREGUNTAR
			// SI SON VALIDAS ACTUALIZAR ARRAY Y LLAMAR A UpdateMap()
			
			
		}
		public static void end () {
			
			// CUANDO EL JUEGO TERMINA ESTA PARTE SE ENCARGA DE MOSTRAR LA INFO DE
			// LA PARTIDA, LAS PARTIDAS JUGADAS Y PREGUNTAR SI SE QUIERE VOLVER A JUGAR
			// SI SE QUIERE VOLVER A JUGAR LLAMAR A restart()
			
			
		}
		public static void restart () {
			
			// SI SE QUIERE VOLVER A JUGAR HAY QUE REINICIAR TODAS LAS VARIABLES Y VOLVER A LANZAR EL JUEGO
			
			
			
		}
}
