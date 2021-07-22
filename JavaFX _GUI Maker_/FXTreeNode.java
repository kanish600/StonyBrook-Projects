/**
 * 
 * @author Anish
 * Write a fully documented class called FXTreeNode which holds the type of
 *  component being represented, an array of children (null if this will be
 *  a Control), and string for the text (null if this is a Container). 
 */
public class FXTreeNode {

	private String text;
	private ComponentType type;
	private FXTreeNode parent;
	private FXTreeNode[] children;
	final int maxChildren=10;
	
	
	/**
	 * holds the type of component being represented, an array of children 
	 * (null if this will be a Control), and string for the text (null if 
	 * this is a Container).
	 */
	public FXTreeNode(){
		if(type == ComponentType.Button || type == ComponentType.Label || type == ComponentType.TextArea){ //control
			children = null;
		}
		else{
			children = new FXTreeNode[maxChildren];
		}
		
		text = "";
		type = null;
		parent = null;
	}

	/**
	 * getter for the text
	 * @return text
	 */
	public String getText() {
		return text;
	}

	
	/**
	 * setter for the text
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * getter for the Type
	 * @return type
	 */
	public ComponentType getType() {
		return type;
	}

	
	/**
	 * setter for the type
	 * @param type
	 */
	public void setType(ComponentType type) {
		this.type = type;
	}

	
	/**
	 * getter for the parent returning treenode
	 * @return parent
	 */
	public FXTreeNode getParent() {
		return parent;
	}

	
	/**
	 * setter for the parent
	 * @param parent
	 */
	public void setParent(FXTreeNode parent) {
		this.parent = parent;
	}

	
	/**
	 * getter for the children node
	 * @return children
	 */
	public FXTreeNode[] getChildren() {
		return children;
	}

	
	/**
	 * setter for the children
	 * @param children
	 */
	public void setChildren(FXTreeNode[] children) {
		this.children = children;
	}
	
	
	public void setChildAtInd(FXTreeNode node, int index){
		
		if(index >= 10 || index < 0){
			return;
		}
		
		children[index] = node;
		
	}
	
	/**
	 * getter for the children node
	 * @param index
	 * @return
	 */
	public FXTreeNode getChildrenNode(int index){
		return children[index];
	}
	
	
	/**
	 * setter for the children node
	 * @param index
	 * @param children
	 */
	public void setChildrenNode(int index, FXTreeNode[] children){
		children[index] = children[index];
	}
	
}
