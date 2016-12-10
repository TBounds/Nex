package nex;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
	
	DataInputStream in;
	DataOutputStream out;
	
	
	public void run(){

		String serverAddress = "localhost";
		Socket socket = null;
		try {
			
			socket = new Socket("localhost", 1201);
			in = new DataInputStream(socket.getInputStream());
		    out = new DataOutputStream(socket.getOutputStream());
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PlayingState.playerNumber = in.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while (true) {
			

			try {
				//System.out.println(PlayingState.row + ", " + PlayingState.col);
//				out.print(PlayingState.row);
//				out.print(PlayingState.col);
//				out.flush();
//				int p1x = in.read();
//				int p1y = in.read();

				
			    
			    out.write(PlayingState.row);
			    out.write(PlayingState.col);
			   
			    PlayingState.numberOfPlayers = in.read();
			    if(PlayingState.playerNumber == 1){
			    
			    	int p1x = in.read();
				    int p1y = in.read();	    
				    PlayingState.otherPlayerX = in.read();
				    PlayingState.otherPlayerY = in.read();
			    
			    } else {
			    
			    	PlayingState.otherPlayerX = in.read();
				    PlayingState.otherPlayerY = in.read();
				  	int p1x = in.read();
				    int p1y = in.read();
			    
			    }
			    
			    
			    
			    //System.out.println(p1x + ", " + p1y);
			    
				//PlayingState.updateP1(p1x, p1y);
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//            if (line.startsWith("PlayerNumber")) {
//                //out.println(getName());
//            	//set the players number
//            } else if (line.startsWith("Error")) {
//            	//error if there are too many players....
//            	
//            } else if (line.startsWith("MESSAGE")) {
//                line.substring(8);
//            }
        }
    
	} 
}
