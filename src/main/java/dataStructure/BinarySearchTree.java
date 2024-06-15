/** Árvore binária de busca:
    A árvore binária de busca é uma estrutura de dados de árvore binária, onde todos
    os nós da sub-árvore esquerda possuem um valor numérico inferior ou igual ao nó
    raiz e todos os nós da sub-árvore direita possuem um valor superior ao nó raiz.
 */

package dataStructure;
public class BinarySearchTree {

    //Atributos
    public Node root;

    //Construtor da classe nó
    public class Node {
        private int value;
        public Node left;
        public Node rigth;

        public Node(int value) {
            this.value = value;
        }
    }

    //Adiciona um elemento na árvore seguindo as condiçoes da BST
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(Node root, int value) {
        if (root == null) return;
        if (value == root.value) return;
        if (value > root.value) {
            if (root.rigth == null) root.rigth = new Node(value);
            else insert(root.rigth, value);
        } else {
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);
        }
    }

    //Deleta um nó dado um determinado valor
    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(final Node root, final int value) {
        if (root == null) return null;

        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.rigth = deleteNode(root.rigth, value);
        } else {
            if ((root.left == null) && (root.rigth == null)) {
                return null;
            } else if (root.left == null) {
                return root.rigth;
            } else if (root.rigth == null) {
                return root.left;
            } else {
                int minValue = minValue(root.rigth);
                root.value = minValue;
                root.rigth = deleteNode(root.rigth, minValue);
            }
        }
        return root;
    }

    //Rertona o menor valor de uma àrvore ou de seus filhos
    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    //Retorna os elementos em em ordem crescente
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(final Node node) {
        //E-R-D
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.rigth);
    }

    //Retorna um booleano caso haja o elemento na árvore
    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null) return false;
        if (root.value == value) return true;
        if (value > root.value) return contains(root.rigth, value);
        else return contains(root.left, value);
    }
}
