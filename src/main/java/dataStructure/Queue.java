/**Fila:
    É uma estrutura de dados ordenada onde o primeiro elemento inserido será o primero a ser retirado.
 */
package dataStructure;
public class Queue {

    //Atributos
    private Node first;//Representa o primeiro nó da fila
    private Node last;//Representa o último nó da fila
    private int length;//Tamanho da fila

    //Construtor da classe
    public Queue(int value){
        Node newNode = new Node(value);

        first = newNode;
        last = newNode;

        length++;
    }

    //Construtor da classe nó
    public static class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

//Métodos de retorno ---------------------------------------------------------------

    //Retorna o primeiro elemento da fila
    public void getFirst(){
        if(length == 0){
            System.out.println("A fila está vazia");
        }
        else{
            System.out.println("First: " + first.value);
        }
    }

    //Retorna o último elemento da fila
    public void getLast(){
        if(length == 0){
            System.out.println("A fila está vazia");
        }
        else{
            System.out.println("Last: " + last.value);
        }
    }

    //retorna o numero de elementos na fila
    public void getLength(){
        System.out.println("Length: " + length);
    }

//Métodos de listagem ------------------------------------------------------------

    //Retorna os valores de todos os elementos da fila
    public void print(){
        System.out.println("#############################");
        Node temp = first;

        while(temp != null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#############################");
    }

//Métodos de Inserção -------------------------------------------------------------

    //Adiciona um novo elemento à fila
    public void enqueue(int value){
        Node newNode = new Node(value);

        if(length == 0){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last = newNode;
        }

        length++;
    }

//métodos de Remoção -----------------------------------------------------------------

    //Remove o primeiro elemento da fila
    public Node dequeue(){
        Node temp = first;
        if(length == 0) return null;
        else if(length == 1){
            first = null;
            last = null;

            length--;

            return null;
        }
        else{
            first = first.next;
            temp.next = null;

            length--;

            return temp;
        }
    }
}
