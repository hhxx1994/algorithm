import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huanghaoxing
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node<E> root;

    public Node<E> add(E data) {
        return add(data, root);
    }

    private Node<E> add(E data, Node<E> node) {
        if (node == null) {
            return new Node<>(data);
        }

        if (node.data.compareTo(data) == 0) {
            return node;
        }

        if (data.compareTo(node.data) < 0) {
            node.left = add(data, node.left);
        } else {
            node.right = add(data, node.right);
        }

        return node;
    }


    public E minimum() {
        if (root == null) {
            return null;
        }
        return minimum(root).data;
    }

    // node 为根查找最小
    private Node<E> minimum(Node<E> node) {
        // base case
        if (node.left == null) {
            return node;
        }

        return minimum(node.left);
    }

    // remove taget , return root
    public Node<E> remove(E target) {
        return remove(root, target);
    }

    private Node<E> remove(Node<E> node, E target) {

        if (node.data.compareTo(target) < 0) {
            node.right = remove(node.right, target);
            return node;
        } else if (node.data.compareTo(target) > 0) {
            node.left = remove(node.left, target);
            return node;
        } else {

            // 坐子树为空
            if (node.left == null) {
                Node<E> nodeRight = node.right;
                node.right = null;
                return nodeRight;
            }

            if (node.right == null) {
                Node<E> nodeLeft = node.left;
                node.left = null;
                return nodeLeft;
            }

            // 左右子树都不为空
            Node<E> minNode = minimum(node.right);
            minNode.left = node.left;
            minNode.right = removeMin(node.right);
            node.left = node.right = null;
            return minNode;

        }
    }

    private Node<E> removeMin(Node<E> node) {
        if (node == null) {
            return null;
        }

        if (node.left == null) {
            Node<E> rightNode = node.right;
            node.right = null;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    public List<E> preTravel() {
        if (root == null) {
            return null;
        }
        List<E> ret = new ArrayList<>();
        LinkedList<Node<E>> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> node = stack.pop();
            ret.add(node.data);
            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return ret;

    }

    private class Command {
        private String inst;
        private Node<E> node;

        public Command(String inst, Node<E> node) {
            this.inst = inst;
            this.node = node;
        }
    }

    public List<E> inTravel() {
        if (root == null) {
            return null;
        }
        List<E> ret = new ArrayList<>();
        LinkedList<Command> commands = new LinkedList<>();
        commands.add(new Command("next", root));
        while (!commands.isEmpty()) {
            Command command = commands.pop();
            if (command.inst.equals("do")) {
                ret.add(command.node.data);
            } else {
                commands.push(new Command("do", command.node));
                if (command.node.right != null) {
                    commands.push(new Command("next", command.node.right));
                }
                if (command.node.left != null) {
                    commands.push(new Command("next", command.node.left));
                }
            }
        }
        return ret;
    }


}
