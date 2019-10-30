/*
    @author Marshall Smith
    @author Micah Penney
    Last modified on 15 July 2019
    Windows 10
    Visual Studio Code
    This program will be used in a kindergraden class to test the students on how well the know 3 letters words
    They will be given a picutre and then they will have to sound out and click the correct letters and place them 
    in the blanks. 
*/

//Importing libraries
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.image.*;
import java.io.*;

//Main class
public class Phonetics extends Application {

    Stage window;
    Scene openingScene, firstScene, secondScene, thirdScene, fourthScene, fifthScene;

    //Other varibles we might need
    public String file, letter;
    public String  storedletter1, storedletter2, storedletter3;
    public File kidfile;
    public static PrintWriter output;


    //Overiden main method
    public static void main(String[] args){
        launch(args);
        output.close();
     }
    
     //Start method
    public void start (Stage primaryStage)throws IOException {
        window = primaryStage;
        window.setTitle("Phonetics Program");
    
    //openingScene 
        Pane root1 = new Pane();
        openingScene = new Scene(root1, 750, 500);
        Image backGroundImage = new Image("BackgroundImage.jpg");
        ImageView backGround = new ImageView(backGroundImage);
        backGround.setFitHeight(500);
        backGround.setFitWidth(750);
        window.setResizable(false);
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(15));
        gp.setHgap(10);
        gp.setVgap(10);
    //End of opening scene

    //Creating the Title
        Label title = new Label("Phonetics Evaluation");
        title.setTextFill(Color.rgb(80, 33, 0));
        title.setFont(new Font("Comic Neue Angular Bold", 70));
        GridPane.setHalignment(title, HPos.LEFT);
        gp.add(title, 3, 2);
    //End of Title text

    //Creating the instrusction for the openingScene
        Label speech = new Label("Directions: Sound out each picutre\n" +
            "then spell it by clicking on the tiles.");
        speech.setTextFill(Color.rgb(0, 0, 60));
        speech.setFont(new Font("Comic Neue Angular Bold", 25));
        GridPane.setHalignment(speech, HPos.LEFT);
        gp.add(speech, 3, 3);
    //End of Instructions text

    //Button for creating file
        Button createButton = new Button("Create");
        createButton.setFont(new Font("Comic Neue Angular Bold", 15));
        createButton.setTranslateX(180);
        createButton.setTranslateY(390);

    //Creating the next button
        Button nextButton = new Button("START");
        nextButton.setFont(new Font("Comic Neue Angular Bold", 25));
        nextButton.setOnAction(e -> window.setScene(firstScene));
        nextButton.setTranslateX(570);
        nextButton.setTranslateY(370);
    //End of openeingScene

    //Childs name for file
        TextField filename = new TextField();
        filename.setPrefSize(120, 30);
        filename.setTranslateX(40);
        filename.setTranslateY(390);
        filename.setAlignment(Pos.CENTER);
    //End of file creation 

    //Instructions for file input
        Text fileText = new Text("Please, enter the student's name\n to create a file for the student");
        fileText.setFill(Color.BLACK);
        fileText.setFont(new Font("Comic Neue Angular Bold", 20));
        fileText.setTranslateX(40);
        fileText.setTranslateY(340);
    //End of file instructions

