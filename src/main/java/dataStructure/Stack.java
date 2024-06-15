/**Pilha:
    É uma estrutura de dados ordenado onde o último elemento inserido será o primeiro a ser retirado.
 */
package dataStructure;
public class Stack{

    //Atributos
    private Node top;//Último nó inserido
    private int heigth;//Altura da pilha

    //Construtor da Classe
    public Stack(int value){
        Node newNode = new Node(value);

        top = newNode;
        heigth = 1;
    }

    //Classe responsável por fazer o nó entre os elementos
    public  static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

//Métodos de retorno ---------------------------------------------------------

    //Retorna o último elemento inserido
    public void getTop(){
        if(top == null){
            System.out.println("Pilha vazia");
        }
        else{
            System.out.println("Topo: " + top.value);
        }
    }

    //Retorna a altura da pilha
    public void getHeigth(){
        System.out.println("Altura: " + heigth);
    }

//Método de Listagem -------------------------------------------------------------

    //Imprimi os elementos contidos na lista
    public void print(){
        System.out.println("#############################");
        Node temp = top;

        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#############################");
    }

//Métodos de inserção ----------------------------------------------------------------

    //Insere um novo elemento no topo da pilha
    public void push(int value){
        Node newNode = new Node(value);

        if(heigth == 0){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }

        heigth++;
    }

//Métodos de remoção ------------------------------------------------------------------

    //Remove o último elemento inserido
    public Node pop(){
        if(heigth == 0) return null;

        Node temp = top;
        top = temp.next;
        temp.next = null;

        heigth--;

        return temp;
    }
}
