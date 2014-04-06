
class Sqr {
	
	final double x;
	final double y;
	final double r;
	
	/*caree initiale*/
	Sqr(){
		x = 600;
		y = 600;
		r = 180;
	}
	
	Sqr(double x, double y ,double r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
	
	public void SqrDraw(){
		StdDraw.square(x, y, r);
	}
	
	public Sqr [] satellize(){
		Sqr [] sat = new Sqr [8];
		double newR = r / 3;
		double emptySpace = 2 * r;
		double ChildX =  x - emptySpace;
		double ChildY =  y - emptySpace;
		
		for (int i = 0; i < 8; i++){
			
			sat [i] = new Sqr(ChildX,ChildY,newR);
			if (i < 2){
				ChildX = ChildX + emptySpace;
			}else if(i < 4){
				ChildY = ChildY + emptySpace;
			}else if(i < 6){
				ChildX = ChildX - emptySpace;
			}else{
				ChildY = ChildY - emptySpace;
			}
		}/* 360 degree*/
		
		return sat;
	}

}

public class tapis {
	
	/*show deroule le tapis en appliquant la methode draw de chaque caree du tableau*/
	public static void show(Sqr [] sat){
		for(Sqr C : sat){
			C.SqrDraw();
		}
	}
	
	/*Construit et affiche le tapis en prenant un carre de base et nbr de repetitions,*/
	public static void tap(Sqr [] grid, int nb){
		if(nb == 0){
			/*fin*/
		}else{
			Sqr [] C;
			for (int i = 0; i < grid.length ; i++){
			 C = grid[i].satellize();
			show(C);
			tap(C,nb - 1);
			}
			
		}
		
		
	}

	public static void main (String[] args){
		StdDraw.setXscale(0,1200);
		StdDraw.setYscale(0,1200);
		
		Sqr[] base = new Sqr[1];
		
		Sqr C = new Sqr();
		base[0] = C;
		/* base est la un tableau avec un unique caree, c'est la base de lafigure*/
		
		tap(base, 4);
		
		/*On transmet cette base avec un niveau de repetition*/
		
	
		
		C.SqrDraw();
		
	}
}