    //Getting the user input
        createButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent event){
                try{
                    file = filename.getText();
                    kidfile = new File(file + ".txt");
                    output = new PrintWriter(kidfile);
                }
                catch(Exception e){
                    System.out.println("This file could not be found.");
                }
            }
        });
    //End of getting file name


    //Make everything display
        root1.getChildren().add(backGround);
        root1.getChildren().add(gp);
        root1.getChildren().add(filename);
        root1.getChildren().add(nextButton);
        root1.getChildren().add(fileText);
        root1.getChildren().add(createButton);
        window.setScene(openingScene);
        window.show();
    //End of display
    //End of menu scene

    //Beginning of first slide scene
        Pane root2 = new Pane();
        firstScene = new Scene(root2, 750, 500);
        ImageView backGround_fs = new ImageView(backGroundImage);
        backGround_fs.setFitHeight(500);
        backGround_fs.setFitWidth(750);
        window.setResizable(false);
        GridPane gp_fs = new GridPane();
        gp_fs.setPadding(new Insets(30));
        gp_fs.setHgap(10);
        gp_fs.setVgap(10);
    //End of opening scene

    //Next Button from first scene to second scene
        Button nextButton_fs = new Button("Next");
        nextButton_fs.setFont(new Font("Comic Neue Angular Bold", 25));
        nextButton_fs.setOnAction(e -> window.setScene(secondScene));
        nextButton_fs.setTranslateX(598);   //Width
        nextButton_fs.setTranslateY(100);   //Height
    //End of next button

    //Textfield input of answer
     TextField letter1_fs = new TextField();
     letter1_fs.setPrefSize(60, 40);
     letter1_fs.setTranslateX(200);
     letter1_fs.setTranslateY(275);
     letter1_fs.setAlignment(Pos.CENTER);
    //End of Textfield
    
    //Textfield input of answer
     TextField letter2_fs = new TextField();
     letter2_fs.setPrefSize(60, 40);
     letter2_fs.setTranslateX(332.5);
     letter2_fs.setTranslateY(275);
     letter2_fs.setAlignment(Pos.CENTER);
    //End of Textfield

    //Textfield input of answer
     TextField letter3_fs = new TextField();
     letter3_fs.setPrefSize(60, 40);
     letter3_fs.setTranslateX(465);
     letter3_fs.setTranslateY(275);
     letter3_fs.setAlignment(Pos.CENTER);
    //End of Textfield

    //Start of alphabet button display 
        Button aButton_fs = new Button("a");
        aButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(aButton_fs, 8, 34);
        aButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "a";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
                
            }
        }); 

        Button bButton_fs = new Button("b");
        bButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(bButton_fs, 9, 34);
        bButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "b";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button cButton_fs = new Button("c");
        cButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(cButton_fs, 10, 34);
        cButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "c";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button dButton_fs = new Button("d");
        dButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(dButton_fs, 11, 34);
        dButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "d";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button eButton_fs = new Button("e");
        eButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(eButton_fs, 12, 34);
        eButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "e";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button fButton_fs = new Button("f");
        fButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(fButton_fs, 13, 34);
        fButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "f";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button gButton_fs = new Button("g");
        gButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(gButton_fs, 14, 34);
        gButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "g";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button hButton_fs = new Button("h");
        hButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(hButton_fs, 15, 34);
        hButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "h";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button iButton_fs = new Button("i");
        iButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(iButton_fs, 16, 34);
        iButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "i";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button jButton_fs = new Button("j");
        jButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(jButton_fs, 17, 34);
        jButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "j";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        });

        Button kButton_fs = new Button("k");
        kButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(kButton_fs, 18, 34);
        kButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "k";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button lButton_fs = new Button("l");
        lButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(lButton_fs, 19, 34);
        lButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "l";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button mButton_fs = new Button("m");
        mButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(mButton_fs, 20, 34);
        mButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "m";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

    //Start of the second line
        Button nButton_fs = new Button("n");
        nButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(nButton_fs, 8, 35);
        nButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "n";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button oButton_fs = new Button("o");
        oButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(oButton_fs, 9, 35);
        oButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "o";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button pButton_fs = new Button("p");
        pButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(pButton_fs, 10, 35);
        pButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "p";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button qButton_fs = new Button("q");
        qButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(qButton_fs, 11, 35);
        qButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "q";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button rButton_fs = new Button("r");
        rButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(rButton_fs, 12, 35);
        rButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "r";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button sButton_fs = new Button("s");
        sButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(sButton_fs, 13, 35);
        sButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "s";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 
        
        Button tButton_fs = new Button("t");
        tButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(tButton_fs, 14, 35);
        tButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "t";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button uButton_fs = new Button("u");
        uButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(uButton_fs, 15, 35);
        uButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "u";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 

        Button vButton_fs = new Button("v");
        vButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(vButton_fs, 16, 35);
        vButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "v";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 
        
        Button wButton_fs = new Button("w");
        wButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(wButton_fs, 17, 35);
        wButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "w";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 
        
        Button xButton_fs = new Button("x");
        xButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(xButton_fs, 18, 35);
        xButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "x";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 
        
        Button yButton_fs = new Button("y");
        yButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(yButton_fs, 19, 35);
        yButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "y";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 
        
        Button zButton_fs = new Button("z");
        zButton_fs.setFont(new Font("Comic Neue Angular Bold", 15));
        gp_fs.add(zButton_fs, 20, 35);
        zButton_fs.pressedProperty().addListener((o, old, newValue) -> {
            if(newValue) {
                letter = "z";
                letterFill(letter, letter1_fs, letter2_fs, letter3_fs);
            }
        }); 
    //Start of alphabet button display

    //Start of Cat image
        Image firstsceneimage = new Image("Cat.jpg");
        ImageView firstscene = new ImageView(firstsceneimage);
        firstscene.setFitHeight(200);
        firstscene.setFitWidth(325);
        firstscene.relocate(200, 50);
    //End of Cat image

    //Enter button 1
        Button enterButton = new Button("Enter");
        enterButton.setFont(new Font("Comic Neue Angular Bold", 25));
        enterButton.setTranslateX(598);
        enterButton.setTranslateY(175);
    //End of enter button 1
    
    //Getting the user input
        enterButton.setOnAction(new EventHandler<ActionEvent>(){
            public void handle (ActionEvent event){
                storedletter1 = letter1_fs.getText();
                storedletter2 = letter2_fs.getText();
                storedletter3 = letter3_fs.getText();
                //Writting the text to a file
                output.println(storedletter1 + " " + storedletter2 + " " + storedletter3 + "\n");
                //End of writting 
            }
        });
    //End of getting file name

    //Beginning of display 
        root2.getChildren().add(backGround_fs);
        root2.getChildren().add(firstscene);
        root2.getChildren().add(gp_fs);
        root2.getChildren().add(letter1_fs);
        root2.getChildren().add(letter2_fs);
        root2.getChildren().add(letter3_fs);
        root2.getChildren().add(nextButton_fs);
        root2.getChildren().add(enterButton);
    //End of display

    
    /*
    * Start of the next scene
    */
    

    //Beginning of second slide scene
        Pane root3 = new Pane();
        secondScene = new Scene(root3, 750, 500);
        ImageView backGround_ss = new ImageView(backGroundImage);
        backGround_ss.setFitHeight(500);
        backGround_ss.setFitWidth(750);
        window.setResizable(false);
        GridPane gp_ss = new GridPane();
        gp_ss.setPadding(new Insets(30));
        gp_ss.setHgap(10);
        gp_ss.setVgap(10);
     //End of opening scene
 
     //Next Button from second scene to third scene
         Button nextButton_ss = new Button("Next");
         nextButton_ss.setFont(new Font("Comic Neue Angular Bold", 25));
         nextButton_ss.setOnAction(e -> window.setScene(thirdScene));
         nextButton_ss.setTranslateX(598);   //Width
         nextButton_ss.setTranslateY(100);   //Height
     //End of next button
 
     //Textfield input of answer
      TextField letter1_ss = new TextField();
      letter1_ss.setPrefSize(60, 40);
      letter1_ss.setTranslateX(200);
      letter1_ss.setTranslateY(275);
      letter1_ss.setAlignment(Pos.CENTER);
     //End of Textfield
     
     //Textfield input of answer
      TextField letter2_ss = new TextField();
      letter2_ss.setPrefSize(60, 40);
      letter2_ss.setTranslateX(332.5);
      letter2_ss.setTranslateY(275);
      letter2_ss.setAlignment(Pos.CENTER);
     //End of Textfield
 
     //Textfield input of answer
      TextField letter3_ss = new TextField();
      letter3_ss.setPrefSize(60, 40);
      letter3_ss.setTranslateX(465);
      letter3_ss.setTranslateY(275);
      letter3_ss.setAlignment(Pos.CENTER);
     //End of Textfield
 
     //Start of alphabet button display 
         Button aButton_ss = new Button("a");
         aButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(aButton_ss, 8, 34);
         aButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "a";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
                 
             }
         }); 
 
         Button bButton_ss = new Button("b");
         bButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(bButton_ss, 9, 34);
         bButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "b";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button cButton_ss = new Button("c");
         cButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(cButton_ss, 10, 34);
         cButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "c";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button dButton_ss = new Button("d");
         dButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(dButton_ss, 11, 34);
         dButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "d";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button eButton_ss = new Button("e");
         eButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(eButton_ss, 12, 34);
         eButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "e";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button fButton_ss = new Button("f");
         fButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(fButton_ss, 13, 34);
         fButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "f";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button gButton_ss = new Button("g");
         gButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(gButton_ss, 14, 34);
         gButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "g";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button hButton_ss = new Button("h");
         hButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(hButton_ss, 15, 34);
         hButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "h";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button iButton_ss = new Button("i");
         iButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(iButton_ss, 16, 34);
         iButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "i";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button jButton_ss = new Button("j");
         jButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(jButton_ss, 17, 34);
         jButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "j";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         });
 
         Button kButton_ss = new Button("k");
         kButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(kButton_ss, 18, 34);
         kButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "k";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button lButton_ss = new Button("l");
         lButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(lButton_ss, 19, 34);
         lButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "l";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button mButton_ss = new Button("m");
         mButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(mButton_ss, 20, 34);
         mButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "m";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
     //Start of the second line
         Button nButton_ss = new Button("n");
         nButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(nButton_ss, 8, 35);
         nButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "n";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button oButton_ss = new Button("o");
         oButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(oButton_ss, 9, 35);
         oButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "o";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button pButton_ss = new Button("p");
         pButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(pButton_ss, 10, 35);
         pButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "p";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button qButton_ss = new Button("q");
         qButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(qButton_ss, 11, 35);
         qButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "q";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button rButton_ss = new Button("r");
         rButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(rButton_ss, 12, 35);
         rButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "r";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button sButton_ss = new Button("s");
         sButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(sButton_ss, 13, 35);
         sButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "s";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
         
         Button tButton_ss = new Button("t");
         tButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(tButton_ss, 14, 35);
         tButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "t";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button uButton_ss = new Button("u");
         uButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(uButton_ss, 15, 35);
         uButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "u";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
 
         Button vButton_ss = new Button("v");
         vButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(vButton_ss, 16, 35);
         vButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "v";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
         
         Button wButton_ss = new Button("w");
         wButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(wButton_ss, 17, 35);
         wButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "w";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
         
         Button xButton_ss = new Button("x");
         xButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(xButton_ss, 18, 35);
         xButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "x";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
         
         Button yButton_ss = new Button("y");
         yButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(yButton_ss, 19, 35);
         yButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "y";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
         
         Button zButton_ss = new Button("z");
         zButton_ss.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ss.add(zButton_ss, 20, 35);
         zButton_ss.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "z";
                 letterFill(letter, letter1_ss, letter2_ss, letter3_ss);
             }
         }); 
     //Start of alphabet button display
 
     //Start of Mop image
         Image secondsceneimage = new Image("Mop.jpg");
         ImageView secondscene = new ImageView(secondsceneimage);
         secondscene.setFitHeight(200);
         secondscene.setFitWidth(325);
         secondscene.relocate(200, 50);
     //End of Mop image
 
     //Enter button 1
         Button enterButton_ss = new Button("Enter");
         enterButton_ss.setFont(new Font("Comic Neue Angular Bold", 25));
         enterButton_ss.setTranslateX(598);
         enterButton_ss.setTranslateY(175);
     //End of enter button 1
     
     //Getting the user input
         enterButton_ss.setOnAction(new EventHandler<ActionEvent>(){
             public void handle (ActionEvent event){
                 storedletter1 = letter1_ss.getText();
                 storedletter2 = letter2_ss.getText();
                 storedletter3 = letter3_ss.getText();
                 //Writting the text to a file
                 output.println(storedletter1 + " " + storedletter2 + " " + storedletter3 + "\n");
                 //End of writting 
             }
         });
     //End of getting file name
 
     //Beginning of display 
         root3.getChildren().add(backGround_ss);
         root3.getChildren().add(secondscene);
         root3.getChildren().add(gp_ss);
         root3.getChildren().add(letter1_ss);
         root3.getChildren().add(letter2_ss);
         root3.getChildren().add(letter3_ss);
         root3.getChildren().add(nextButton_ss);
         root3.getChildren().add(enterButton_ss);
     //End of display   
    
    /*
    * Start of the third picutre scene
    */

    //Beginning of second slide scene
        Pane root4 = new Pane();
        thirdScene = new Scene(root4, 750, 500);
        ImageView backGround_ts = new ImageView(backGroundImage);
        backGround_ts.setFitHeight(500);
        backGround_ts.setFitWidth(750);
        window.setResizable(false);
        GridPane gp_ts = new GridPane();
        gp_ts.setPadding(new Insets(30));
        gp_ts.setHgap(10);
        gp_ts.setVgap(10);
     //End of opening scene
 
     //Next Button from third scene to fourth scene
         Button nextButton_ts = new Button("Next");
         nextButton_ts.setFont(new Font("Comic Neue Angular Bold", 25));
         nextButton_ts.setOnAction(e -> window.setScene(fourthScene));
         nextButton_ts.setTranslateX(598);   //Width
         nextButton_ts.setTranslateY(100);   //Height
     //End of next button
 
     //Textfield input of answer
      TextField letter1_ts = new TextField();
      letter1_ts.setPrefSize(60, 40);
      letter1_ts.setTranslateX(200);
      letter1_ts.setTranslateY(275);
      letter1_ts.setAlignment(Pos.CENTER);
     //End of Textfield
     
     //Textfield input of answer
      TextField letter2_ts = new TextField();
      letter2_ts.setPrefSize(60, 40);
      letter2_ts.setTranslateX(332.5);
      letter2_ts.setTranslateY(275);
      letter2_ts.setAlignment(Pos.CENTER);
     //End of Textfield
 
     //Textfield input of answer
      TextField letter3_ts = new TextField();
      letter3_ts.setPrefSize(60, 40);
      letter3_ts.setTranslateX(465);
      letter3_ts.setTranslateY(275);
      letter3_ts.setAlignment(Pos.CENTER);
     //End of Textfield
 
     //Start of alphabet button display 
         Button aButton_ts = new Button("a");
         aButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(aButton_ts, 8, 34);
         aButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "a";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
                 
             }
         }); 
 
         Button bButton_ts = new Button("b");
         bButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(bButton_ts, 9, 34);
         bButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "b";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button cButton_ts = new Button("c");
         cButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(cButton_ts, 10, 34);
         cButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "c";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button dButton_ts = new Button("d");
         dButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(dButton_ts, 11, 34);
         dButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "d";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button eButton_ts = new Button("e");
         eButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(eButton_ts, 12, 34);
         eButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "e";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button fButton_ts = new Button("f");
         fButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(fButton_ts, 13, 34);
         fButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "f";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button gButton_ts = new Button("g");
         gButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(gButton_ts, 14, 34);
         gButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "g";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button hButton_ts = new Button("h");
         hButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(hButton_ts, 15, 34);
         hButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "h";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button iButton_ts = new Button("i");
         iButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(iButton_ts, 16, 34);
         iButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "i";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button jButton_ts = new Button("j");
         jButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(jButton_ts, 17, 34);
         jButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "j";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         });
 
         Button kButton_ts = new Button("k");
         kButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(kButton_ts, 18, 34);
         kButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "k";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button lButton_ts = new Button("l");
         lButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(lButton_ts, 19, 34);
         lButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "l";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button mButton_ts = new Button("m");
         mButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(mButton_ts, 20, 34);
         mButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "m";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
     //Start of the second line
         Button nButton_ts = new Button("n");
         nButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(nButton_ts, 8, 35);
         nButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "n";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button oButton_ts = new Button("o");
         oButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(oButton_ts, 9, 35);
         oButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "o";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button pButton_ts = new Button("p");
         pButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(pButton_ts, 10, 35);
         pButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "p";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button qButton_ts = new Button("q");
         qButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(qButton_ts, 11, 35);
         qButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "q";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button rButton_ts = new Button("r");
         rButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(rButton_ts, 12, 35);
         rButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "r";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button sButton_ts = new Button("s");
         sButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(sButton_ts, 13, 35);
         sButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "s";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
         
         Button tButton_ts = new Button("t");
         tButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(tButton_ts, 14, 35);
         tButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "t";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button uButton_ts = new Button("u");
         uButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(uButton_ts, 15, 35);
         uButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "u";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
 
         Button vButton_ts = new Button("v");
         vButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(vButton_ts, 16, 35);
         vButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "v";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
         
         Button wButton_ts = new Button("w");
         wButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(wButton_ts, 17, 35);
         wButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "w";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
         
         Button xButton_ts = new Button("x");
         xButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(xButton_ts, 18, 35);
         xButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "x";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
         
         Button yButton_ts = new Button("y");
         yButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(yButton_ts, 19, 35);
         yButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "y";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
         
         Button zButton_ts = new Button("z");
         zButton_ts.setFont(new Font("Comic Neue Angular Bold", 15));
         gp_ts.add(zButton_ts, 20, 35);
         zButton_ts.pressedProperty().addListener((o, old, newValue) -> {
             if(newValue) {
                 letter = "z";
                 letterFill(letter, letter1_ts, letter2_ts, letter3_ts);
             }
         }); 
     //Start of alphabet button display
 
     //Start of Pig image
         Image thirdsceneimage = new Image("Pig.jpg");
         ImageView thirdscene = new ImageView(thirdsceneimage);
         thirdscene.setFitHeight(200);
         thirdscene.setFitWidth(325);
         thirdscene.relocate(200, 50);
     //End of Mop image
 
     //Enter button 1
         Button enterButton_ts = new Button("Enter");
         enterButton_ts.setFont(new Font("Comic Neue Angular Bold", 25));
         enterButton_ts.setTranslateX(598);
         enterButton_ts.setTranslateY(175);
     //End of enter button 1
     
     //Getting the user input
         enterButton_ts.setOnAction(new EventHandler<ActionEvent>(){
             public void handle (ActionEvent event){
                 storedletter1 = letter1_ts.getText();
                 storedletter2 = letter2_ts.getText();
                 storedletter3 = letter3_ts.getText();
                 //Writting the text to a file
                 output.println(storedletter1 + " " + storedletter2 + " " + storedletter3 + "\n");
                 //End of writting 
             }
         });
     //End of getting file name
 
     //Beginning of display 
         root4.getChildren().add(backGround_ts);
         root4.getChildren().add(thirdscene);
         root4.getChildren().add(gp_ts);
         root4.getChildren().add(letter1_ts);
         root4.getChildren().add(letter2_ts);
         root4.getChildren().add(letter3_ts);
         root4.getChildren().add(nextButton_ts);
         root4.getChildren().add(enterButton_ts);
     //End of display     

    /*
    * Start of the fourth picutre scene
    */

    //Beginning of second slide scene
    Pane root5 = new Pane();
    fourthScene = new Scene(root5, 750, 500);
    ImageView backGround_frs = new ImageView(backGroundImage);
    backGround_frs.setFitHeight(500);
    backGround_frs.setFitWidth(750);
    window.setResizable(false);
    GridPane gp_frs = new GridPane();
    gp_frs.setPadding(new Insets(30));
    gp_frs.setHgap(10);
    gp_frs.setVgap(10);
 //End of opening scene

 //Next Button from third scene to fourth scene
     Button nextButton_frs = new Button("Next");
     nextButton_frs.setFont(new Font("Comic Neue Angular Bold", 25));
     nextButton_frs.setOnAction(e -> window.setScene(fifthScene));
     nextButton_frs.setTranslateX(598);   //Width
     nextButton_frs.setTranslateY(100);   //Height
 //End of next button

 //Textfield input of answer
  TextField letter1_frs = new TextField();
  letter1_frs.setPrefSize(60, 40);
  letter1_frs.setTranslateX(200);
  letter1_frs.setTranslateY(275);
  letter1_frs.setAlignment(Pos.CENTER);
 //End of Textfield
 
 //Textfield input of answer
  TextField letter2_frs = new TextField();
  letter2_frs.setPrefSize(60, 40);
  letter2_frs.setTranslateX(332.5);
  letter2_frs.setTranslateY(275);
  letter2_frs.setAlignment(Pos.CENTER);
 //End of Textfield

 //Textfield input of answer
  TextField letter3_frs = new TextField();
  letter3_frs.setPrefSize(60, 40);
  letter3_frs.setTranslateX(465);
  letter3_frs.setTranslateY(275);
  letter3_frs.setAlignment(Pos.CENTER);
 //End of Textfield

 //Start of alphabet button display 
     Button aButton_frs = new Button("a");
     aButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(aButton_frs, 8, 34);
     aButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "a";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
             
         }
     }); 

     Button bButton_frs = new Button("b");
     bButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(bButton_frs, 9, 34);
     bButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "b";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button cButton_frs = new Button("c");
     cButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(cButton_frs, 10, 34);
     cButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "c";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button dButton_frs = new Button("d");
     dButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(dButton_frs, 11, 34);
     dButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "d";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button eButton_frs = new Button("e");
     eButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(eButton_frs, 12, 34);
     eButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "e";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button fButton_frs = new Button("f");
     fButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(fButton_frs, 13, 34);
     fButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "f";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button gButton_frs = new Button("g");
     gButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(gButton_frs, 14, 34);
     gButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "g";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button hButton_frs = new Button("h");
     hButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(hButton_frs, 15, 34);
     hButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "h";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button iButton_frs = new Button("i");
     iButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(iButton_frs, 16, 34);
     iButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "i";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button jButton_frs = new Button("j");
     jButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(jButton_frs, 17, 34);
     jButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "j";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     });

     Button kButton_frs = new Button("k");
     kButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(kButton_frs, 18, 34);
     kButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "k";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button lButton_frs = new Button("l");
     lButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(lButton_frs, 19, 34);
     lButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "l";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button mButton_frs = new Button("m");
     mButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(mButton_frs, 20, 34);
     mButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "m";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

 //Start of the second line
     Button nButton_frs = new Button("n");
     nButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(nButton_frs, 8, 35);
     nButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "n";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button oButton_frs = new Button("o");
     oButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(oButton_frs, 9, 35);
     oButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "o";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button pButton_frs = new Button("p");
     pButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(pButton_frs, 10, 35);
     pButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "p";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button qButton_frs = new Button("q");
     qButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(qButton_frs, 11, 35);
     qButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "q";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button rButton_frs = new Button("r");
     rButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(rButton_frs, 12, 35);
     rButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "r";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button sButton_frs = new Button("s");
     sButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(sButton_frs, 13, 35);
     sButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "s";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 
     
     Button tButton_frs = new Button("t");
     tButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(tButton_frs, 14, 35);
     tButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "t";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button uButton_frs = new Button("u");
     uButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(uButton_frs, 15, 35);
     uButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "u";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 

     Button vButton_frs = new Button("v");
     vButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(vButton_frs, 16, 35);
     vButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "v";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 
     
     Button wButton_frs = new Button("w");
     wButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(wButton_frs, 17, 35);
     wButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "w";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 
     
     Button xButton_frs = new Button("x");
     xButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(xButton_frs, 18, 35);
     xButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "x";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 
     
     Button yButton_frs = new Button("y");
     yButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(yButton_frs, 19, 35);
     yButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "y";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 
     
     Button zButton_frs = new Button("z");
     zButton_frs.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_frs.add(zButton_frs, 20, 35);
     zButton_frs.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "z";
             letterFill(letter, letter1_frs, letter2_frs, letter3_frs);
         }
     }); 
 //Start of alphabet button display

 //Start of Pig image
     Image fourthsceneimage = new Image("Bed.jpg");
     ImageView fourthscene = new ImageView(fourthsceneimage);
     fourthscene.setFitHeight(200);
     fourthscene.setFitWidth(325);
     fourthscene.relocate(200, 50);
 //End of Mop image

 //Enter button 1
     Button enterButton_frs = new Button("Enter");
     enterButton_frs.setFont(new Font("Comic Neue Angular Bold", 25));
     enterButton_frs.setTranslateX(598);
     enterButton_frs.setTranslateY(175);
 //End of enter button 1
 
 //Getting the user input
     enterButton_frs.setOnAction(new EventHandler<ActionEvent>(){
         public void handle (ActionEvent event){
             storedletter1 = letter1_frs.getText();
             storedletter2 = letter2_frs.getText();
             storedletter3 = letter3_frs.getText();
             //Writting the text to a file
             output.println(storedletter1 + " " + storedletter2 + " " + storedletter3 + "\n");
             //End of writting 
         }
     });
 //End of getting file name

 //Beginning of display 
     root5.getChildren().add(backGround_frs);
     root5.getChildren().add(fourthscene);
     root5.getChildren().add(gp_frs);
     root5.getChildren().add(letter1_frs);
     root5.getChildren().add(letter2_frs);
     root5.getChildren().add(letter3_frs);
     root5.getChildren().add(nextButton_frs);
     root5.getChildren().add(enterButton_frs);
 //End of display  
 
     /*
    * Start of the fifth picutre scene
    */

    //Beginning of second slide scene
    Pane root6 = new Pane();
    fifthScene = new Scene(root6, 750, 500);
    ImageView backGround_fts = new ImageView(backGroundImage);
    backGround_fts.setFitHeight(500);
    backGround_fts.setFitWidth(750);
    window.setResizable(false);
    GridPane gp_fts = new GridPane();
    gp_fts.setPadding(new Insets(30));
    gp_fts.setHgap(10);
    gp_fts.setVgap(10);
 //End of opening scene

 //Next Button from third scene to fourth scene
     Button nextButton_fts = new Button("Next");
     nextButton_fts.setFont(new Font("Comic Neue Angular Bold", 25));
     nextButton_fts.setOnAction(e -> window.setScene(openingScene));
     nextButton_fts.setTranslateX(598);   //Width
     nextButton_fts.setTranslateY(100);   //Height
 //End of next button

 //Textfield input of answer
  TextField letter1_fts = new TextField();
  letter1_fts.setPrefSize(60, 40);
  letter1_fts.setTranslateX(200);
  letter1_fts.setTranslateY(275);
  letter1_fts.setAlignment(Pos.CENTER);
 //End of Textfield
 
 //Textfield input of answer
  TextField letter2_fts = new TextField();
  letter2_fts.setPrefSize(60, 40);
  letter2_fts.setTranslateX(332.5);
  letter2_fts.setTranslateY(275);
  letter2_fts.setAlignment(Pos.CENTER);
 //End of Textfield

 //Textfield input of answer
  TextField letter3_fts = new TextField();
  letter3_fts.setPrefSize(60, 40);
  letter3_fts.setTranslateX(465);
  letter3_fts.setTranslateY(275);
  letter3_fts.setAlignment(Pos.CENTER);
 //End of Textfield

 //Start of alphabet button display 
     Button aButton_fts = new Button("a");
     aButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(aButton_fts, 8, 34);
     aButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "a";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
             
         }
     }); 

     Button bButton_fts = new Button("b");
     bButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(bButton_fts, 9, 34);
     bButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "b";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button cButton_fts = new Button("c");
     cButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(cButton_fts, 10, 34);
     cButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "c";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button dButton_fts = new Button("d");
     dButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(dButton_fts, 11, 34);
     dButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "d";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button eButton_fts = new Button("e");
     eButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(eButton_fts, 12, 34);
     eButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "e";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button fButton_fts = new Button("f");
     fButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(fButton_fts, 13, 34);
     fButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "f";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button gButton_fts = new Button("g");
     gButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(gButton_fts, 14, 34);
     gButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "g";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button hButton_fts = new Button("h");
     hButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(hButton_fts, 15, 34);
     hButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "h";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button iButton_fts = new Button("i");
     iButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(iButton_fts, 16, 34);
     iButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "i";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button jButton_fts = new Button("j");
     jButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(jButton_fts, 17, 34);
     jButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "j";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     });

     Button kButton_fts = new Button("k");
     kButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(kButton_fts, 18, 34);
     kButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "k";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button lButton_fts = new Button("l");
     lButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(lButton_fts, 19, 34);
     lButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "l";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button mButton_fts = new Button("m");
     mButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(mButton_fts, 20, 34);
     mButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "m";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

 //Start of the second line
     Button nButton_fts = new Button("n");
     nButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(nButton_fts, 8, 35);
     nButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "n";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button oButton_fts = new Button("o");
     oButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(oButton_fts, 9, 35);
     oButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "o";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button pButton_fts = new Button("p");
     pButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(pButton_fts, 10, 35);
     pButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "p";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button qButton_fts = new Button("q");
     qButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(qButton_fts, 11, 35);
     qButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "q";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button rButton_fts = new Button("r");
     rButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(rButton_fts, 12, 35);
     rButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "r";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button sButton_fts = new Button("s");
     sButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(sButton_fts, 13, 35);
     sButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "s";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 
     
     Button tButton_fts = new Button("t");
     tButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(tButton_fts, 14, 35);
     tButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "t";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button uButton_fts = new Button("u");
     uButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(uButton_fts, 15, 35);
     uButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "u";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 

     Button vButton_fts = new Button("v");
     vButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(vButton_fts, 16, 35);
     vButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "v";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 
     
     Button wButton_fts = new Button("w");
     wButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(wButton_fts, 17, 35);
     wButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "w";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 
     
     Button xButton_fts = new Button("x");
     xButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(xButton_fts, 18, 35);
     xButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "x";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 
     
     Button yButton_fts = new Button("y");
     yButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(yButton_fts, 19, 35);
     yButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "y";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 
     
     Button zButton_fts = new Button("z");
     zButton_fts.setFont(new Font("Comic Neue Angular Bold", 15));
     gp_fts.add(zButton_fts, 20, 35);
     zButton_fts.pressedProperty().addListener((o, old, newValue) -> {
         if(newValue) {
             letter = "z";
             letterFill(letter, letter1_fts, letter2_fts, letter3_fts);
         }
     }); 
 //Start of alphabet button display

 //Start of Cup image
     Image fifthsceneimage = new Image("Cup.jpg");
     ImageView fifthscene = new ImageView(fifthsceneimage);
     fifthscene.setFitHeight(200);
     fifthscene.setFitWidth(325);
     fifthscene.relocate(200, 50);
 //End of Cup image

 //Enter button 1
     Button enterButton_fts = new Button("Enter");
     enterButton_fts.setFont(new Font("Comic Neue Angular Bold", 25));
     enterButton_fts.setTranslateX(598);
     enterButton_fts.setTranslateY(175);
 //End of enter button 1
 
 //Getting the user input
     enterButton_fts.setOnAction(new EventHandler<ActionEvent>(){
         public void handle (ActionEvent event){
             storedletter1 = letter1_fts.getText();
             storedletter2 = letter2_fts.getText();
             storedletter3 = letter3_fts.getText();
             //Writting the text to a file
             output.println(storedletter1 + " " + storedletter2 + " " + storedletter3 + "\n");
             //End of writting 
         }
     });
 //End of getting file name

 //Beginning of display 
     root6.getChildren().add(backGround_fts);
     root6.getChildren().add(fifthscene);
     root6.getChildren().add(gp_fts);
     root6.getChildren().add(letter1_fts);
     root6.getChildren().add(letter2_fts);
     root6.getChildren().add(letter3_fts);
     root6.getChildren().add(nextButton_fts);
     root6.getChildren().add(enterButton_fts);
 //End of display 
} 
    

    public void letterFill(String methodLetter, TextField letter1, TextField letter2, TextField letter3) {
        if(letter1.getText().isEmpty()) {
            letter1.setText(methodLetter);
        }
        else if(letter2.getText().isEmpty() && letter1.getText().isEmpty() == false){
            letter2.setText(methodLetter);
        }
        else if(letter3.getText().isEmpty() && letter2.getText().isEmpty() == false && letter1.getText().isEmpty() == false){
            letter3.setText(methodLetter);
        }
    }
}