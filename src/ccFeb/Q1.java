package ccFeb;

class Nod{
	int data;
	Nod left;
	Nod right;
	Nod(int data){
		this.data=data;
		this.left=null;
		this.right=null;
		
	}
	
}

public class Q1 {

	static Nod root;
	
	
	public static int height(Nod root,int heigt){
		int h=0;
		if(root==null)
			return heigt;
		if(root!=null) {
			h=Math.max(height(root.left,heigt+1),height(root.right,heigt+1));		
		}
		
		return h;
	}
	
	
	public static void printSpiral(Nod root,int h,boolean left,boolean right){
		
		for(int i=1;i<=h;i++) {
			
			print(root,i,left,right);
			
			left=!left; right=!right;
		}
		
	}
	
	public static void print(Nod root,int h,boolean left,boolean right){
		if(root==null)
			return;
		if(h==1) {
			System.out.print(root.data+" ");
		}
		
		else if(h>1 && left) {
			print(root.left,h-1,left,right);
			print(root.right,h-1,left,right);
		}
		else {
			print(root.right,h-1,left,right);
			print(root.left,h-1,left,right);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean left=true;
		boolean right=false;
		
		Q1 tree = new Q1(); 
	        tree.root = new Nod(1); 
	        tree.root.left = new Nod(2); 
	        tree.root.right = new Nod(3); 
	        tree.root.left.left = new Nod(4); 
	        tree.root.left.right = new Nod(5); 
	        tree.root.right.left = new Nod(6); 
	        tree.root.right.right = new Nod(7); 
	        tree.root.left.left.left = new Nod(8); 
	        tree.root.left.left.right = new Nod(12);
	        tree.root.left.right.right = new Nod(9); 
	        tree.root.right.left.left = new Nod(10); 
	        tree.root.right.right.right = new Nod(11); 
	        
	        int h=height(root,0);
	        
	        printSpiral(root,h,left,right);
	     //   System.out.println(height(root,0));

	}

}
