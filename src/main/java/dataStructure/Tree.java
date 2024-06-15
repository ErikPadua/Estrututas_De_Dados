/**Árvore:
    Cada nó pode possuir no máximo dois filhos. É considerada uma árvore cheia
 quando cada nó possui 2 ou 0 filhos.
 */
package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree{

    //Atributos
    public Node root;

    //Classe do nó
    public static  class Node{
        public int value;
        public Node left;
        public Node rigth;

        public Node(int value){
            this.value = value;
        }

        //Retorna se o elemento analizado é folha (É o ultimo em uma extremidade da árvore)
        public boolean isLeaf(){
            return (this.left == null) && (this.rigth == null);
        }
    }

    //Insire um elemento a árvore
    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }
        else{
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while(queue.size() > 0){
                Node currentNode = queue.remove();
                if(currentNode.left == null){
                    currentNode.left = newNode;
                    break;
                }
                else{
                    queue.add(currentNode.left);
                }
                if(currentNode.rigth == null){
                    currentNode.rigth = newNode;
                    break;
                }
                else{
                    queue.add(currentNode.rigth);
                }
            }
        }
    }

    //Retorna os elementos em pré ordem (É também uma busca em profundidade (DFS))
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(final Node node){
        //R-E-D
        if(node == null)return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.rigth);
    }

    //Retorna os elementos em em ordem
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(final Node node){
        //E-R-D
        if(node == null)return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.rigth);
    }

    //Retorna os elementos em pós ordem
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(final Node node){
        //E-D-R
        if(node == null)return;
        postOrder(node.left);
        postOrder(node.rigth);
        System.out.println(node.value);
    }

    //Busca em largura (BFS)
    public void BFS(){
        if(root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.left != null) queue.add(node.left);
            if(node.rigth != null) queue.add(node.rigth);

            System.out.println(node.value);
        }
    }
}
