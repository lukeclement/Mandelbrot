import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.canvas.*;
import javafx.animation.*;
import javafx.scene.image.*;
import java.util.*;
import java.awt.image.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.paint.*;
import java.io.*;
import javax.imageio.*;
import javafx.embed.swing.*;
public class main extends Application{
  public int width=1150;
  public int height=1000;
  public static void main(String[] args){
      launch(args);
  }
  public void start(Stage mainStage){
    mainStage.setTitle("Mandelbrot");
    Group root=new Group();
    Scene scene=new Scene(root);
    mainStage.setScene(scene);

    Canvas canvas=new Canvas(width,height);
    root.getChildren().add(canvas);
    GraphicsContext gc=canvas.getGraphicsContext2D();
    final long startNanoTime=System.nanoTime();

    //The animation stuff
    new AnimationTimer(){
      public int multiplier=500;
      public double centerX=(double)width/2;
      public double centerY=(double)height/2;
      public int x=0;
      public int a=0;
      public int o=0;

      public void handle(long currentNanoTime){
        for(int y=a;y<height;y++){
          double i=((double)(y-centerY)/multiplier);
          double r=((double)(x-centerX)/multiplier);
          //Looping loops
          Complex c=new Complex(r,i);
          Complex z=new Complex(0,0);
          int loops=0;
          while((z.getImaginary()<2.0E+10||z.getReal()<2.0E+10)&&loops<255){
            z=(z.s()).add(c);
            loops++;
          }
          gc.setFill(Color.rgb(loops,loops,loops));
          gc.fillOval(x,y,1,1);
          if(x>width&&o<1){
            x=0;
            o++;
          }
        }
        x++;

      }
    }.start();
    mainStage.show();


  }
}
