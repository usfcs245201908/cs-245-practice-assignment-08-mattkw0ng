public class BST<T extends Comparable<T>>{
	Node root;

	class Node {
        T data;
        Node right;
        Node left;

        Node(T item){
            data = item;
        }

        void setRight(Node right) {
            this.right = right;
        }
        void setLeft(Node left) {
            this.left = left;
        }

        T getData(){
            return data;
        }
    }

    public boolean find(T item){
    	return find(item,root);
    }

    public boolean find(T item, Node node){
    	if(node==null){
    		return false;
    	}else if(node.getData().compareTo(item) == 0){
    		return true;
    	}else if(node.getData().compareTo(item) < 0){
    		return find(item, node.right);
    	}else{
    		return find(item, node.left);
    	}
    }

    public void insert(T item){
    	root = insert(item,root);
    }

    public Node insert(T item, Node node){
    	if(node==null){
    		return new Node(item);
    	}else if(node.getData().compareTo(item) < 0){
    		node.setRight(insert(item, node.right));
    	}else{
    		node.setLeft(insert(item, node.left));
    	}
    	return node;
    }

    public void print(){
    	print(root);
    }

    public void print(Node node){
    	
    	if(node==null){
    		return;
    		//System.out.println(node.getData());
    	}else{
    		print(node.left);
    		System.out.println(node.getData());
    		print(node.right);
    	}
    }

    public void delete(T item) 
    { 
        root = delete(root, item); 
    } 
  
    public Node delete(Node root, T item) 
    { 
        if (root == null){
        	return root;
        }

        if (item.compareTo(root.getData()) < 0){
        	root.setLeft(delete(root.left, item));
        } else if (item.compareTo(root.getData()) > 0){
        	root.setRight(delete(root.right,item));
        } 
        else
        { 
            // node with only one child or no child 
            if (root.left == null){
            	return root.right;
            } 
            else if (root.right == null){
            	return root.left;
            }                  
            root.data = minValue(root.right); 
            root.right = delete(root.right, root.getData()); 
        } 
  
        return root; 
    } 

    public T minValue(Node root) 
    { 
        T minv = root.getData(); 
        while (root.left != null) 
        { 
            minv = root.left.getData(); 
            root = root.left; 
        } 
        return minv; 
    } 
    

}