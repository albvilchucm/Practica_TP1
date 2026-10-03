package utils;

public class Position {
 private int row;
 private int col;
 
 public Position(int f, int c) {
	 this.row=f;
	 this.col=c;
 }
 
 public int row() {
	 return this.row;
 }
 
 public int col() {
	 return this.col;
 }
 
 public boolean equals (Position position2){
  if (this == position2) return true;
  if (position2 == null) return false;
  return (this.row == position2.row && this.col == position2.col);
     } 
}
