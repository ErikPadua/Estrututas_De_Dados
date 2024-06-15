/** Lista ligada:
    É uma estrutura de dados dinâmica, linear, formada por nós, cada nó é capaz
 de armazenar uma informação é referenciar o próximo nó.
 */
package dataStructure;
public class LinkedList{

    //Atributos
    private Node head;//Nó de início
    private Node tail;//Nó do fim
    private int length;//Números de elementos

    //Construtor da Classe LinkedinList
    public LinkedList(String data){
        if(data != null) length = 1;

        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    //Classe que cria um nó
    public static class Node{
        String data;
        Node next;

        Node(String data){
            this.data = data;
        }
    }

//Métodos de retorno ----------------------------------------------------------

    //Retorna uma String contendo o ultimo elemento da lista
    public void getTail(){
        if(this.tail == null){
            System.out.println("List is empty");
        }
        else{
            System.out.println("Tail: " + tail.data);
        }
    }

    //Retorna uma String contendo o primeiro elemento da lista
    public void getHead(){
        if(this.head == null){
            System.out.println("List is empty");
        }else{
            System.out.println("Head: " + head.data);
        }
    }

    //Retorna o numero de elementos que a lista contém
    public void getLength(){
        System.out.println("Length: " + length);
    }

    //Retorna o elemento que está armazenado no index
    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }

    //Altera o elemento no index indicado
    public boolean set(int index, String data){
        Node temp = get(index);

        if(temp != null){
            temp.data = data;
            return true;
        }

        return false;
    }

//Métodos de listagem ------------------------------------------------------

    //Limpa a lista
    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }


    public boolean isEmpty(){
        return length == 0 ? true : false;
    }

    //Mostra todos os elementos inseridos na lista
    public void print(){
        System.out.println("###############################");
        Node temp = head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("###############################");
    }

//Métodos de inserção --------------------------------------------------------------

    //Insere um novo elemento no fim da lista
    public void append(String data){
        Node newNode = new Node(data);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }

        else{
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    //Insere um novo elemento no início da lista
    public void prepend(String data){
        Node newNode = new Node(data);

        if(length == 0){
            head = newNode;
            tail =newNode;
        }

        else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    //Insere um novo elemento no índice indicado
    public boolean insert(int index,String data){
        if(index < 0 || index > length) return false;

        if(index == 0){
            prepend(data);
            return true;
        }

        if (index == length){
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;

        ++length;

        return true;
    }

//Métodos de Remoção ---------------------------------------------------------------------

    //Remove o elemento no fim da lista
    public Node removeLast(){
        if (length == 0) return null;

        Node pre = head;
        Node temp = null;

        while (pre.next != tail){
            pre = pre.next;
        }

        temp = tail;
        tail = pre;
        tail.next = null;//Retira o sucessor

        length--;

        if(length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    //Remove o elemento do início da tabela
    public Node removeFirst(){
        if(length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;

        length--;

        if (length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

    //Remove o elemento no índice indicado
    public Node delete(int index){
        if(index < 0 || index > length) return null;

        if(index == 0) return removeFirst();

        if(index == length)return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

        length--;

        return temp;
    }
}
