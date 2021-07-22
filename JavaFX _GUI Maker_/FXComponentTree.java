import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * serves as the tree manager for your FXComponentTree
 * @author Anish
 *
 */
public class FXComponentTree {

	private FXTreeNode root;
	private FXTreeNode cursor;
	
	
	/**
	 * Sets the cursor to the root of the FXComponentTree
	 */
	public void cursorToRoot(){
		cursor = root;
	}
	
	
	/**
	 * Removes the child at the specified index of the FXComponentTree, as
	 *  well as all of its children.
	 * @param index
	 */
	public void deleteChild(int index){
		
		for(int i=index; i< cursor.getChildren().length; i++){
			FXTreeNode temp = cursor.getChildrenNode(i);
			temp = cursor.getChildrenNode(i+1);
		}
	}
	
	
	/**
	 * Adds the given node to the corresponding index of the children array.
	 * Should throw an exception if adding the node at the specified index
	 * makes a hole in the array.
	 * @param index
	 * @param node
	 */
	public void addChild(int index, FXTreeNode node){
		node = cursor.getChildrenNode(index);
	}
	
	
	/**
	 * Sets the current node’s text to the specified text.
	 * @param text
	 */
	public void setTextAtCursor(String text){
		cursor.setText(text);
	}
	
	
	/**
	 * Moves the cursor to the child node of the of the cursor corresponding
	 * to the specified index.
	 * @param index
	 */
	public void cursorToChild(int index){
		cursor = cursor.getChildrenNode(index);
	}
	
	
	/**
	 * Moves the cursor to the parent of the current node.
	 */
	public void cursorToParent(){
		cursor = cursor.getParent();
	}
	
	public void printTree(){
		printTree(root, "");
	}
	
	public void printTree(FXTreeNode text, String prefix){
		System.out.println(prefix + text.getType().toString());
		for(int i = 0; i< text.maxChildren; i++){
			FXTreeNode Node = text.getChildrenNode(i);
			if(Node != null){
				printTree(Node, prefix + "\t");
			}
		}
	}
	
	
	/**
	 * Generates the FXComponentTree based on the file name that is passed in.
	 * @param filename
	 * @return
	 */
	public static FXComponentTree readFromFile(String filename){
		
		File file = new File(filename);
		FXComponentTree tempTree = new FXComponentTree();
		

	    try {

	        Scanner sc = new Scanner(file);
	        
	        while (sc.hasNextLine()) {
	        	
	            String s = sc.nextLine();
	            
	            String [] stringArr = s.split(" ");
	            
	            String position = stringArr[0];
	            ComponentType type = ComponentType.valueOf(stringArr[1]);
	            if(type == null) System.out.println(1);
	            
	            String text = "";
	            if(stringArr.length > 2){
	            	
	            	
	            	for(int i=2; i<stringArr.length; i++){
	            		text = text + stringArr[i] + " ";
	            	}//for
	            }//if
	            
	            String [] stringPos = position.split("-");
	            
	            FXTreeNode newNode = new FXTreeNode();
	            
	            newNode.setText(text);
            	newNode.setType(type);
	            if(stringPos.length == 1){
	            	tempTree.root = newNode;
	          
	            }
	            else{
	            	
	            	FXTreeNode tempNode = tempTree.root;
	            	for(int i=1; i<stringPos.length-1; i++){
		            	
		            	int pos = Integer.valueOf(stringPos[i]);
		            	tempNode = tempNode.getChildrenNode(pos);
		            	
		            }
	            	
	            	int index = Integer.valueOf(stringPos[stringPos.length-1]);
	            	tempNode.setChildAtInd(newNode, index);
	            }
	            
	            
	        }//while
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		
	    return tempTree;
	}
	
	
}
