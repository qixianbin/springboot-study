package com.springboot.airthmetic.binaryTree;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
public class BinaryTree {

    private Node root;
    
    public void preOrder(){
        if(this.root != null)
            this.root.preOrder();
        else
            System.out.println("this root is null");
    }
    
    public void midOrder(){
        if(this.root != null)
            this.root.midOrder();
        else
            System.out.println("this root is null");
    }
    
    public void postOrder(){
        if(this.root != null)
            this.root.postOrder();
        else
            System.out.println("this root is null");
    }
    
    public Node preNode(int no){
        if(this.root != null)
            return root.preSearch(no);
        else
            return null;
    }
    
}

@Data
class BinaryTree2 {
    
    //前序遍历：先输出当前节点，在输出左节点，最后输出右节点
    public void preOrder(Node node){
    
        //输出当前节点
        System.out.println(node);
        
        //向左递归输出
        if(node.getLeft() != null)
            preOrder(node.getLeft());
        
        //向右递归输出
        if(node.getRight() != null)
            preOrder(node.getRight());
    }
    
    //中序遍历：先输出左节点，在输出当前节点，最后输出右节点
    public void midOrder(Node node){
        //向左递归输出
        if(node.getLeft() != null)
            midOrder(node.getLeft());
        
        //输出当前节点
        System.out.println(node);
        
        //向右递归输出
        if(node.getRight() != null)
            midOrder(node.getRight());
    }
    
    //后序遍历：先输出左节点，在输出右节点，最后输出当前节点
    public void postOrder(Node node){
        //向左递归输出
        if(node.getLeft() != null)
            postOrder(node.getLeft());
        
        //向右递归输出
        if(node.getRight() != null)
            postOrder(node.getRight());
        
        //输出当前节点
        System.out.println(node);
    }
    
}

@Data
@ToString
@RequiredArgsConstructor
class Node{
    @NonNull
    private int no;
    @NonNull
    private String name;
    @ToString.Exclude
    private Node left;
    @ToString.Exclude
    private Node right;
    
    //前序遍历：先输出当前节点，再输出左节点，最后输出右节点
    public void preOrder(){
        //先输出当前节点
        System.out.println(this);
        //向左递归输出
        if(this.left != null)
            this.left.preOrder();
        
        //向右递归输出
        if(this.right != null)
            this.right.preOrder();
    }
    
    //中序遍历：先输出左节点，在输出当前节点，最后输出右节点
    public void midOrder(){
        //向左递归输出
        if(this.left != null)
            this.left.midOrder();
        //输出当前节点
        System.out.println(this);
        //向右递归输出
        if(this.right != null)
            this.right.midOrder();
    }
    
    //后序遍历：先输出左节点，在输出右节点，最后输出当前节点
    public void postOrder(){
        //向左递归输出
        if(this.left != null)
            this.left.postOrder();

        //向右递归输出
        if(this.right != null)
            this.right.postOrder();
    
        //输出当前节点
        System.out.println(this);
    }
    
    //前序查找：先判断当前节点是否满足，再判断左节点是否满足，最后判断右节点是否满足
    public Node preSearch(int no){
        //先判断当前节点
        if (this.no == no)
            return this;
        //向左递归判断
        Node node = null;
        if(this.left != null)
            node = this.left.preSearch(no);
        if (node != null)
            return node;
    
        //向右递归判断
        if(this.right != null)
            node = this.right.preSearch(no);
        
        return node;
    }
    //中序查找：先判断左节点是否满足，再判断当前节点是否满足，最后判断右节点是否满足
    public Node midSearch(int no){
 
        //向左递归判断
        Node node = null;
        if(this.left != null)
            node = this.left.preSearch(no);
        if (node != null)
            return node;
    
        //先判断当前节点
        if (this.no == no)
            return this;
    
        //向右递归判断
        if(this.right != null)
            node = this.right.preSearch(no);
    
        return node;
    }
    //后续查找：先判断左节点是否满足，再判断右节点是否满足，最后潘迪当前节点是否满足
    public Node postSearch(int no){
    
        //向左递归判断
        Node node = null;
        if(this.left != null)
            node = this.left.preSearch(no);
        if (node != null)
            return node;
    
        //向右递归判断
        if(this.right != null)
            node = this.right.preSearch(no);
    
        //先判断当前节点
        if (this.no == no)
            return this;
        
        return node;
    }
}

class TestMain{
    public static void main(String[] args) {
        Node node1 = new Node(1, "a");
        Node node2 = new Node(2, "b");
        Node node3 = new Node(3, "c");
        Node node4 = new Node(4, "d");
        Node node5 = new Node(5, "e");
    
        BinaryTree binaryTree = new BinaryTree();
    
        node1.setLeft(node2);
        node2.setRight(node3);
        node1.setRight(node4);
        node4.setRight(node5);
        binaryTree.setRoot(node1);
        
//        System.out.println("方式一=======前序遍历");
//        binaryTree.preOrder();
//        System.out.println("方式一=======中序遍历");
//        binaryTree.midOrder();
//        System.out.println("方式一=======后序遍历");
//        binaryTree.postOrder();
//
//        BinaryTree2 binaryTree2 = new BinaryTree2();
//        System.out.println("方式二=======前序遍历");
//        binaryTree2.preOrder(node1);
//        System.out.println("方式二=======中序遍历");
//        binaryTree2.midOrder(node1);
//        System.out.println("方式二=======后序遍历");
//        binaryTree2.postOrder(node1);
    
        Node node = binaryTree.preNode(5);
        System.out.println("方式一=======前序查找" + node);
        Node nodea = binaryTree.preNode(4);
        System.out.println("方式一=======前序查找" + nodea);
        Node nodeb = binaryTree.preNode(3);
        System.out.println("方式一=======前序查找" + nodeb);
        
        
    }
}