package oop;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Color;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class GraphicsSystem extends LBUGraphics {
	
	
	public void about() {
        super.about(); 
        displayMessage("My name is Jadine.");
        
    }
	
	public void reset() {
		super.reset();
		penDown();
		setPenColour(Color.red);
		
	}
	
	public void square (int length) {
	    for (int i = 0; i < 4; i++) {
	        forward(length);
	        turnRight();
	    }
	}

	
	public void triangle(int length) {
	    for (int i = 0; i < 3; i++) {
	        forward(length);
	        turnLeft(120);
	    }
	}
	
	public void diamond(int length) {
	    for (int i = 0; i < 2; i++) {
	        forward(length);
	        turnRight(60);
	        forward(length);
	        turnRight(120);
	    }
	}
	
	public void processCommand(String command) {

		String[] commandSplit = command.toLowerCase().split(" ");

		int defaultValueDistance = 20;
		
		int defaultValueDegrees = 90;
		
		int commandSplit1;
		
		if(commandSplit.length == 2) {
			try {
				commandSplit1 = Integer.parseInt(commandSplit[1]);
			} catch (NumberFormatException e) {
				commandSplit1 = 0;
	            displayMessage("Invalid parameter, please enter a valid number");
	            return;
			}
		} else {
			
			commandSplit1 = 0;
		}
		
		if(commandSplit1 < 0 || commandSplit1 > 500) {
            displayMessage("Please enter a number between 0 and 500");
            return;
		}
		switch(commandSplit[0]) {

			case "about":
				about();
				clear();
				penDown();
				break;

			case "forward":
			    if (commandSplit.length == 2) {
			    	forward(commandSplit1);
			    } else {
			        forward (defaultValueDistance);
			        displayMessage ("No parameter, default value of 20 used");
			    }
			    break;

			case "backward":
				if (commandSplit.length == 2) {
					forward (-commandSplit1);
				} else {
					forward (-defaultValueDistance);
					displayMessage ("No parameter, default value of 20 used");
				}
				break;

			case "turnleft":
				if (commandSplit.length == 2) {
					turnLeft(commandSplit1);
				} else {
					turnLeft (defaultValueDegrees);
					displayMessage ("No parameter, default value of 90 displayed");
				}
				break;

			case "turnright":
				if (commandSplit.length == 2) {
					turnRight(commandSplit1);
				} else {
					turnRight (defaultValueDegrees);
					displayMessage ("No parameter, default value of 90 displayed");
				}
				break;

			case "pendown":
				penDown();
				break;

			case "penup":
				penUp();
				break;

			case "clear":
				clear();
				break;

			case "reset":
				reset();
				break;
							
			case "red":
				setPenColour(Color.red);
				break;

			case "black":
				setPenColour(Color.black);
				break;

			case "green":
				setPenColour(Color.green);
				break;

			case "white":
				setPenColour(Color.white);
				break;
				
			case "blue":
				setPenColour(Color.blue);
				break;
				
			case "save":
			    if (commandSplit.length == 1) {
			        displayMessage("Invalid save command. Please enter a filename.");
			        break;
			    }
			    try {
			        BufferedImage image = getBufferedImage();
			        File outputFile = new File(commandSplit[1] + ".png");
			        ImageIO.write(image, "png", outputFile);
			        displayMessage("Image saved");
			    } catch (IOException e) {
			        displayMessage("There was an error saving the image");
			    }
			    break;
			    
			case "load":
                    try {
                        File inputFile = new File(commandSplit[1] + ".png");
                        BufferedImage image = ImageIO.read(inputFile);
                        setBufferedImage(image);
                        displayMessage("Image loaded");
                    }
                    catch (IOException e) {
                        displayMessage("There was an error loading the image");
                    }
                    break;
                    
			case "circle":
				if (commandSplit.length == 2) {
			    	circle(commandSplit1);
			    } else {
			        displayMessage("Please enter a length for the circle");
			    }
			    break;
                    
			case "square":
			    if (commandSplit.length == 2) {
			    	square(commandSplit1);
			    } else {
			        displayMessage("Please enter a length for the square");
			    }
			    break;
			    
			case "triangle":
				if (commandSplit.length == 2) {
					triangle(commandSplit1);
			    } else {
			        displayMessage("Please enter a length for the triangle");
			    }
			    break;
			    
			case "diamond":
				if (commandSplit.length == 2) {
					diamond(commandSplit1);
			    } else {
			        displayMessage("Please enter a length for the diamond");
			    }
			    break;
			    
			case "width":
				if (commandSplit.length == 2) {
					setStroke(commandSplit1);
				} else {
					displayMessage("Please enter a value for the width");
				}
				break;
				
			case "speed":
				if (commandSplit.length == 2) {
					setTurtleSpeed(commandSplit1);
				} else {
					displayMessage("Please enter a value for the speed");
				}
				break;
                  
             default:
            	 displayMessage("Invalid command, please try again");
                }
		}
	
	}
	
	
